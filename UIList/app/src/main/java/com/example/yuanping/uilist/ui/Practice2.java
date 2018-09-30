package com.example.yuanping.uilist.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

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

public class Practice2 extends AppCompatActivity {

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
        titles.add("LinearGradient");
        titles.add("RadialGradient");
        titles.add("SweepGradient");
        titles.add("BitmapShader");
        titles.add("ComposeShader");
        titles.add("LightingColorFilter");
        titles.add("ColorMatrixColorFilter");
        titles.add("setXfermode()");
        titles.add("setStrokeCap()");
        titles.add("setStrokeJoin()");
        titles.add("setStrokeMiter()");
        titles.add("setPathEffect()");
        titles.add("setShadowLayer()");
        titles.add("setMaskFilter()");
        titles.add("setFillPath()");
        titles.add("setTextPath()");
        titles.add("setTextPath()");

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new UIFragment(new Button(this)));
        fragments.add(new UIFragment(new Button(this)));
        fragments.add(new UIFragment(new Button(this)));
        fragments.add(new UIFragment(new Button(this)));
        fragments.add(new UIFragment(new Button(this)));
        fragments.add(new UIFragment(new Button(this)));
        fragments.add(new UIFragment(new Button(this)));
        fragments.add(new UIFragment(new Button(this)));
        fragments.add(new UIFragment(new Button(this)));
        fragments.add(new UIFragment(new Button(this)));
        fragments.add(new UIFragment(new Button(this)));
        fragments.add(new UIFragment(new Button(this)));
        fragments.add(new UIFragment(new Button(this)));
        fragments.add(new UIFragment(new Button(this)));
        fragments.add(new UIFragment(new Button(this)));
        fragments.add(new UIFragment(new Button(this)));
        fragments.add(new UIFragment(new Button(this)));

        UIPagerAdapter adapter = new UIPagerAdapter(titles, fragments, getSupportFragmentManager());

        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
