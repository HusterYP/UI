package com.example.yuanping.uilist.widget.practice2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.graphics.SumPathEffect;
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
public class PathEffectView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Path mPath = new Path();

    public PathEffectView(Context context) {
        super(context);
    }

    public PathEffectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PathEffectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PathEffectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int
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

        mPath.moveTo(20, 50);
        mPath.lineTo(50, 100);
        mPath.lineTo(100, 20);
        mPath.lineTo(150, 100);
        mPath.lineTo(200, 20);
        mPath.lineTo(250, 100);
        mPaint.setPathEffect(new CornerPathEffect(10));
        canvas.drawPath(mPath, mPaint);

        mPath.reset();
        mPath.moveTo(300, 50);
        mPath.lineTo(350, 100);
        mPath.lineTo(400, 20);
        mPath.lineTo(450, 100);
        mPath.lineTo(500, 20);
        mPath.lineTo(550, 100);
        mPaint.setPathEffect(new DiscretePathEffect(20, 5));
        canvas.drawPath(mPath, mPaint);

        mPath.reset();
        mPath.moveTo(300, 150);
        mPath.lineTo(350, 200);
        mPath.lineTo(400, 120);
        mPath.lineTo(450, 200);
        mPath.lineTo(500, 120);
        mPath.lineTo(550, 200);
        mPaint.setPathEffect(new DashPathEffect(new float[]{10, 20, 25}, 10));
        canvas.drawPath(mPath, mPaint);

        mPath.reset();
        mPath.moveTo(20, 150);
        mPath.lineTo(50, 200);
        mPath.lineTo(100, 120);
        mPath.lineTo(150, 200);
        mPath.lineTo(200, 120);
        mPath.lineTo(250, 200);
        Path shape = new Path();
        shape.moveTo(5, 0);
        shape.lineTo(0, 10);
        shape.lineTo(10, 10);
        shape.close();
        mPaint.setPathEffect(new PathDashPathEffect(shape, 40, 0, PathDashPathEffect.Style.ROTATE));
        canvas.drawPath(mPath, mPaint);

        mPath.reset();
        mPath.moveTo(20, 250);
        mPath.lineTo(50, 300);
        mPath.lineTo(100, 220);
        mPath.lineTo(150, 300);
        mPath.lineTo(200, 220);
        mPath.lineTo(250, 300);
        PathEffect dashEffect = new DashPathEffect(new float[]{20, 10}, 0);
        PathEffect discreteEffect = new DiscretePathEffect(20, 5);
        mPaint.setPathEffect(new SumPathEffect(dashEffect, discreteEffect));
        canvas.drawPath(mPath, mPaint);

        mPath.reset();
        mPath.moveTo(300, 250);
        mPath.lineTo(350, 300);
        mPath.lineTo(400, 220);
        mPath.lineTo(450, 300);
        mPath.lineTo(500, 220);
        mPath.lineTo(550, 300);
        mPaint.setPathEffect(new DiscretePathEffect(20, 5));
        canvas.drawPath(mPath, mPaint);
    }
}
