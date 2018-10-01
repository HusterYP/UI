package com.example.yuanping.uilist.widget.practice2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import com.example.yuanping.uilist.utils.ScreenUtils;

/**
 * @created by PingYuan at 10/1/18
 * @email: husteryp@gmail.com
 * @description:
 */
public class StrokeCapView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public StrokeCapView(Context context) {
        super(context);
    }

    public StrokeCapView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public StrokeCapView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public StrokeCapView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int
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
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(30);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawLine(100, 100, 300, 100, mPaint);
        mPaint.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawLine(100, 200, 300, 200, mPaint);
        mPaint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawLine(100, 300, 300, 300, mPaint);
    }
}
