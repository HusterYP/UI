package com.example.yuanping.uilist.drag;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
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

    private int mTop = 0;
    private boolean isAtTop = true;

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
        tvHead.layout(0, mTop, r, mTop + tvHead.getMeasuredHeight());
        tvContent.layout(0, mTop + tvHead.getMeasuredHeight(), r, mTop + tvHead.getMeasuredHeight
                () + tvContent.getMeasuredHeight());
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return mDragHelper.shouldInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mDragHelper.processTouchEvent(event);
        if (isAtTop || event.getRawY() > getMeasuredHeight() - tvHead.getMeasuredHeight()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void computeScroll() {
        if (mDragHelper.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        int maxWidth = MeasureSpec.getSize(widthMeasureSpec);
        int maxHeight = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(resolveSizeAndState(maxWidth, widthMeasureSpec, 0),
                resolveSizeAndState(maxHeight, heightMeasureSpec, 0));
    }

    private class MyDragCallBack extends ViewDragHelper.Callback {

        @Override
        public boolean tryCaptureView(@NonNull View child, int pointerId) {
            return child.getId() == R.id.tv_head;
        }

        @Override
        public void onViewPositionChanged(@NonNull View changedView, int left, int top, int dx,
                                          int dy) {
            mTop = top;
            float scaleX = ((float) left) / ScreenUtils.getScreenWidth();
            float scaleY = ((float) top) / ScreenUtils.getScreenHeight();
            float mDragOffset = Math.max(scaleX, scaleY);
            tvHead.setPivotX(tvHead.getMeasuredWidth());
            tvHead.setPivotY(tvHead.getMeasuredHeight());
            tvHead.setScaleX(1 - mDragOffset / 2);
            tvHead.setScaleY(1 - mDragOffset / 2);
            tvContent.setAlpha(1 - mDragOffset);
            requestLayout();
        }

        @Override
        public int clampViewPositionHorizontal(@NonNull View child, int left, int dx) {
            int leftBound = getPaddingLeft();
            int rightBound = getMeasuredWidth() - child.getMeasuredWidth();
            return Math.min(Math.max(left, leftBound), rightBound);
        }

        @Override
        public int clampViewPositionVertical(@NonNull View child, int top, int dy) {
            int topBound = getPaddingTop();
            int bottomBound = getMeasuredHeight() - child.getMeasuredHeight();
            return Math.min(Math.max(topBound, top), bottomBound);
        }

        @Override
        public void onViewReleased(@NonNull View releasedChild, float xvel, float yvel) {
//            if (releasedChild.getTop() > ScreenUtils.getScreenHeight() / 2) {
//                if (mDragHelper.smoothSlideViewTo(releasedChild, 0, 0)) {
//                    ViewCompat.postInvalidateOnAnimation(releasedChild);
//                    postInvalidate();
//                }
//            } else {
//                if (mDragHelper.smoothSlideViewTo(releasedChild, getMeasuredWidth(),
//                        getMeasuredHeight())) {
//                    ViewCompat.postInvalidateOnAnimation(releasedChild);
//                    postInvalidate();
//                }
//            }
            if (isAtTop) {
                if (releasedChild.getTop() < ScreenUtils.getScreenHeight() / 3 &&
                        Math.abs(yvel) < 3000) {
                    isAtTop = true;
                    mDragHelper.settleCapturedViewAt(0, 0);
                } else {
                    isAtTop = false;
                    mDragHelper.settleCapturedViewAt(0, getMeasuredHeight() - releasedChild
                            .getMeasuredHeight());
                }
            } else {
                if (releasedChild.getTop() > ScreenUtils.getScreenHeight() * 2 / 3 &&
                        Math.abs(yvel) < 3000) {
                    isAtTop = false;
                    mDragHelper.settleCapturedViewAt(0, getMeasuredHeight() - releasedChild
                            .getMeasuredHeight());
                } else {
                    isAtTop = true;
                    mDragHelper.settleCapturedViewAt(0, 0);
                }
            }
            invalidate();
        }
    }
}
