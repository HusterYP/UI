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
import android.widget.Toast;

import com.example.yuanping.uilist.R;

/**
 * @created by PingYuan at 10/5/18
 * @email: husteryp@gmail.com
 * @description:
 */
public class TranslationView extends RelativeLayout implements View.OnClickListener {

    private ImageView mImageView;
    private Button mButton;
    private int curState = 0;
    private final int TRANSLATION_X = 0;
    private final int TRANSLATION_Y = 1;
    private final int TRANSLATION_Z = 2;
    private boolean isReset = true;

    public TranslationView(Context context) {
        super(context);
    }

    public TranslationView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TranslationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public TranslationView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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
            case TRANSLATION_X: {
                if (isReset) {
                    mImageView.animate().translationXBy(200).start();
                    isReset = false;
                } else {
                    mImageView.animate().translationXBy(-200).start();
                    curState = TRANSLATION_Y;
                    isReset = true;
                }
                break;
            }
            case TRANSLATION_Y: {
                if (isReset) {
                    mImageView.animate().translationYBy(200).start();
                    isReset = false;
                } else {
                    mImageView.animate().translationYBy(-200).start();
                    curState = TRANSLATION_Z;
                    isReset = true;
                }
                break;
            }
            case TRANSLATION_Z: {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    if (isReset) {
                        mImageView.animate().translationZBy(200).start();
                        isReset = false;
                    } else {
                        mImageView.animate().translationZBy(-200).start();
                        isReset = true;
                        curState = TRANSLATION_X;
                    }
                } else {
                    Toast.makeText(getContext(), String.valueOf("Sorry ! Your Android Version is " +
                            "not support the translationZ()~"), Toast.LENGTH_SHORT).show();
                    curState = TRANSLATION_X;
                }
                break;
            }
            default:
                break;
        }
    }
}
