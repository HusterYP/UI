package com.example.yuanping.uilist.widget.practice2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.EmbossMaskFilter;
import android.graphics.MaskFilter;
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
 * @created by PingYuan at 10/1/18
 * @email: husteryp@gmail.com
 * @description:
 */
public class MaskFilterView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public MaskFilterView(Context context) {
        super(context);
    }

    public MaskFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MaskFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MaskFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int
            defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(ScreenUtils.getScreenWidth(), (ScreenUtils.getScreenHeight() -
                ScreenUtils.dpTopx(48)));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // 需要关闭硬件加速
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        Bitmap bitmap = BitmapUtils.decodeSampledBitmapFromResource(getResources(), R.drawable
                .fuck, 120, 120);
        MaskFilter filter1 = new BlurMaskFilter(100, BlurMaskFilter.Blur.NORMAL);
        mPaint.setMaskFilter(filter1);
        canvas.drawBitmap(bitmap, 0, 0, mPaint);

        MaskFilter filter2 = new BlurMaskFilter(100, BlurMaskFilter.Blur.OUTER);
        mPaint.setMaskFilter(filter2);
        canvas.drawBitmap(bitmap, bitmap.getWidth() + 10, 0, mPaint);

        MaskFilter filter3 = new BlurMaskFilter(100, BlurMaskFilter.Blur.INNER);
        mPaint.setMaskFilter(filter3);
        canvas.drawBitmap(bitmap, 0, bitmap.getHeight() + 10, mPaint);

        MaskFilter filter4 = new EmbossMaskFilter(new float[]{0, 1, 1}, 0.5f, 8, 10);
        mPaint.setMaskFilter(filter4);
        canvas.drawBitmap(bitmap, bitmap.getWidth() + 10, bitmap.getHeight() + 10, mPaint);
    }
}
