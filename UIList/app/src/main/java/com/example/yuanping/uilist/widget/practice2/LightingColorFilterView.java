package com.example.yuanping.uilist.widget.practice2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Shader;
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
public class LightingColorFilterView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public LightingColorFilterView(Context context) {
        super(context);
    }

    public LightingColorFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LightingColorFilterView(Context context, @Nullable AttributeSet attrs, int
            defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public LightingColorFilterView(Context context, @Nullable AttributeSet attrs, int
            defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(ScreenUtils.getScreenWidth(), (ScreenUtils.getScreenHeight() -
                ScreenUtils.dpTopx(48)) / 2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        ColorFilter lightingColorFilter1 = new LightingColorFilter(0x00ffff, 0);
        Bitmap bitmap = BitmapUtils.decodeSampledBitmapFromResource(getResources(), R.drawable
                .batman, 100, 100);
        mPaint.setColorFilter(lightingColorFilter1);
        canvas.drawBitmap(bitmap, 0, 0, mPaint);

        ColorFilter lightingColorFilter2 = new LightingColorFilter(0x00ffff, 0x003000);
        mPaint.setColorFilter(lightingColorFilter2);
        canvas.drawBitmap(bitmap, bitmap.getWidth() + 50, 0, mPaint);
    }
}
