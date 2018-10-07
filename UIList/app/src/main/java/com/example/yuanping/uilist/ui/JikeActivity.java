package com.example.yuanping.uilist.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.yuanping.uilist.R;
import com.example.yuanping.uilist.widget.practice8.JikeLikeView;

public class JikeActivity extends AppCompatActivity {

    private JikeLikeView mJikeLikeView;
    private boolean isLike = false;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jike);
        mJikeLikeView = findViewById(R.id.jike);
        mJikeLikeView.setCurCount(314);
        mJikeLikeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isLike) {
                    mJikeLikeView.addLikeCount();
                    isLike = true;
                } else {
                    mJikeLikeView.decentLikeCount();
                    isLike = false;
                }
            }
        });
    }
}
