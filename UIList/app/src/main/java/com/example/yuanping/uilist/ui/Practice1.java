package com.example.yuanping.uilist.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.yuanping.uilist.R;
import com.example.yuanping.uilist.widget.practice1.ArcView;
import com.example.yuanping.uilist.widget.practice1.CircleView;
import com.example.yuanping.uilist.widget.practice1.ColorView;
import com.example.yuanping.uilist.widget.practice1.HistogramView;
import com.example.yuanping.uilist.widget.practice1.LineView;
import com.example.yuanping.uilist.widget.practice1.OvalView;
import com.example.yuanping.uilist.widget.practice1.PathView;
import com.example.yuanping.uilist.widget.practice1.PieChartView;
import com.example.yuanping.uilist.widget.practice1.PointView;
import com.example.yuanping.uilist.widget.practice1.RectView;
import com.example.yuanping.uilist.widget.practice1.RoundRectView;

import java.util.ArrayList;
import java.util.List;

public class Practice1 extends AppCompatActivity {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);
        init();
    }

    private void init() {
        mViewPager = findViewById(R.id.ui_pager);
        mTabLayout = findViewById(R.id.tabLayout);
        List<String> titles = new ArrayList<>();
        titles.add("drawColor()");
        titles.add("drawCircle()");
        titles.add("drawRect()");
        titles.add("drawPoint()");
        titles.add("drawOval()");
        titles.add("drawLine()");
        titles.add("drawRoundRect()");
        titles.add("drawArc()");
        titles.add("drawPath()");
        titles.add("直方图");
        titles.add("饼图");
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new UIFragment(new ColorView(this)));
        fragments.add(new UIFragment(new CircleView(this)));
        fragments.add(new UIFragment(new RectView(this)));
        fragments.add(new UIFragment(new PointView(this)));
        fragments.add(new UIFragment(new OvalView(this)));
        fragments.add(new UIFragment(new LineView(this)));
        fragments.add(new UIFragment(new RoundRectView(this)));
        fragments.add(new UIFragment(new ArcView(this)));
        fragments.add(new UIFragment(new PathView(this)));
        fragments.add(new UIFragment(new HistogramView(this)));
        fragments.add(new UIFragment(new PieChartView(this)));

        UIPagerAdapter adapter = new UIPagerAdapter(titles, fragments, getSupportFragmentManager());

        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
