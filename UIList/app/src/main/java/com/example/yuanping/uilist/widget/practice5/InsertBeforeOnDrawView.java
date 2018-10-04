package com.example.yuanping.uilist.widget.practice5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v7.widget.AppCompatTextView;
import android.text.Layout;
import android.util.AttributeSet;

import com.example.yuanping.uilist.R;

/**
 * @created by PingYuan at 10/4/18
 * @email: husteryp@gmail.com
 * @description:
 */
public class InsertBeforeOnDrawView extends AppCompatTextView {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private RectF mRectF = new RectF();

    public InsertBeforeOnDrawView(Context context) {
        super(context);
    }

    public InsertBeforeOnDrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public InsertBeforeOnDrawView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mPaint.setColor(Color.parseColor("#FFC107"));
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setText(getResources().getString(R.string.text));
        setTextSize(20);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Layout layout = getLayout();
        mRectF.left = layout.getLineLeft(1);
        mRectF.top = layout.getLineTop(1);
        mRectF.bottom = layout.getLineBottom(1);
        mRectF.right = layout.getLineRight(1);
        canvas.drawRect(mRectF, mPaint);
        mRectF.left = layout.getLineLeft(3);
        mRectF.top = layout.getLineTop(3);
        mRectF.bottom = layout.getLineBottom(3);
        mRectF.right = layout.getLineRight(3);
        canvas.drawRect(mRectF, mPaint);

        super.onDraw(canvas);
    }
}
