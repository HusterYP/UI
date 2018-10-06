package com.example.yuanping.uilist.widget.practice7;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 * @created by PingYuan at 10/6/18
 * @email: husteryp@gmail.com
 * @description:
 */
public class PropertyValuesHolderOfKeyFrameView extends RelativeLayout implements View
        .OnClickListener {

    private Paint arcPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final int RADIUS = 300;
    private Button mButton;
    private ObjectAnimator mObjectAnimator;
    private int progress = 0;

    public PropertyValuesHolderOfKeyFrameView(Context context) {
        super(context);
    }

    public PropertyValuesHolderOfKeyFrameView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PropertyValuesHolderOfKeyFrameView(Context context, AttributeSet attrs, int
            defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PropertyValuesHolderOfKeyFrameView(Context context, AttributeSet attrs, int
            defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    {
        arcPaint.setColor(Color.RED);
        arcPaint.setStyle(Paint.Style.STROKE);
        arcPaint.setStrokeWidth(50);
        arcPaint.setStrokeCap(Paint.Cap.ROUND);

        textPaint.setTextSize(100);
        textPaint.setTextAlign(Paint.Align.CENTER);

        setWillNotDraw(false);
        mButton = new Button(getContext());
        mButton.setText("Animate");
        RelativeLayout.LayoutParams btParams = new RelativeLayout.LayoutParams(ViewGroup
                .LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        btParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        btParams.addRule(RelativeLayout.ALIGN_PARENT_END);
        btParams.rightMargin = 20;
        btParams.bottomMargin = 20;
        mButton.setLayoutParams(btParams);
        addView(mButton);
        mButton.setOnClickListener(this);

        Keyframe keyframe1 = Keyframe.ofInt(0, 0);
        Keyframe keyframe2 = Keyframe.ofInt(0.5f, 100);
        Keyframe keyframe3 = Keyframe.ofInt(1f, 80);
        PropertyValuesHolder mPropertyValuesHolder = PropertyValuesHolder.ofKeyframe("progress",
                keyframe1, keyframe2, keyframe3);
        mObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(this, mPropertyValuesHolder);
        mObjectAnimator.setDuration(2000);
        mObjectAnimator.setInterpolator(new FastOutSlowInInterpolator());
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        RelativeLayout.LayoutParams rlParams = (LayoutParams) getLayoutParams();
        rlParams.width = LayoutParams.MATCH_PARENT;
        rlParams.height = LayoutParams.MATCH_PARENT;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        String text = progress + "%";
        canvas.drawText(text, centerX, centerY, textPaint);
        canvas.drawArc(new RectF(centerX - RADIUS, centerY - RADIUS, centerX +
                RADIUS, centerY + RADIUS), 120, 360 * progress / 100, false, arcPaint);
    }

    @Override
    public void onClick(View v) {
        if (mObjectAnimator.isRunning())
            mObjectAnimator.end();
        mObjectAnimator.start();
    }

    public void setProgress(int progress) {
        this.progress = progress;
        invalidate();
    }

    public int getProgress() {
        return progress;
    }
}
