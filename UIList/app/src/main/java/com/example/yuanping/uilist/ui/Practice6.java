package com.example.yuanping.uilist.ui;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import com.example.yuanping.uilist.widget.practice4.RotateView;
import com.example.yuanping.uilist.widget.practice4.TranslateView;
import com.example.yuanping.uilist.widget.practice6.AlphaView;
import com.example.yuanping.uilist.widget.practice6.DurationView;
import com.example.yuanping.uilist.widget.practice6.InterpolatorView;
import com.example.yuanping.uilist.widget.practice6.ObjectAnimatorView;
import com.example.yuanping.uilist.widget.practice6.RotationView;
import com.example.yuanping.uilist.widget.practice6.ScaleView;
import com.example.yuanping.uilist.widget.practice6.TranslationView;
import com.example.yuanping.uilist.widget.practice6.ViewPropertyAnimatorView;

import java.util.ArrayList;
import java.util.List;

public class Practice6 extends AppCompatActivity {

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
        titles.add("translationX/Y/Z()");
        titles.add("rotationX/Y()");
        titles.add("scaleX/Y()");
        titles.add("alpha()");
        titles.add("ViewPropertyAnimator-多属性");
        titles.add("setDuration()");
        titles.add("setInterpolator()");
        titles.add("ObjectAnimator");

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new UIFragment(new TranslationView(this)));
        fragments.add(new UIFragment(new RotationView(this)));
        fragments.add(new UIFragment(new ScaleView(this)));
        fragments.add(new UIFragment(new AlphaView(this)));
        fragments.add(new UIFragment(new ViewPropertyAnimatorView(this)));
        fragments.add(new UIFragment(new DurationView(this)));
        fragments.add(new UIFragment(new InterpolatorView(this)));
        fragments.add(new UIFragment(new ObjectAnimatorView(this)));

        UIPagerAdapter adapter = new UIPagerAdapter(titles, fragments, getSupportFragmentManager());

        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}