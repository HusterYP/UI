package com.example.yuanping.uilist.drag;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.yuanping.uilist.R;
import com.example.yuanping.uilist.utils.RvUtils;

import java.util.ArrayList;
import java.util.List;

public class DragViewSecond extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_view_second);
        initView();
    }

    private void initView() {
        RecyclerView rv = findViewById(R.id.rv_drag_view_second);
        RvUtils.setCommonRv(rv, null, getTitles(), this);
    }

    private List<String> getTitles() {
        List<String> titles = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            titles.add("Object " + i);
        }
        return titles;
    }
}
