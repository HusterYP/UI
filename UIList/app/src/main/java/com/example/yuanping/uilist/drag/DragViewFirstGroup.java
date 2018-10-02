package com.example.yuanping.uilist.drag;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.yuanping.uilist.R;

/**
 * @created by PingYuan at 8/3/18
 * @email: husteryp@gmail.com
 * @description: drag a view freely
 */
public class DragViewFirstGroup extends RelativeLayout {

    private ViewDragHelper mDragHelper = ViewDragHelper.create(this, 1.0f, new MyDragCallBack());

    public DragViewFirstGroup(Context context) {
        super(context);
    }

    public DragViewFirstGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DragViewFirstGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public DragViewFirstGroup(Context context, AttributeSet attrs, int defStyleAttr, int
            defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int action = ev.getActionMasked();
        if (action == MotionEvent.ACTION_CANCEL || action == MotionEvent.ACTION_UP) {
            mDragHelper.cancel();
            return false;
        }
        return mDragHelper.shouldInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mDragHelper.processTouchEvent(event);
        return true;
    }

    private class MyDragCallBack extends ViewDragHelper.Callback {

        @Override
        public boolean tryCaptureView(@NonNull View child, int pointerId) {
            if (child.getId() == R.id.drag_view_first_img) {
                return true;
            }
            return false;
        }

        @Override
        public int clampViewPositionHorizontal(@NonNull View child, int left, int dx) {
            final int leftBound = getPaddingLeft();
            final int rightBound = getWidth() - child.getWidth();
            final int newLeft = Math.min(Math.max(left, leftBound), rightBound);
            return newLeft;
        }

        @Override
        public int clampViewPositionVertical(@NonNull View child, int top, int dy) {
            final int topBound = getPaddingTop();
            final int bottomBound = getHeight() - child.getHeight();
            final int newTop = Math.min(Math.max(top, topBound), bottomBound);
            return newTop;
        }
    }

}
