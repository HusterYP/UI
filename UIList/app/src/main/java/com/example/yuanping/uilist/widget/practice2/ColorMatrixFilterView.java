package com.example.yuanping.uilist.widget.practice2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import com.example.yuanping.uilist.R;
import com.example.yuanping.uilist.utils.BitmapUtils;
import com.example.yuanping.uilist.utils.ScreenUtils;

/**
 * @created by PingYuan at 9/30/18
 * @email: husteryp@gmail.com
 * @description:
 */
public class ColorMatrixFilterView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public ColorMatrixFilterView(Context context) {
        super(context);
    }

    public ColorMatrixFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ColorMatrixFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ColorMatrixFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr,
                                 int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(ScreenUtils.getScreenWidth(), (ScreenUtils.getScreenHeight() -
                ScreenUtils.dpTopx(48)) / 2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        float[] cm = new float[]{
                1, 0, 0, 0, 54,// 红色值
                0, 1, 0, 0, 194,// 绿色值
                0, 0, 1, 0, 65,// 蓝色值
                0, 0, 0, 1, 0 // 透明度
        };
        ColorFilter colorFilter = new ColorMatrixColorFilter(cm);
        mPaint.setColorFilter(colorFilter);
        Bitmap bitmap = BitmapUtils.decodeSampledBitmapFromResource(getResources(), R.drawable
                .batman, 150, 150);
        canvas.drawBitmap(bitmap, width / 2 - bitmap.getWidth() / 2, height / 2 - bitmap
                .getHeight() / 2, mPaint);
    }
}
