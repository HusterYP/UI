package com.example.yuanping.uilist.widget.practice7;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 * @created by PingYuan at 10/6/18
 * @email: husteryp@gmail.com
 * @description:
 */
public class ArgbEvaluatorView extends RelativeLayout implements View.OnClickListener {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Button mButton;
    private int color = 0xffff0000;
    private ObjectAnimator mObjectAnimator = ObjectAnimator.ofInt(this, "color",
            0xffff0000, 0xff00ff00);
    private final int RADIUS = 200;

    public ArgbEvaluatorView(Context context) {
        super(context);
    }

    public ArgbEvaluatorView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ArgbEvaluatorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ArgbEvaluatorView(Context context, AttributeSet attrs, int defStyleAttr, int
            defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    {
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

        mPaint.setStyle(Paint.Style.FILL);
        mObjectAnimator.setEvaluator(new ArgbEvaluator());
        mObjectAnimator.setDuration(2000);
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
        int startX = getWidth() / 2 - RADIUS;
        int startY = getHeight() / 2 - RADIUS;
        mPaint.setColor(color);
        canvas.drawCircle(startX, startY, RADIUS, mPaint);
    }

    @Override
    public void onClick(View v) {
        mObjectAnimator.start();
    }

    public void setColor(int color) {
        this.color = color;
        invalidate();
    }
}
