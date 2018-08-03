package com.example.yuanping.uilist.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * @created by PingYuan at 8/3/18
 * @email: husteryp@gmail.com
 * @description: 一个骚气的带点击效果的TextView
 * e...其实就是水波纹, hh, 皮一下
 * @参见: 参考博文 : https://blog.csdn.net/singwhatiwanna/article/details/42614953
 */
public class RippleTextView extends TextView {
    private int downX = 0;
    private int downY = 0;
    private Paint mPaint = new Paint();
    private int MAX_RADIUS = 0;
    private final int DX_RADIUS = 10;
    private int radius = 0;
    private boolean isStart = false;

    public RippleTextView(Context context) {
        super(context);
        init();
    }

    public RippleTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RippleTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public RippleTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int
            defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        mPaint.setAntiAlias(true);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            downX = (int) event.getX();
            downY = (int) event.getY();
            invalidate();
            int maxX = Math.max(getMeasuredWidth() - downX, downX);
            int maxY = Math.max(getMeasuredHeight() - downY, downY);
            MAX_RADIUS = Math.max(maxX, maxY);
            isStart = true;
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (isStart) {
            mPaint.setAlpha(200);
            mPaint.setColor(Color.parseColor("#EAEAEA"));
            canvas.drawCircle(downX, downY, radius, mPaint);
            radius += DX_RADIUS;
            invalidate();
        }
        super.onDraw(canvas);
    }
}
