package com.example.yuanping.uilist.widget.practice2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
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
public class XfermodeView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public XfermodeView(Context context) {
        super(context);
    }

    public XfermodeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public XfermodeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public XfermodeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int
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
        Bitmap bitmap1 = BitmapUtils.decodeSampledBitmapFromResource(getResources(), R.drawable
                .batman, 100, 100);
        Bitmap bitmap2 = BitmapUtils.decodeSampledBitmapFromResource(getResources(), R.drawable
                .batman_logo, 100, 100);

        // 需要使用离屏缓冲
        int count = canvas.saveLayer(null, null, Canvas.ALL_SAVE_FLAG);

        Xfermode dstIn = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        canvas.drawBitmap(bitmap1, 0, 0, mPaint);
        mPaint.setXfermode(dstIn);
        canvas.drawBitmap(bitmap2, 0, 0, mPaint);
        mPaint.setXfermode(null);

        Xfermode srcIn = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        canvas.drawBitmap(bitmap1, bitmap1.getWidth() + 50, 0, mPaint);
        mPaint.setXfermode(srcIn);
        canvas.drawBitmap(bitmap2, bitmap1.getWidth() + 50, 0, mPaint);
        mPaint.setXfermode(null);

        Xfermode dstOut = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        canvas.drawBitmap(bitmap1, 0, bitmap1.getHeight() + 50, mPaint);
        mPaint.setXfermode(dstOut);
        canvas.drawBitmap(bitmap2, 0, bitmap1.getHeight() + 50, mPaint);
        mPaint.setXfermode(null);

        canvas.restoreToCount(count);
    }
}
