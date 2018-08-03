package com.example.yuanping.uilist.drag;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * @created by PingYuan at 8/3/18
 * @email: husteryp@gmail.com
 * @description:
 * an implementation of [blog](http://old.flavienlaurent.com/blog/2013/08/28/each-navigation-drawer-hides-a-viewdraghelper/)
 */
public class DragViewSecondGroup extends RelativeLayout{

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

    private class MyDragCallBack extends ViewDragHelper.Callback {

        @Override
        public boolean tryCaptureView(@NonNull View child, int pointerId) {
            return false;
        }
    }
}
