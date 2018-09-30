package com.example.yuanping.uilist.widget.practice2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ComposeShader;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import com.example.yuanping.uilist.R;
import com.example.yuanping.uilist.utils.ScreenUtils;

import javax.xml.validation.TypeInfoProvider;

/**
 * @created by PingYuan at 9/30/18
 * @email: husteryp@gmail.com
 * @description:
 */
public class ComposeShaderView extends View {

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public ComposeShaderView(Context context) {
        super(context);
    }

    public ComposeShaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ComposeShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ComposeShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int
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
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
        Shader bitmapShader1 = new BitmapShader(bitmap1, Shader.TileMode.CLAMP, Shader.TileMode
                .CLAMP);
        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.batman_logo);
        Shader bitmapShader2 = new BitmapShader(bitmap2, Shader.TileMode.CLAMP, Shader.TileMode
                .CLAMP);
        Shader composeShader = new ComposeShader(bitmapShader1, bitmapShader2, PorterDuff.Mode
                .DST_IN);
        // 需要关闭硬件加速
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        mPaint.setShader(composeShader);
        canvas.drawCircle(width / 2, height / 2, Math.max(bitmap2.getWidth(), bitmap2.getHeight()
        ) / 2, mPaint);
    }
}
