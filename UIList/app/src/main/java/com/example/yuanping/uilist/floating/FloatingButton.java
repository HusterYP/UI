package com.example.yuanping.uilist.floating;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.yuanping.uilist.R;

/**
 * @created by PingYuan at 11/12/18
 * @email: husteryp@gmail.com
 * @description:
 */
public class FloatingButton extends FrameLayout {

    private FloatingActionButton fabOne;
    private FloatingActionButton fabTwo;
    private FloatingActionButton fabThree;
    private FloatingActionButton fabMenu;
    private boolean isMenuOpen = false;
    private final int DISTANCE = 300;
    private final int DISTANCE2 = 220;

    public FloatingButton(@NonNull Context context) {
        super(context);
    }

    public FloatingButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FloatingButton(@NonNull Context context, @Nullable AttributeSet attrs, int
            defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public FloatingButton(@NonNull Context context, @Nullable AttributeSet attrs, int
            defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.floating_button, this, false);
        addView(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        fabMenu = findViewById(R.id.fab_menu);
        fabOne = findViewById(R.id.fab_one);
        fabTwo = findViewById(R.id.fab_two);
        fabThree = findViewById(R.id.fab_three);
        fabMenu.setOnClickListener(new MenuOnClickListener());
    }

    private void openMenu() {
        isMenuOpen = true;
        int x = (int) fabMenu.getX();
        int y = (int) fabMenu.getY();
        ValueAnimator v1 = ValueAnimator.ofInt(x, x - DISTANCE);
        v1.setDuration(500);
        v1.addUpdateListener(animation -> {
            int l = (int) animation.getAnimatedValue();
            int t = (int) fabOne.getY();
            int r = fabOne.getWidth() + l;
            int b = fabOne.getHeight() + t;
            fabOne.layout(l, t, r, b);
        });
        ValueAnimator v2x = ValueAnimator.ofInt(x, x - DISTANCE2);
        ValueAnimator v2y = ValueAnimator.ofInt(y, y - DISTANCE2);
        v2x.setDuration(500).addUpdateListener(animation -> {
            int l = (int) animation.getAnimatedValue();
            int t = (int) fabTwo.getY();
            int r = fabTwo.getWidth() + l;
            int b = fabTwo.getHeight() + t;
            fabTwo.layout(l, t, r, b);
        });
        v2y.setDuration(500).addUpdateListener(animation -> {
            int t = (int) animation.getAnimatedValue();
            int l = (int) fabTwo.getX();
            int r = fabTwo.getWidth() + l;
            int b = fabTwo.getHeight() + t;
            fabTwo.layout(l, t, r, b);
        });
        ValueAnimator v3 = ValueAnimator.ofInt(y, y - DISTANCE);
        v3.setDuration(500).addUpdateListener(animation -> {
            int t = (int) animation.getAnimatedValue();
            int l = (int) fabThree.getX();
            int r = fabThree.getWidth() + l;
            int b = fabThree.getHeight() + t;
            fabThree.layout(l, t, r, b);
        });
        v1.start();
        v2x.start();
        v2y.start();
        v3.start();
    }

    private void hideMenu() {
        isMenuOpen = false;
        int x = (int) fabOne.getX();
        ValueAnimator v1 = ValueAnimator.ofInt(x, (int) fabMenu.getX());
        v1.setDuration(500);
        v1.addUpdateListener(animation -> {
            int l = (int) animation.getAnimatedValue();
            int t = (int) fabOne.getY();
            int r = fabOne.getWidth() + l;
            int b = fabOne.getHeight() + t;
            fabOne.layout(l, t, r, b);
        });
        x = (int) fabTwo.getX();
        int y = (int) fabTwo.getY();
        ValueAnimator v2x = ValueAnimator.ofInt(x, (int) fabMenu.getX());
        ValueAnimator v2y = ValueAnimator.ofInt(y, (int) fabMenu.getY());
        v2x.setDuration(500).addUpdateListener(animation -> {
            int l = (int) animation.getAnimatedValue();
            int t = (int) fabTwo.getY();
            int r = fabTwo.getWidth() + l;
            int b = fabTwo.getHeight() + t;
            fabTwo.layout(l, t, r, b);
        });
        v2y.setDuration(500).addUpdateListener(animation -> {
            int t = (int) animation.getAnimatedValue();
            int l = (int) fabTwo.getX();
            int r = fabTwo.getWidth() + l;
            int b = fabTwo.getHeight() + t;
            fabTwo.layout(l, t, r, b);
        });
        y = (int) fabThree.getY();
        ValueAnimator v3 = ValueAnimator.ofInt(y, (int) fabMenu.getY());
        v3.setDuration(500).addUpdateListener(animation -> {
            int t = (int) animation.getAnimatedValue();
            int l = (int) fabThree.getX();
            int r = fabThree.getWidth() + l;
            int b = fabThree.getHeight() + t;
            fabThree.layout(l, t, r, b);
        });
        v1.start();
        v2x.start();
        v2y.start();
        v3.start();
    }

    class MenuOnClickListener implements OnClickListener {

        @Override
        public void onClick(View v) {
            if (isMenuOpen)
                hideMenu();
            else
                openMenu();
        }
    }

}
