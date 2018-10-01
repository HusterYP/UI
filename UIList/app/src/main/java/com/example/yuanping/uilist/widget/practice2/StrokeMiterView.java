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
public class StrokeMiterView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Path mPath = new Path();

    public StrokeMiterView(Context context) {
        super(context);
    }

    public StrokeMiterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public StrokeMiterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public StrokeMiterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int
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

        mPath.moveTo(20, 50);
        mPath.lineTo(120, 50);
        mPath.lineTo(20, 150);
        mPaint.setStrokeMiter(2);
        canvas.drawPath(mPath, mPaint);

        mPath.reset();
        mPath.moveTo(200, 50);
        mPath.lineTo(300, 50);
        mPath.lineTo(200, 150);
        mPaint.setStrokeMiter(3);
        canvas.drawPath(mPath, mPaint);

        mPath.reset();
        mPath.moveTo(380, 50);
        mPath.lineTo(480, 50);
        mPath.lineTo(380, 150);
        mPaint.setStrokeMiter(8);
        canvas.drawPath(mPath, mPaint);
    }
}
