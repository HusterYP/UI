package com.example.yuanping.uilist.widget.practice2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import com.example.yuanping.uilist.utils.ScreenUtils;

/**
 * @created by PingYuan at 9/30/18
 * @email: husteryp@gmail.com
 * @description: 线性渐变
 */
public class LinearGradientView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public LinearGradientView(Context context) {
        super(context);
    }

    public LinearGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LinearGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public LinearGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr,
                              int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(ScreenUtils.getScreenWidth(), (ScreenUtils.getScreenHeight() -
                ScreenUtils.dpTopx(48)) / 2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        int radius = 100;
        Shader shader1 = new LinearGradient(width / 6 - radius, height / 2, width / 6 + radius,
                height / 2, Color.parseColor("#E91E63"), Color.parseColor("#2196F3"), Shader
                .TileMode.CLAMP);
        Shader shader2 = new LinearGradient(width / 2 - radius, height / 2, width / 2 + radius,
                height / 2, Color.parseColor("#E91E63"), Color.parseColor("#2196F3"), Shader
                .TileMode.MIRROR);
        Shader shader3 = new LinearGradient(width - width / 6 - radius, height / 2, width - width
                / 6 + radius, height / 2, Color.parseColor("#E91E63"), Color.parseColor
                ("#2196F3"), Shader.TileMode.REPEAT);
        mPaint.setShader(shader1);
        canvas.drawCircle(width / 6, height / 2, radius, mPaint);
        mPaint.setShader(shader2);
        canvas.drawCircle(width / 2, height / 2, radius, mPaint);
        mPaint.setShader(shader3);
        canvas.drawCircle(width - width / 6, height / 2, radius, mPaint);
    }
}
