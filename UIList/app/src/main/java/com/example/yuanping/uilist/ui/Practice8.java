package com.example.yuanping.uilist.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.yuanping.uilist.R;
import com.example.yuanping.uilist.utils.AssetsUtils;
import com.example.yuanping.uilist.utils.RvUtils;

import java.util.ArrayList;
import java.util.List;

public class Practice8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        RecyclerView rvRoot = findViewById(R.id.rv_root);
        RvUtils.setCommonRv(rvRoot, getClazz(), getTitles(), this);
    }

    private List<String> getTitles() {
        List<String> titles = new ArrayList<>();
        titles.add(AssetsUtils.getStringFromResource(R.string.practice_test));
        return titles;
    }

    private List<Class> getClazz() {
        List<Class> listeners = new ArrayList<>();
        listeners.add(JikeActivity.class);
        return listeners;
    }
}