package com.example.yuanping.uilist.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.style.MaskFilterSpan;
import android.util.AttributeSet;
import android.util.Log;
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
    private Path mPath = new Path();

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
        textPaint.setTextSize(30);
        textPaint.setColor(Color.WHITE);
        linePaint.setStyle(Paint.Style.STROKE);
        linePaint.setStrokeWidth(5);
        linePaint.setStrokeCap(Paint.Cap.ROUND);
        linePaint.setColor(Color.parseColor("#BCACA8"));
        String[] items = {"Lollipop", "KitKat", "Jelly Bean", "Ice Cream Sandwich",
                "Gingerbread", "Froyo", "Marshmallow"};

        // 绘制背景
        canvas.drawColor(Color.parseColor("#2C7E74"));

        // 绘制饼图
        piePaint.setColor(Color.RED);
        canvas.drawArc(new RectF(centerX - radius - 20, centerY - radius - 20, centerX + radius -
                20, centerY + radius - 20), 180, 122, true, piePaint);
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
        mPath.moveTo((float) (centerX - 20 - radius * Math.cos(60 * Math.PI / 180)), (float)
                (centerY - 20 - radius * Math.sin(60 * Math.PI / 180)));
        mPath.lineTo((float) (centerX - 20 - (radius + 60) * Math.cos(60 * Math.PI / 180)),
                (float) (centerY - 20 - (radius + 60) * Math.sin(60 * Math.PI / 180)));
        mPath.lineTo((float) (centerX - 20 - (radius + 60) * Math.cos(60 * Math.PI / 180)) -
                150, (float) (centerY - 20 - (radius + 60) * Math.sin(60 * Math.PI / 180)));
        canvas.drawPath(mPath, linePaint);
        canvas.drawText(items[0], (float) (centerX - 20 - (radius + 60) * Math.cos(60 * Math.PI
                / 180)) - 150 - items[0].length() * 18, (float) (centerY - 20
                - (radius + 60) * Math.sin(60 * Math.PI / 180)), textPaint);

        mPath.reset();
        mPath.moveTo((float) (centerX - radius * Math.cos(60 * Math.PI / 180)), (float) (centerY
                + radius * Math.sin(60 * Math.PI / 180)));
        mPath.lineTo((float) (centerX - (radius + 60) * Math.cos(60 * Math.PI / 180)), (float)
                (centerY + (radius + 60) * Math.sin(60 * Math.PI / 180)));
        mPath.lineTo((float) (centerX - (radius + 60) * Math.cos(60 * Math.PI / 180)) - 150, (float)
                (centerY + (radius + 60) * Math.sin(60 * Math.PI / 180)));
        canvas.drawPath(mPath, linePaint);
        canvas.drawText(items[1], (float) (centerX - (radius + 60) * Math.cos(60 * Math.PI / 180)
        ) - 150 - items[1].length() * 18, (float) (centerY + (radius + 60) * Math.sin(60 * Math
                .PI / 180)), textPaint);

        mPath.reset();
        mPath.moveTo((float) (centerX + radius * Math.cos(30 * Math.PI / 180)) + 5, (float) (centerY
                + radius * Math.sin(30 * Math.PI / 180)));
        mPath.lineTo((float) (centerX + (radius + 60) * Math.cos(30 * Math.PI / 180)) + 5, (float)
                (centerY + (60 + radius) * Math.sin(30 * Math.PI / 180)));
        mPath.lineTo((float) (centerX + (radius + 60) * Math.cos(30 * Math.PI / 180)) + 60, (float)
                (centerY + (60 + radius) * Math.sin(30 * Math.PI / 180)));
        canvas.drawPath(mPath, linePaint);
        canvas.drawText(items[2], (float) (centerX + (radius + 60) * Math.cos(30 * Math.PI / 180)
        ) + 80, (float) (centerY + (60 + radius) * Math.sin(30 * Math.PI / 180)), textPaint);

        mPath.reset();
        mPath.moveTo((float) (centerX + radius * Math.cos(5 * Math.PI / 180)), (float) (centerY +
                radius * Math.sin(5 * Math.PI / 180)));
        mPath.lineTo((float) (centerX + radius * Math.cos(5 * Math.PI / 180)) + 30, (float)
                (centerY + radius * Math.sin(5 * Math.PI / 180)));
        mPath.lineTo((float) (centerX + radius * Math.cos(5 * Math.PI / 180) + 50 * Math.sin(45 *
                Math.PI / 180)) + 30, (float) (centerY + radius * Math.sin(5 * Math.PI / 180) +
                50 * Math.sin(45 * Math.PI / 180)));
        canvas.drawPath(mPath, linePaint);
        canvas.drawText(items[3], (float) (centerX + radius * Math.cos(5 * Math.PI / 180) + 50 *
                Math.sin(45 * Math.PI / 180) - 30), (float) (centerY + radius * Math.sin(5 * Math
                .PI / 180) + 50 * Math.sin(45 * Math.PI / 180)) + 30, textPaint);

        mPath.reset();
        mPath.moveTo((float) (centerX + radius * Math.cos(-5 * Math.PI / 180) + 5), (float)
                (centerY + radius * Math.sin(-5 * Math.PI / 180)));
        mPath.lineTo((float) (centerX + radius * Math.cos(-5 * Math.PI / 180) + 5) + 30, (float)
                (centerY + radius * Math.sin(-5 * Math.PI / 180)));
        mPath.lineTo((float) (centerX + radius * Math.cos(-5 * Math.PI / 180) + 5 + 50 * Math.sin
                (45 * Math.PI / 180)) + 30, (float) (centerY + radius * Math.sin(-5 * Math.PI /
                180) - 50 * Math.sin(45 * Math.PI / 180)));
        canvas.drawPath(mPath, linePaint);
        canvas.drawText(items[4], (float) (centerX + radius * Math.cos(-5 * Math.PI / 180) + 5 +
                50 * Math.sin(45 * Math.PI / 180)) + 30, (float) (centerY + radius * Math.sin(-5 *
                Math.PI / 180) - 50 * Math.sin(45 * Math.PI / 180)), textPaint);

        mPath.reset();
        mPath.moveTo((float) (centerX + radius * Math.cos(36 * Math.PI / 180)), (float) (centerY
                - radius * Math.sin(36 * Math.PI / 180)));
        mPath.lineTo((float) (centerX + (radius + 50) * Math.cos(36 * Math.PI / 180)), (float)
                (centerY - (radius + 50) * Math.sin(36 * Math.PI / 180)));
        mPath.lineTo((float) (centerX + (radius + 50) * Math.cos(36 * Math.PI / 180)) + 60, (float)
                (centerY - (radius + 50) * Math.sin(36 * Math.PI / 180)));
        canvas.drawPath(mPath, linePaint);
        canvas.drawText(items[6], (float) (centerX + (radius + 50) * Math.cos(36 * Math.PI / 180)
        ) + 80, (float) (centerY - (radius + 50) * Math.sin(36 * Math.PI / 180)), textPaint);

//        piePaint.setStyle(Paint.Style.STROKE);
//        piePaint.setColor(Color.WHITE);
//        piePaint.setStrokeWidth(4);
//        canvas.drawCircle(centerX, centerY, radius, piePaint);

        // 绘制标题
        textPaint.setTextSize(40);
        canvas.drawText(title, centerX - title.length() / 2 * 40, height - 50, textPaint);
    }
}
