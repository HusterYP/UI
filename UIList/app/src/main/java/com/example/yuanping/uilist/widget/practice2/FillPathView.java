package com.example.yuanping.uilist.widget.practice2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
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
public class FillPathView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Path mPath = new Path();

    public FillPathView(Context context) {
        super(context);
    }

    public FillPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FillPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public FillPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int
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
        mPath.moveTo(100, 100);
        mPath.lineTo(150, 200);
        mPath.lineTo(200, 50);
        mPath.lineTo(250, 300);
        mPath.lineTo(400, 100);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(40);
        canvas.drawPath(mPath, mPaint);
    }
}
