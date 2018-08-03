package com.example.yuanping.uilist.drag;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.example.yuanping.uilist.R;
import com.example.yuanping.uilist.utils.AssetsUtils;
import com.example.yuanping.uilist.utils.RvUtils;

import java.util.ArrayList;
import java.util.List;

public class DragActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag);
        initView();
    }

    private void initView() {
        RecyclerView rv = findViewById(R.id.rv_drag);
        RvUtils.setCommonRv(rv, getClazz(), getTitles(), this);
    }

    private List<String> getTitles() {
        List<String> titles = new ArrayList<>();
        titles.add(AssetsUtils.getStringFromResource(R.string.drag_view_first));
        titles.add(AssetsUtils.getStringFromResource(R.string.drag_view_second));
        return titles;
    }

    private List<Class> getClazz() {
        List<Class> clazz = new ArrayList<>();
        clazz.add(DragViewFirst.class);
        clazz.add(DragViewSecond.class);
        return clazz;
    }
}
