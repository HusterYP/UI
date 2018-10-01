package com.example.yuanping.uilist.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.yuanping.uilist.R;
import com.example.yuanping.uilist.widget.practice2.BitmapShaderView;
import com.example.yuanping.uilist.widget.practice2.ColorMatrixFilterView;
import com.example.yuanping.uilist.widget.practice2.ComposeShaderView;
import com.example.yuanping.uilist.widget.practice2.FillPathView;
import com.example.yuanping.uilist.widget.practice2.LightingColorFilterView;
import com.example.yuanping.uilist.widget.practice2.LinearGradientView;
import com.example.yuanping.uilist.widget.practice2.MaskFilterView;
import com.example.yuanping.uilist.widget.practice2.PathEffectView;
import com.example.yuanping.uilist.widget.practice2.RadialGradientView;
import com.example.yuanping.uilist.widget.practice2.ShadowLayerView;
import com.example.yuanping.uilist.widget.practice2.StrokeCapView;
import com.example.yuanping.uilist.widget.practice2.StrokeJoinView;
import com.example.yuanping.uilist.widget.practice2.StrokeMiterView;
import com.example.yuanping.uilist.widget.practice2.SweepGradientView;
import com.example.yuanping.uilist.widget.practice2.TextPathView;
import com.example.yuanping.uilist.widget.practice2.XfermodeView;

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

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new UIFragment(new LinearGradientView(this)));
        fragments.add(new UIFragment(new RadialGradientView(this)));
        fragments.add(new UIFragment(new SweepGradientView(this)));
        fragments.add(new UIFragment(new BitmapShaderView(this)));
        fragments.add(new UIFragment(new ComposeShaderView(this)));
        fragments.add(new UIFragment(new LightingColorFilterView(this)));
        fragments.add(new UIFragment(new ColorMatrixFilterView(this)));
        fragments.add(new UIFragment(new XfermodeView(this)));
        fragments.add(new UIFragment(new StrokeCapView(this)));
        fragments.add(new UIFragment(new StrokeJoinView(this)));
        fragments.add(new UIFragment(new StrokeMiterView(this)));
        fragments.add(new UIFragment(new PathEffectView(this)));
        fragments.add(new UIFragment(new ShadowLayerView(this)));
        fragments.add(new UIFragment(new MaskFilterView(this)));
        fragments.add(new UIFragment(new FillPathView(this)));
        fragments.add(new UIFragment(new TextPathView(this)));

        UIPagerAdapter adapter = new UIPagerAdapter(titles, fragments, getSupportFragmentManager());

        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
