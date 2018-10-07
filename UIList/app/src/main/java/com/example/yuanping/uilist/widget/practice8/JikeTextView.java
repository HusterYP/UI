package com.example.yuanping.uilist.widget.practice8;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @created by PingYuan at 10/7/18
 * @email: husteryp@gmail.com
 * @description: 即刻点赞时的Text显示
 */
public class JikeTextView extends View {

    private int curCount = 0;
    private Paint mStableTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG); // 固定不变值的画笔
    private Paint mNewTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG); // 新值Paint
    private Paint mOldTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG); // 旧值Paint
    private final int HEIGHT = 200; // 文字高度
    private final int TEXT_SIZE = 60; // 文字大小
    private final int centerY = 116;
    private boolean isAdd = true; // 是否是数量增加
    private boolean isInit = false; // 是否初始化时设置值
    private String newAnimateText; // 新值, 需要动画的Text
    private String oldAnimationText; // 旧值, 需要动画的Text
    private float mStableTextWidth;
    private float newAnimateY = 200; // 新值, 基线初始位置
    private float oldAnimateY = 116; // 旧值, 基线初始位置
    private ValueAnimator mValueAnimator = ValueAnimator.ofFloat(0, 100);
    private float newAlpha = 0; // 新值, 初始透明度
    private float oldAlpha = 1; // 旧值, 初始透明度

    public JikeTextView(Context context) {
        super(context);
    }

    public JikeTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public JikeTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mStableTextPaint.setTextSize(TEXT_SIZE);
        mStableTextPaint.setColor(Color.parseColor("#bfbfbf"));
        mValueAnimator.setDuration(200);
        mNewTextPaint.setTextSize(TEXT_SIZE);
        mNewTextPaint.setColor(Color.parseColor("#bfbfbf"));
        mOldTextPaint.setTextSize(TEXT_SIZE);
        mOldTextPaint.setColor(Color.parseColor("#bfbfbf"));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        float width = mStableTextPaint.measureText(String.valueOf(curCount));
        if ((curCount + 1) % 10 == 0) {
            // 如果是999等的形式, 还需要将下一位预留出来
            width = mStableTextPaint.measureText(String.valueOf(curCount + 1));
        }
        setMeasuredDimension((int) width, HEIGHT);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        String text = String.valueOf(curCount);
        if (isInit) {
            isInit = false;
            canvas.drawText(text, 0, centerY, mStableTextPaint);
            return;
        }
        // 画不变的部分
        canvas.drawText(text, 0, text.length() - 1, 0, centerY, mStableTextPaint);
        setAnimateText();
        // 根据基线改变画动的部分
        mNewTextPaint.setAlpha((int) (newAlpha * 255));
        mOldTextPaint.setAlpha((int) (oldAlpha * 255));
        canvas.drawText(newAnimateText, mStableTextWidth, newAnimateY, mNewTextPaint);
        canvas.drawText(oldAnimationText, mStableTextWidth, oldAnimateY, mOldTextPaint);
    }

    private void setAnimateText() {
        String text = String.valueOf(curCount);
        if (isAdd) {
            if (isChangeTwo(true)) {
                newAnimateText = text.substring(text.length() - 2);
                oldAnimationText = String.valueOf(curCount - 1).substring(text.length() - 2);
                mStableTextWidth = mStableTextPaint.measureText(text, 0, text.length() - 2);
            } else {
                newAnimateText = text.substring(text.length() - 1);
                oldAnimationText = String.valueOf(curCount - 1).substring(text.length() - 1);
                mStableTextWidth = mStableTextPaint.measureText(text, 0, text.length() - 1);
            }
        } else {
            if (isChangeTwo(false)) {
                newAnimateText = text.substring(text.length() - 2);
                oldAnimationText = String.valueOf(curCount + 1).substring(text.length() - 2);
                mStableTextWidth = mStableTextPaint.measureText(text, 0, text.length() - 2);
            } else {
                newAnimateText = text.substring(text.length() - 1);
                oldAnimationText = String.valueOf(curCount + 1).substring(text.length() - 1);
                mStableTextWidth = mStableTextPaint.measureText(text, 0, text.length() - 1);
            }
        }
    }

    public void setCurCount(int curCount) {
        this.curCount = curCount;
        isInit = true;
        invalidate();
    }

    public void addCurCount() {
        curCount++;
        isAdd = true;
        mValueAnimator.removeAllUpdateListeners();
        mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float temp = (float) animation.getAnimatedValue();
                newAnimateY = HEIGHT - (HEIGHT - centerY) * temp / 100f;
                oldAnimateY = centerY - centerY * temp / 100f;
                newAlpha = temp / 100f;
                oldAlpha = 1 - temp / 100f;
                invalidate();
            }
        });
        mValueAnimator.start();
    }

    public void decentCurCount() {
        curCount--;
        isAdd = false;
        mValueAnimator.removeAllUpdateListeners();
        mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float temp = (float) animation.getAnimatedValue();
                newAnimateY = centerY * temp / 100f;
                oldAnimateY = centerY + (HEIGHT - centerY) * temp / 100;
                newAlpha = temp / 100f;
                oldAlpha = 1 - temp / 100f;
                invalidate();
            }
        });
        mValueAnimator.start();
    }

    /**
     * @param isAdd 是否是数量增加
     * @return 是否需要对最后两位做动画(即临界值判断)
     */
    private boolean isChangeTwo(boolean isAdd) {
        String text;
        if (isAdd) {
            text = String.valueOf(curCount - 1);
        } else {
            text = String.valueOf(curCount + 1);
        }
        if (text.length() <= 1)
            return false;
        if (isAdd && text.substring(text.length() - 1).equals("9"))
            return true;
        if (!isAdd && text.substring(text.length() - 1).equals("0"))
            return true;
        return false;
    }
}
