package com.example.yuanping.uilist.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.example.yuanping.uilist.R;
import com.example.yuanping.uilist.utils.AssetsUtils;
import com.example.yuanping.uilist.utils.RvUtils;

import java.util.ArrayList;
import java.util.List;

public class ChoseActivity extends AppCompatActivity {

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
        titles.add(AssetsUtils.getStringFromResource(R.string.practice1));
        titles.add(AssetsUtils.getStringFromResource(R.string.practice2));
        titles.add(AssetsUtils.getStringFromResource(R.string.practice4));
        titles.add(AssetsUtils.getStringFromResource(R.string.practice5));
        titles.add(AssetsUtils.getStringFromResource(R.string.practice6));
        return titles;
    }

    private List<Class> getClazz() {
        List<Class> listeners = new ArrayList<>();
        listeners.add(Practice1.class);
        listeners.add(Practice2.class);
        listeners.add(Practice4.class);
        listeners.add(Practice5.class);
        listeners.add(Practice6.class);
        return listeners;
    }
}
