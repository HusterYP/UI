package com.example.yuanping.uilist.widget.practice6;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.yuanping.uilist.R;

/**
 * @created by PingYuan at 10/5/18
 * @email: husteryp@gmail.com
 * @description:
 */
public class ViewPropertyAnimatorView extends RelativeLayout implements View.OnClickListener {

    private ImageView mImageView;
    private Button mButton;
    private int curState = 0;
    private final int ANIMATE = 0;
    private final int RESET = 1;

    public ViewPropertyAnimatorView(Context context) {
        super(context);
    }

    public ViewPropertyAnimatorView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewPropertyAnimatorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ViewPropertyAnimatorView(Context context, AttributeSet attrs, int defStyleAttr, int
            defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    {
        mImageView = new ImageView(getContext());
        mImageView.setImageResource(R.mipmap.music);
        RelativeLayout.LayoutParams imgParams = new RelativeLayout.LayoutParams(ViewGroup
                .LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        imgParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        imgParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        imgParams.leftMargin = 100;
        mImageView.setLayoutParams(imgParams);
        mImageView.setScaleX(0);
        mImageView.setScaleY(0);
        addView(mImageView);

        mButton = new Button(getContext());
        mButton.setText("Animate");
        mButton.setAllCaps(false);
        RelativeLayout.LayoutParams btParams = new RelativeLayout.LayoutParams(ViewGroup
                .LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        btParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        btParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        btParams.bottomMargin = 150;
        btParams.rightMargin = 50;
        mButton.setLayoutParams(btParams);
        addView(mButton);

        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (curState) {
            case ANIMATE: {
                mImageView.clearAnimation();
                mImageView.animate().translationXBy(400).alpha(1).scaleX(1f).scaleY(1f)
                        .rotationBy(360).start();
                break;
            }
            case RESET: {
                mImageView.clearAnimation();
                mImageView.animate().translationXBy(-400).alpha(0).scaleX(0f).scaleY(0f)
                        .rotationBy(-360).start();
                break;
            }
            default:
                break;
        }
        curState++;
        if (curState > 1)
            curState = 0;
    }
}
