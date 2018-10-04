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

import com.example.yuanping.uilist.R;
import com.example.yuanping.uilist.utils.BitmapUtils;

/**
 * @created by PingYuan at 10/4/18
 * @email: husteryp@gmail.com
 * @description:
 */
public class InsertAfterDrawView extends AppCompatImageView {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private RectF mRectF = new RectF();
    private BitmapDrawable mBitmapDrawable;

    public InsertAfterDrawView(Context context) {
        super(context);
    }

    public InsertAfterDrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public InsertAfterDrawView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mBitmapDrawable = new BitmapDrawable(BitmapUtils.getRawBitmap(getResources(), R.drawable
                .batman));
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setBackground(mBitmapDrawable);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        final String text = "Batman";
        int textSize = 40;
        mRectF.left = getLeft();
        mRectF.top = getTop() + 20;
        mRectF.bottom = getTop() + 80;
        mRectF.right = getLeft() + textSize * text.length();
        mPaint.setColor(Color.RED);
        canvas.drawRect(mRectF, mPaint);
        mPaint.setTextSize(textSize);
        mPaint.setColor(Color.parseColor("#FFC107"));
        canvas.drawText(text, mRectF.left, mRectF.top + 40, mPaint);
    }
}
