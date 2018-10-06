package com.example.yuanping.uilist.widget.practice7;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
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
public class PropertyValuesHolderView extends RelativeLayout implements View.OnClickListener {

    private Button mButton;
    private ImageView mImageView;
    private PropertyValuesHolder holder1 = PropertyValuesHolder.ofFloat("scaleX", 0, 1);
    private PropertyValuesHolder holder2 = PropertyValuesHolder.ofFloat("scaleY", 0, 1);
    private PropertyValuesHolder holder3 = PropertyValuesHolder.ofFloat("alpha", 0, 1);
    private ObjectAnimator mObjectAnimator;

    public PropertyValuesHolderView(Context context) {
        super(context);
    }

    public PropertyValuesHolderView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PropertyValuesHolderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PropertyValuesHolderView(Context context, AttributeSet attrs, int defStyleAttr, int
            defStyleRes) {
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
        mImageView.setLayoutParams(imgParams);
        addView(mImageView);

        mObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(mImageView, holder1, holder2,
                holder3);
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
        mObjectAnimator.start();
    }
}
