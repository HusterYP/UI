package com.example.yuanping.uilist.widget.practice4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import com.example.yuanping.uilist.R;
import com.example.yuanping.uilist.utils.BitmapUtils;
import com.example.yuanping.uilist.utils.ScreenUtils;

/**
 * @created by PingYuan at 10/2/18
 * @email: husteryp@gmail.com
 * @description:
 */
public class CameraRotateXYImp extends View {

    private Camera mCamera = new Camera();

    public CameraRotateXYImp(Context context) {
        super(context);
    }

    public CameraRotateXYImp(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CameraRotateXYImp(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CameraRotateXYImp(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int
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
        Bitmap bitmap = BitmapUtils.getRawBitmap(getResources(), R.mipmap.maps);
        int leftWidth = (getMeasuredWidth() / 2 - bitmap.getWidth()) / 2;
        int rightWidth = (getMeasuredWidth() * 3 / 4 - bitmap.getWidth() / 2);
        int height = (getMeasuredHeight() - bitmap.getHeight()) / 2;

        canvas.save();
        canvas.translate(leftWidth + bitmap.getWidth() / 2, height + bitmap.getHeight() / 2);
        mCamera.save();
        mCamera.rotateX(30);
        mCamera.applyToCanvas(canvas);
        mCamera.restore();
        canvas.drawBitmap(bitmap, -bitmap.getWidth() / 2, -bitmap.getHeight() / 2, null);
        canvas.restore();

        canvas.save();
        canvas.translate(rightWidth + bitmap.getWidth() / 2, height + bitmap.getHeight() / 2);
        mCamera.save();
        mCamera.rotateY(30);
        mCamera.applyToCanvas(canvas);
        mCamera.restore();
        canvas.drawBitmap(bitmap, -bitmap.getWidth() / 2, -bitmap.getHeight() / 2, null);
        canvas.restore();
    }
}
