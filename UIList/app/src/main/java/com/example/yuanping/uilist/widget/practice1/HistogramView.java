package com.example.yuanping.uilist.widget.practice1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import com.example.yuanping.uilist.utils.ScreenUtils;

/**
 * @created by PingYuan at 9/30/18
 * @email: husteryp@gmail.com
 * @description: 直方图
 */
public class HistogramView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public HistogramView(Context context) {
        super(context);
    }

    public HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int
            defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(ScreenUtils.getScreenWidth(), (ScreenUtils.getScreenHeight() -
                ScreenUtils.dpTopx(48)) / 2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        int histogramMaxWidth = width - 200;
        int histogramMaxHeight = height - 200;
        int itemWidth = histogramMaxWidth / 7 * 4 / 5;
        int itemGap = (histogramMaxWidth - itemWidth * 7) / 8;
        String[] items = {"Froyo", "GB", "ICS", "JB", "KitKat", "L", "M"};
        String title = "直方图";

        // 绘制背景
        canvas.drawColor(Color.parseColor("#2C7E74"));

        // 画坐标和标题
        mPaint.setColor(Color.WHITE);
        canvas.drawLine(100, 50, 100, height - 150, mPaint);
        canvas.drawLine(100, height - 150, width - 100, height - 150, mPaint);
        mPaint.setTextSize(40);
        canvas.drawText(title, width / 2 - 40, height - 50, mPaint);

        // 绘制item
        mPaint.setStyle(Paint.Style.FILL);
        for (int i = 0; i < items.length; i++) {
            mPaint.setColor(Color.parseColor("#0488B7"));
            int left = 100 + itemGap * (i + 1) + itemWidth * i;
            int top = ((int) (Math.random() * histogramMaxHeight));
            int right = 100 + itemGap * (i + 1) + itemWidth * (i + 1);
            int bottom = height - 150;
            canvas.drawRect(left, top, right, bottom, mPaint);
            mPaint.setColor(Color.WHITE);
            mPaint.setTextSize(25);
            canvas.drawText(items[i], left + itemWidth / 2 - items[i].length() * 5, height
                    - 115, mPaint);
        }
    }
}
