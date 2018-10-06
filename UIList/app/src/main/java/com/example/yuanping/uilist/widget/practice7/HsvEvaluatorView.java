package com.example.yuanping.uilist.widget.practice7;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
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
public class HsvEvaluatorView extends RelativeLayout implements View.OnClickListener {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Button mButton;
    private int color = 0xffff0000;
    private ObjectAnimator mObjectAnimator = ObjectAnimator.ofInt(this, "color",
            0xffff0000, 0xff00ff00);
    private final int RADIUS = 200;

    public HsvEvaluatorView(Context context) {
        super(context);
    }

    public HsvEvaluatorView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HsvEvaluatorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public HsvEvaluatorView(Context context, AttributeSet attrs, int defStyleAttr, int
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

        mObjectAnimator.setDuration(2000);
        mObjectAnimator.setEvaluator(new HsvEvaluator());
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

    class HsvEvaluator implements TypeEvaluator<Integer> {

        float[] startHsv = new float[3];
        float[] endHsv = new float[3];
        float[] outHsv = new float[3];

        @Override
        public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
            Color.colorToHSV(startValue, startHsv);
            Color.colorToHSV(endValue, endHsv);

            if (endHsv[0] - startHsv[0] > 180) {
                endHsv[0] -= 360;
            } else if (endHsv[0] - startHsv[0] < -180) {
                endHsv[0] += 360;
            }
            outHsv[0] = startHsv[0] + (endHsv[0] - startHsv[0]) * fraction;
            if (outHsv[0] > 360) {
                outHsv[0] -= 360;
            } else if (outHsv[0] < 0) {
                outHsv[0] += 360;
            }
            outHsv[1] = startHsv[1] + (endHsv[1] - startHsv[1]) * fraction;
            outHsv[2] = startHsv[2] + (endHsv[2] - startHsv[2]) * fraction;

            int alpha = startValue >> 24 + (int) ((endValue >> 24 - startValue >> 24) * fraction);

            return Color.HSVToColor(alpha, outHsv);
        }
    }
}
