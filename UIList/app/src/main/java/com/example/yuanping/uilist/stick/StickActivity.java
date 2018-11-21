package com.example.yuanping.uilist.stick;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;

import com.example.yuanping.uilist.R;

public class StickActivity extends AppCompatActivity {

    private RecyclerView mStickView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stick);
        initView();
    }

    private void initView() {
        mStickView = findViewById(R.id.stick_view);
        mStickView.setAdapter(new StickAdapter());
        mStickView.setLayoutManager(new LinearLayoutManager(this));
        new PagerSnapHelper().attachToRecyclerView(mStickView);
    }
}
