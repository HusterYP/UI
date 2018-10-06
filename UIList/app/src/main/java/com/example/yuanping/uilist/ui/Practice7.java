package com.example.yuanping.uilist.ui;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yuanping.uilist.R;
import com.example.yuanping.uilist.widget.practice7.AnimatorSetView;
import com.example.yuanping.uilist.widget.practice7.ArgbEvaluatorView;
import com.example.yuanping.uilist.widget.practice7.HsvEvaluatorView;
import com.example.yuanping.uilist.widget.practice7.OfObjectView;
import com.example.yuanping.uilist.widget.practice7.PropertyValuesHolderOfKeyFrameView;
import com.example.yuanping.uilist.widget.practice7.PropertyValuesHolderView;

import junit.framework.Test;

import java.util.ArrayList;
import java.util.List;

public class Practice7 extends AppCompatActivity {

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
        titles.add("ArgbEvaluator");
        titles.add("HsvEvaluator");
        titles.add("ofObject");
        titles.add("PropertyValuesHolder");
        titles.add("AnimatorSet");
        titles.add("PropertyValuesHolder.ofKeyframe()");

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new UIFragment(new ArgbEvaluatorView(this)));
        fragments.add(new UIFragment(new HsvEvaluatorView(this)));
        fragments.add(new UIFragment(new OfObjectView(this)));
        fragments.add(new UIFragment(new PropertyValuesHolderView(this)));
        fragments.add(new UIFragment(new AnimatorSetView(this)));
        fragments.add(new UIFragment(new PropertyValuesHolderOfKeyFrameView(this)));

        UIPagerAdapter adapter = new UIPagerAdapter(titles, fragments, getSupportFragmentManager());

        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
