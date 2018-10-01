package com.example.yuanping.uilist.widget.practice2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
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
public class ShadowLayerView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public ShadowLayerView(Context context) {
        super(context);
    }

    public ShadowLayerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ShadowLayerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ShadowLayerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int
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
        final String text = "HusterYP";
        mPaint.setTextSize(100);
        mPaint.setShadowLayer(10, 0, 0, Color.RED);
        canvas.drawText(text, getMeasuredWidth() / 2 - text.length() / 2 * 50, getMeasuredHeight
                () / 2, mPaint);
    }
}
