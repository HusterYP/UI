package com.example.yuanping.uilist.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSeekBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

import com.example.yuanping.uilist.R;
import com.example.yuanping.uilist.utils.ScreenUtils;

public class Practice9 extends AppCompatActivity {

    private AppCompatSeekBar widthSeekBar;
    private AppCompatSeekBar heightSeekBar;
    private RelativeLayout rlRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice9);
        init();
    }

    private void init() {
        widthSeekBar = findViewById(R.id.width_seekBar);
        heightSeekBar = findViewById(R.id.height_seekBar);
        rlRoot = findViewById(R.id.rl_root);

        widthSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int width = (int) (ScreenUtils.getScreenWidth() * progress / 100f);
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) rlRoot
                        .getLayoutParams();
                params.width = width;
                rlRoot.setLayoutParams(params);
                rlRoot.requestLayout();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        heightSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int height = (int) (ScreenUtils.getScreenHeight() * progress / 100f);
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) rlRoot
                        .getLayoutParams();
                params.height = height;
                rlRoot.setLayoutParams(params);
                rlRoot.requestLayout();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // 模拟出发上面的listener, 进行初始化
        widthSeekBar.post(() -> widthSeekBar.setProgress(10));
        heightSeekBar.post(() -> heightSeekBar.setProgress(10));
    }
}
