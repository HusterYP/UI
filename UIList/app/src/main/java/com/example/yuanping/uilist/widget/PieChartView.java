package com.example.yuanping.uilist.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import com.example.yuanping.uilist.utils.ScreenUtils;

/**
 * @created by PingYuan at 9/30/18
 * @email: husteryp@gmail.com
 * @description: 饼图
 */
public class PieChartView extends View {

    private Paint piePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public PieChartView(Context context) {
        super(context);
    }

    public PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int
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
        int centerX = width / 2;
        int centerY = height / 2 - 50;
        int radius = 300;
        String title = "饼图";

        piePaint.setStyle(Paint.Style.FILL);
        textPaint.setTextSize(20);
        textPaint.setColor(Color.WHITE);
        linePaint.setStrokeWidth(2);
        linePaint.setColor(Color.parseColor("#BCACA8"));

        // 绘制背景
        canvas.drawColor(Color.parseColor("#2C7E74"));

        // 绘制饼图
        piePaint.setColor(Color.RED);
        canvas.drawArc(new RectF(centerX - radius - 20, centerY - radius - 20, centerX + radius -
                20, centerY + radius - 20), 180, 120, true, piePaint);
        piePaint.setColor(Color.parseColor("#0488B7"));
        canvas.drawArc(new RectF(centerX - radius, centerY - radius, centerX + radius, centerY +
                radius), 180, -120, true, piePaint);
        piePaint.setColor(Color.parseColor("#058E32"));
        canvas.drawArc(new RectF(centerX - radius + 5, centerY - radius, centerX + radius + 5,
                centerY + radius), 58, -45, true, piePaint);
        piePaint.setColor(Color.parseColor("#6C7F69"));
        canvas.drawArc(new RectF(centerX - radius + 5, centerY - radius, centerX + radius + 5,
                centerY + radius), 11, -10, true, piePaint);
        piePaint.setColor(Color.parseColor("#BB0FA8"));
        canvas.drawArc(new RectF(centerX - radius + 5, centerY - radius, centerX + radius + 5,
                centerY + radius), -1, -10, true, piePaint);
        piePaint.setColor(Color.parseColor("#E0DE0C"));
        canvas.drawArc(new RectF(centerX - radius + 5, centerY - radius, centerX + radius + 5,
                centerY + radius), -13, -45, true, piePaint);

        // 绘制饼图文字

//        piePaint.setStyle(Paint.Style.STROKE);
//        piePaint.setColor(Color.WHITE);
//        piePaint.setStrokeWidth(4);
//        canvas.drawCircle(centerX, centerY, radius, piePaint);

        // 绘制标题
        textPaint.setTextSize(40);
        canvas.drawText(title, centerX - title.length() / 2 * 40, height - 50, textPaint);
    }
}
