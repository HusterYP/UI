package com.example.yuanping.uilist.widget.practice5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * @created by PingYuan at 10/4/18
 * @email: husteryp@gmail.com
 * @description:
 */
public class OnDrawLayoutView extends LinearLayout {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public OnDrawLayoutView(Context context) {
        super(context);
    }

    public OnDrawLayoutView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public OnDrawLayoutView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public OnDrawLayoutView(Context context, AttributeSet attrs, int defStyleAttr, int
            defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    {
        setWillNotDraw(false);
        mPaint.setColor(Color.parseColor("#FFC107"));
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

        for (int i = 0; i < 4; i++) {
            int radius = (int) (Math.random() * 50);
            canvas.drawCircle((float) (Math.random() * (getWidth() - radius)), (float) (Math
                    .random() * (getHeight() - radius)), radius, mPaint);
        }
    }
}
