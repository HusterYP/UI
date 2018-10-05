package com.example.yuanping.uilist.widget.practice6;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.yuanping.uilist.R;

import java.util.ArrayList;

/**
 * @created by PingYuan at 10/5/18
 * @email: husteryp@gmail.com
 * @description:
 */
public class InterpolatorView extends RelativeLayout implements View.OnClickListener {

    private Spinner mSpinner;
    private ImageView mImageView;
    private Button mButton;
    private final int TRANSLATE = 300;
    private ArrayList<Interpolator> mInterpolators;

    public InterpolatorView(Context context) {
        super(context);
    }

    public InterpolatorView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public InterpolatorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public InterpolatorView(Context context, AttributeSet attrs, int defStyleAttr, int
            defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    {
        View view = View.inflate(getContext(), R.layout.widget_practice6_interpolator, null);
        addView(view);
        mSpinner = findViewById(R.id.spinner);
        mImageView = findViewById(R.id.music);
        mButton = findViewById(R.id.button);
        mButton.setOnClickListener(this);
        mInterpolators = new ArrayList<>();
        mInterpolators.add(new AccelerateDecelerateInterpolator());
        mInterpolators.add(new LinearInterpolator());
        mInterpolators.add(new AccelerateInterpolator());
        mInterpolators.add(new DecelerateInterpolator());
        mInterpolators.add(new AnticipateInterpolator());
        mInterpolators.add(new OvershootInterpolator());
        mInterpolators.add(new AnticipateOvershootInterpolator());
        mInterpolators.add(new BounceInterpolator());
        mInterpolators.add(new CycleInterpolator(0.5f));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mInterpolators.add(new PathInterpolator(0.5f, 0.5f));
        }
        mInterpolators.add(new FastOutLinearInInterpolator());
        mInterpolators.add(new FastOutSlowInInterpolator());
        mInterpolators.add(new LinearOutSlowInInterpolator());
    }

    @Override
    public void onClick(View v) {
        int position = mSpinner.getSelectedItemPosition();

        if (position == 9 && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            Toast.makeText(getContext(), String.valueOf("Sorry ! Your Android Version does not " +
                    "support to the PathInterpolator"), Toast.LENGTH_SHORT).show();
            return;
        }

        if (position > 9 && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            position--;
        }
        mImageView.animate().translationX(TRANSLATE).setInterpolator(mInterpolators.get
                (position)).setDuration(600).withEndAction(new Runnable() {
            @Override
            public void run() {
                mImageView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mImageView.setTranslationX(0);
                    }
                }, 500);
            }
        }).start();
    }
}
