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
public class ClipRectView extends View {
    public ClipRectView(Context context) {
        super(context);
    }

    public ClipRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ClipRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ClipRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int
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
        int width = (getMeasuredWidth() - bitmap.getWidth()) / 2;
        int height = (getMeasuredHeight() - bitmap.getHeight()) / 2;
        canvas.save();
        canvas.clipRect(width + 50, height + 50, width + bitmap.getWidth() - 50,
                height + bitmap.getHeight() - 50);
        canvas.drawBitmap(bitmap, width, height, null);
        canvas.restore();
    }
}
