package com.example.yuanping.uilist.widget.practice5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

import com.example.yuanping.uilist.R;

/**
 * @created by PingYuan at 10/4/18
 * @email: husteryp@gmail.com
 * @description:
 */
public class InsertBeforeDrawView extends AppCompatEditText {

    public InsertBeforeDrawView(Context context) {
        super(context);
    }

    public InsertBeforeDrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public InsertBeforeDrawView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        setText(getResources().getString(R.string.hello));
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawColor(Color.GREEN);
        super.draw(canvas);
    }
}
