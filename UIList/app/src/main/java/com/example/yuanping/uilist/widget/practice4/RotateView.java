package com.example.yuanping.uilist.widget.practice4;

import android.content.Context;
import android.graphics.Bitmap;
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
public class RotateView extends View {
    public RotateView(Context context) {
        super(context);
    }

    public RotateView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RotateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public RotateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int
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
        canvas.rotate(180, leftWidth + bitmap.getWidth() / 2, height + bitmap.getHeight() / 2);
        canvas.drawBitmap(bitmap, leftWidth, height, null);
        canvas.restore();

        canvas.save();
        canvas.rotate(45, rightWidth + bitmap.getWidth() / 2, height + bitmap.getHeight() / 2);
        canvas.drawBitmap(bitmap, rightWidth, height, null);
        canvas.restore();
    }
}
