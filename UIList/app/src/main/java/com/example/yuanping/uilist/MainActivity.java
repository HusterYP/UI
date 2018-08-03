package com.example.yuanping.uilist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.yuanping.uilist.drag.DragActivity;
import com.example.yuanping.uilist.utils.AssetsUtils;
import com.example.yuanping.uilist.utils.RvUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @created by PingYuan
 * @email: husteryp@gmail.com
 * @desciption: This project is practices for UI
 */
public class MainActivity extends AppCompatActivity {

    private RecyclerView rvRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        rvRoot = findViewById(R.id.rv_root);
        List<String> titles = getTitles();
        List<Class> listeners = getListeners();
        RvUtils.setCommonRv(rvRoot, listeners, titles, this);
    }

    private List<String> getTitles() {
        List<String> titles = new ArrayList<>();
        titles.add(AssetsUtils.getStringFromResource(R.string.drag));
        titles.add(AssetsUtils.getStringFromResource(R.string.drag));
        titles.add(AssetsUtils.getStringFromResource(R.string.drag));
        titles.add(AssetsUtils.getStringFromResource(R.string.drag));
        return titles;
    }

    private List<Class> getListeners() {
        List<Class> listeners = new ArrayList<>();
        listeners.add(DragActivity.class);
        listeners.add(DragActivity.class);
        listeners.add(DragActivity.class);
        listeners.add(DragActivity.class);
        return listeners;
    }
}
