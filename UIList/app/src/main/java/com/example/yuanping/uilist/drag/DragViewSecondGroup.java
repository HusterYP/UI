package com.example.yuanping.uilist.drag;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.yuanping.uilist.R;
import com.example.yuanping.uilist.utils.ScreenUtils;

/**
 * @created by PingYuan at 8/3/18
 * @email: husteryp@gmail.com
 * @description: an implementation of [blog](http://old.flavienlaurent
 * .com/blog/2013/08/28/each-navigation-drawer-hides-a-viewdraghelper/)
 */
public class DragViewSecondGroup extends ViewGroup {

    private TextView tvHead;
    private TextView tvContent;

    private ViewDragHelper mDragHelper = ViewDragHelper.create(this, 1.0f, new MyDragCallBack());

    public DragViewSecondGroup(Context context) {
        super(context);
    }

    public DragViewSecondGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DragViewSecondGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public DragViewSecondGroup(Context context, AttributeSet attrs, int defStyleAttr, int
            defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        tvHead = findViewById(R.id.tv_head);
        tvContent = findViewById(R.id.tv_content);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        tvHead.layout(0, 0, ScreenUtils.getScreenWidth(), ScreenUtils.dpTopx(180));
        tvContent.layout(0, ScreenUtils.dpTopx(180), ScreenUtils.getScreenWidth(), ScreenUtils
                .getScreenHeight());
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return mDragHelper.shouldInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mDragHelper.processTouchEvent(event);
        return true;
    }

    @Override
    public void computeScroll() {
        if (mDragHelper.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    private class MyDragCallBack extends ViewDragHelper.Callback {

        @Override
        public boolean tryCaptureView(@NonNull View child, int pointerId) {
            if (child.getId() == R.id.tv_head) {
                return true;
            }
            return false;
        }

        @Override
        public void onViewPositionChanged(@NonNull View changedView, int left, int top, int dx,
                                          int dy) {
            float scaleX = ((float) left) / ScreenUtils.getScreenWidth();
            float scaleY = ((float) top) / ScreenUtils.getScreenHeight();
            float mDragOffset = Math.max(scaleX, scaleY);

            tvHead.setPivotX(tvHead.getWidth());
            tvHead.setPivotY(tvHead.getHeight());
            tvHead.setScaleX(1 - mDragOffset / 2);
            tvHead.setScaleY(1 - mDragOffset / 2);
            tvContent.setAlpha(1 - mDragOffset);

            requestLayout();
        }

        @Override
        public int clampViewPositionHorizontal(@NonNull View child, int left, int dx) {
            int leftBound = getPaddingLeft();
            int rightBound = 0;
            return Math.min(Math.max(left, leftBound), rightBound);
        }

        @Override
        public int clampViewPositionVertical(@NonNull View child, int top, int dy) {
            int topBound = getPaddingTop();
            int bottomBound = getMeasuredHeight() - ScreenUtils.dpTopx(180);
            return Math.min(Math.max(topBound, top), bottomBound);
        }
    }
}
