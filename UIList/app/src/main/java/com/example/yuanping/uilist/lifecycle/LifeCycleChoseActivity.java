package com.example.yuanping.uilist.lifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.yuanping.uilist.R;
import com.example.yuanping.uilist.lifecycle.activity.ActivityLifeCycleChose;
import com.example.yuanping.uilist.ui.Practice1;
import com.example.yuanping.uilist.ui.Practice2;
import com.example.yuanping.uilist.ui.Practice4;
import com.example.yuanping.uilist.ui.Practice5;
import com.example.yuanping.uilist.ui.Practice6;
import com.example.yuanping.uilist.ui.Practice7;
import com.example.yuanping.uilist.ui.Practice8;
import com.example.yuanping.uilist.ui.Practice9;
import com.example.yuanping.uilist.utils.AssetsUtils;
import com.example.yuanping.uilist.utils.RvUtils;

import java.util.ArrayList;
import java.util.List;

public class LifeCycleChoseActivity extends AppCompatActivity {

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
        titles.add(AssetsUtils.getStringFromResource(R.string.activity));

        return titles;
    }

    private List<Class> getClazz() {
        List<Class> listeners = new ArrayList<>();
        listeners.add(ActivityLifeCycleChose.class);

        return listeners;
    }
}
