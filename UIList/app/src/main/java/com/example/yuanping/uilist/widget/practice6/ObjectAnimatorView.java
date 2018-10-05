package com.example.yuanping.uilist.widget.practice6;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 * @created by PingYuan at 10/5/18
 * @email: husteryp@gmail.com
 * @description:
 */
public class ObjectAnimatorView extends RelativeLayout implements View.OnClickListener {

    private Button mButton;
    private int progress = 0;
    private Paint arcPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final int RADIUS = 300;
    private RectF mRectF = new RectF();
    private ObjectAnimator mObjectAnimator = ObjectAnimator.ofInt(this, "progress", 0, 65);

    public ObjectAnimatorView(Context context) {
        super(context);
    }

    public ObjectAnimatorView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ObjectAnimatorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ObjectAnimatorView(Context context, AttributeSet attrs, int defStyleAttr, int
            defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    {
        setWillNotDraw(false);
        arcPaint.setColor(Color.RED);
        arcPaint.setStyle(Paint.Style.STROKE);
        arcPaint.setStrokeWidth(30);
        arcPaint.setStrokeCap(Paint.Cap.ROUND);
        textPaint.setTextSize(100);
        mButton = new Button(getContext());
        mButton.setOnClickListener(this);
        RelativeLayout.LayoutParams btParams = new RelativeLayout.LayoutParams(ViewGroup
                .LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        btParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        btParams.addRule(RelativeLayout.ALIGN_PARENT_END);
        btParams.rightMargin = 20;
        btParams.bottomMargin = 20;
        mButton.setLayoutParams(btParams);
        addView(mButton);
        mObjectAnimator.setDuration(1000);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        layoutParams.width = LayoutParams.MATCH_PARENT;
        layoutParams.height = LayoutParams.MATCH_PARENT;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        String text = progress + "%";
//        float textWidth = textPaint.measureText(text);
        canvas.drawText(text, centerX, centerY, textPaint);
        mRectF.left = centerX + 125 - RADIUS;
        mRectF.top = centerY - RADIUS;
        mRectF.right = centerX + 125 + RADIUS;
        mRectF.bottom = centerY + RADIUS;
        canvas.drawArc(mRectF, 120, 360 * progress / 100, false, arcPaint);
    }

    @Override
    public void onClick(View v) {
        mObjectAnimator.start();
    }

    public void setProgress(int progress) {
        this.progress = progress;
        invalidate();
    }
}
