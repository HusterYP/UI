package com.example.yuanping.uilist.widget.practice6;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.yuanping.uilist.R;

/**
 * @created by PingYuan at 10/5/18
 * @email: husteryp@gmail.com
 * @description:
 */
public class DurationView extends RelativeLayout implements View.OnClickListener {

    private SeekBar mSeekBar;
    private TextView mTextView;
    private ImageView mImageView;
    private Button mButton;
    private final int TRANSLATION = 200;
    private boolean isReset = true;

    public DurationView(Context context) {
        super(context);
    }

    public DurationView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DurationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public DurationView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    {
        View view = View.inflate(getContext(), R.layout.widget_practice6_duration_view, null);
        addView(view);
        mSeekBar = findViewById(R.id.seekBar);
        mTextView = findViewById(R.id.progress);
        mButton = findViewById(R.id.button);
        mImageView = findViewById(R.id.music);
        mButton.setOnClickListener(this);
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mTextView.setText(progress+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        int progress = mSeekBar.getProgress();
        if (isReset) {
            mImageView.animate().setDuration(progress).translationXBy(TRANSLATION).start();
            isReset = false;
        } else {
            mImageView.animate().setDuration(progress).translationXBy(-TRANSLATION).start();
            isReset = true;
        }
    }
}
