package com.example.yuanping.uilist.widget.practice5;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.util.Log;

import com.example.yuanping.uilist.R;
import com.example.yuanping.uilist.utils.BitmapUtils;

/**
 * @created by PingYuan at 10/4/18
 * @email: husteryp@gmail.com
 * @description:
 */
public class InsertAfterOnDrawForegroundView extends AppCompatImageView {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private RectF mRectF = new RectF();
    private BitmapDrawable mBitmapDrawable;

    public InsertAfterOnDrawForegroundView(Context context) {
        super(context);
    }

    public InsertAfterOnDrawForegroundView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public InsertAfterOnDrawForegroundView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mPaint.setColor(Color.parseColor("#FFC107"));
        mPaint.setTextSize(25);
        Bitmap bitmap = BitmapUtils.getRawBitmap(getResources(), R.drawable.batman);
        mBitmapDrawable = new BitmapDrawable(bitmap);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setBackground(mBitmapDrawable);
    }

    // 该方法在API 23之后才引入的, 低版本上无效
    @Override
    public void onDrawForeground(Canvas canvas) {
        super.onDrawForeground(canvas);
        mRectF.left = getLeft();
        mRectF.top = getTop() + 20;
        mRectF.right = getRight();
        mRectF.bottom = getBottom() + 20;
        canvas.drawRect(mRectF, mPaint);
        mPaint.setColor(Color.GRAY);
        canvas.drawText("Batman", mRectF.left, mRectF.top, mPaint);
    }
}
