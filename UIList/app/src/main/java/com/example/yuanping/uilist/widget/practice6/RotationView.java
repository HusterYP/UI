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
public class RotationView extends RelativeLayout implements View.OnClickListener {

    private ImageView mImageView;
    private Button mButton;
    private int curState = 0;
    private boolean isReset = true;
    private final int ROTATION_X = 0;
    private final int ROTATION_Y = 1;
    private final int ROTATION_Z = 2;

    public RotationView(Context context) {
        super(context);
    }

    public RotationView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RotationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public RotationView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    {
        mImageView = new ImageView(getContext());
        mImageView.setImageResource(R.mipmap.music);
        RelativeLayout.LayoutParams imgParams = new RelativeLayout.LayoutParams(ViewGroup
                .LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        imgParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        mImageView.setLayoutParams(imgParams);
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
            case ROTATION_X: {
                if (isReset) {
                    mImageView.animate().rotationXBy(180).start();
                    isReset = false;
                } else {
                    mImageView.animate().rotationXBy(-180).start();
                    isReset = true;
                    curState = ROTATION_Y;
                }
                break;
            }
            case ROTATION_Y: {
                if (isReset) {
                    mImageView.animate().rotationYBy(180).start();
                    isReset = false;
                } else {
                    mImageView.animate().rotationYBy(-180).start();
                    isReset = true;
                    curState = ROTATION_Z;
                }
                break;
            }
            case ROTATION_Z: {
                if (isReset) {
                    mImageView.animate().rotationBy(180).start();
                    isReset = false;
                } else {
                    mImageView.animate().rotationBy(-180).start();
                    isReset = true;
                    curState = ROTATION_X;
                }
                break;
            }
            default:
                break;
        }
    }
}
