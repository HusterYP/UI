package com.example.yuanping.uilist.widget.practice7;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
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
public class OfObjectView extends RelativeLayout implements View.OnClickListener {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Button mButton;
    private PointF mPointF = new PointF(50, 50);
    private ObjectAnimator mObjectAnimator = ObjectAnimator.ofObject(this, "position", new
            PointFEvaluator(), new PointF(50, 50), new PointF(600, 600));

    public OfObjectView(Context context) {
        super(context);
    }

    public OfObjectView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public OfObjectView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public OfObjectView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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

        mPaint.setStrokeWidth(100);
        mPaint.setColor(Color.parseColor("#ea9b55"));
        mPaint.setStrokeCap(Paint.Cap.ROUND);

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
        canvas.drawPoint(mPointF.x, mPointF.y, mPaint);
    }

    public void setPosition(PointF position) {
        this.mPointF = position;
        invalidate();
    }

    @Override
    public void onClick(View v) {
        mObjectAnimator.start();
    }

    class PointFEvaluator implements TypeEvaluator<PointF> {

        PointF mPointF = new PointF();

        @Override
        public PointF evaluate(float fraction, PointF startValue, PointF endValue) {
            float x = startValue.x + (fraction * (endValue.x - startValue.x));
            float y = startValue.y + (fraction * (endValue.y - startValue.y));
            mPointF.set(x, y);
            return mPointF;
        }
    }

}
