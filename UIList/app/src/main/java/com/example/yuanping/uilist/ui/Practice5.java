package com.example.yuanping.uilist.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.yuanping.uilist.R;
import com.example.yuanping.uilist.widget.practice4.ClipRectView;

import java.util.ArrayList;
import java.util.List;

public class Practice5 extends AppCompatActivity {

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
        titles.add("onDraw()-后插");
        titles.add("onDraw()-前插");
        titles.add("onDraw()-在Layout中");
        titles.add("dispatchDraw()");
        titles.add("onDrawForeground()-后插");
        titles.add("onDrawForeground()-前插");
        titles.add("draw()-后插");
        titles.add("draw()-前插");


        List<Fragment> fragments = new ArrayList<>();
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
