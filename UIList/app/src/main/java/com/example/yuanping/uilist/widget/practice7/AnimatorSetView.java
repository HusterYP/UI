package com.example.yuanping.uilist.widget.practice7;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
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
 * @created by PingYuan at 10/6/18
 * @email: husteryp@gmail.com
 * @description:
 */
public class AnimatorSetView extends RelativeLayout implements View.OnClickListener {

    private Button mButton;
    private ImageView mImageView;
    private AnimatorSet mAnimatorSet;

    public AnimatorSetView(Context context) {
        super(context);
    }

    public AnimatorSetView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AnimatorSetView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public AnimatorSetView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    {
        mButton = new Button(getContext());
        mButton.setText("Animate");
        RelativeLayout.LayoutParams btParams = new RelativeLayout.LayoutParams(ViewGroup
                .LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        btParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        btParams.addRule(RelativeLayout.ALIGN_PARENT_END);
        btParams.rightMargin = 20;
        btParams.bottomMargin = 20;
        mButton.setLayoutParams(btParams);
        addView(mButton);
        mButton.setOnClickListener(this);

        mImageView = new ImageView(getContext());
        mImageView.setImageResource(R.mipmap.music);
        RelativeLayout.LayoutParams imgParams = new RelativeLayout.LayoutParams(ViewGroup
                .LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        imgParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        imgParams.leftMargin = 100;
        mImageView.setLayoutParams(imgParams);
        addView(mImageView);

        mAnimatorSet = new AnimatorSet();
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(mImageView, "alpha", 0, 1);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(mImageView, "translationX", -200, 200);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(mImageView, "rotation", 0, 1080);
        animator3.setDuration(3000);

        mAnimatorSet.playTogether(animator1, animator2);
        mAnimatorSet.playTogether(animator2, animator3);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        RelativeLayout.LayoutParams rlParams = (LayoutParams) getLayoutParams();
        rlParams.width = LayoutParams.MATCH_PARENT;
        rlParams.height = LayoutParams.MATCH_PARENT;
    }

    @Override
    public void onClick(View v) {
        if (mAnimatorSet.isRunning())
            mAnimatorSet.end();
        mAnimatorSet.start();
    }
}
