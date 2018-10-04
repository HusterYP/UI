package com.example.yuanping.uilist.widget.practice5;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.yuanping.uilist.R;
import com.example.yuanping.uilist.utils.BitmapUtils;

/**
 * @created by PingYuan at 10/4/18
 * @email: husteryp@gmail.com
 * @description:
 */
public class DispatchDrawView extends LinearLayout {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Bitmap mBitmap;

    public DispatchDrawView(Context context) {
        super(context);
    }

    public DispatchDrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DispatchDrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public DispatchDrawView(Context context, AttributeSet attrs, int defStyleAttr, int
            defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    {
        setWillNotDraw(false);
        mPaint.setColor(Color.parseColor("#FFC107"));
        mBitmap = BitmapUtils.getRawBitmap(getResources(), R.drawable.batman);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        layoutParams.width = LayoutParams.WRAP_CONTENT;
        layoutParams.height = LayoutParams.WRAP_CONTENT;
        setOrientation(LinearLayout.VERTICAL);
        ImageView imageView = new ImageView(getContext());
        imageView.setBackground(new BitmapDrawable(mBitmap));
        addView(imageView);
        TextView textView = new TextView(getContext());
        textView.setBackgroundColor(Color.GRAY);
        textView.setTextSize(25);
        textView.setText("Batman");
        addView(textView);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int radius = 50;
        int width = getWidth() - radius;
        int height = getHeight() - radius;
        for (int i = 0; i < 4; i++) {
            canvas.drawCircle((float) (Math.random() * width), (float) (Math.random() * height),
                    (float) (Math.random() * radius), mPaint);
        }
    }
}
