package com.example.yuanping.uilist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.example.yuanping.uilist.drag.DragActivity;
import com.example.yuanping.uilist.lifecycle.LifeCycleChoseActivity;
import com.example.yuanping.uilist.service.ServiceChoseActivity;
import com.example.yuanping.uilist.touch.TouchActivity;
import com.example.yuanping.uilist.ui.UIChoseActivity;
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
        titles.add(AssetsUtils.getStringFromResource(R.string.drag));
        titles.add(AssetsUtils.getStringFromResource(R.string.touch_event));
        titles.add(AssetsUtils.getStringFromResource(R.string.ui));
        titles.add(AssetsUtils.getStringFromResource(R.string.lifecycle));
        titles.add(AssetsUtils.getStringFromResource(R.string.service));
        return titles;
    }

    private List<Class> getClazz() {
        List<Class> listeners = new ArrayList<>();
        listeners.add(DragActivity.class);
        listeners.add(TouchActivity.class);
        listeners.add(UIChoseActivity.class);
        listeners.add(LifeCycleChoseActivity.class);
        listeners.add(ServiceChoseActivity.class);
        return listeners;
    }
}
