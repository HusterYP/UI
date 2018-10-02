package com.example.yuanping.uilist.widget.practice4;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.example.yuanping.uilist.R;
import com.example.yuanping.uilist.utils.BitmapUtils;
import com.example.yuanping.uilist.utils.ScreenUtils;

/**
 * @created by PingYuan at 10/2/18
 * @email: husteryp@gmail.com
 * @description:
 */
public class FlipboardView extends View {

    private ObjectAnimator mObjectAnimator = ObjectAnimator.ofInt(this, "degree", 0, 180);
    private int degree;
    private Camera mCamera = new Camera();

    public FlipboardView(Context context) {
        super(context);
    }

    public FlipboardView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FlipboardView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public FlipboardView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int
            defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    {
        mObjectAnimator.setDuration(2500);
        mObjectAnimator.setRepeatCount(ValueAnimator.INFINITE);
        mObjectAnimator.setRepeatMode(ValueAnimator.REVERSE);
        mObjectAnimator.setInterpolator(new LinearInterpolator());
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mObjectAnimator.start();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mObjectAnimator.end();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(ScreenUtils.getScreenWidth(), (ScreenUtils.getScreenHeight() -
                ScreenUtils.dpTopx(48)) / 2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap = BitmapUtils.getRawBitmap(getResources(), R.mipmap.maps);

        // 画上半部分
        canvas.save();
        canvas.translate(getMeasuredWidth() / 2, getMeasuredHeight() / 2);
        canvas.clipRect(-bitmap.getWidth() / 2, -bitmap.getHeight() / 2, bitmap.getWidth() / 2, 0);
        canvas.drawBitmap(bitmap, -bitmap.getWidth() / 2, -bitmap.getHeight() / 2, null);
        canvas.restore();

        canvas.save();
        canvas.translate(getMeasuredWidth() / 2, getMeasuredHeight() / 2);
        mCamera.save();
        mCamera.rotateX(degree);
        mCamera.applyToCanvas(canvas);
        mCamera.restore();
        canvas.clipRect(-bitmap.getWidth() / 2, 0, bitmap.getWidth() / 2, bitmap.getHeight() / 2);
        canvas.drawBitmap(bitmap, -bitmap.getWidth() / 2, -bitmap.getHeight() / 2, null);
        canvas.restore();
        bitmap.recycle();
    }

    public void setDegree(int degree) {
        this.degree = degree;
        invalidate();
    }
}
