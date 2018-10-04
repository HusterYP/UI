package com.example.yuanping.uilist.widget.practice5;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.example.yuanping.uilist.R;
import com.example.yuanping.uilist.utils.BitmapUtils;

/**
 * @created by PingYuan at 10/4/18
 * @email: husteryp@gmail.com
 * @description: onDraw()后插
 */
public class InsertAfterOnDrawView extends AppCompatImageView {

    private Bitmap mBitmap;
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final boolean DEBUG = true;

    public InsertAfterOnDrawView(Context context) {
        super(context);
    }

    public InsertAfterOnDrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public InsertAfterOnDrawView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mBitmap = BitmapUtils.getRawBitmap(getResources(), R.drawable.batman);
        mPaint.setTextSize(30);
        mPaint.setColor(Color.parseColor("#FF6100"));
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setBackground(new BitmapDrawable(mBitmap));
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        setLayoutParams(layoutParams);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (DEBUG) {
            canvas.drawText("尺寸: " + mBitmap.getWidth() + " x " + mBitmap.getHeight(), 20, 40,
                    mPaint);
        }
    }
}
