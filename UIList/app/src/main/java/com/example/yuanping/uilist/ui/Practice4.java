package com.example.yuanping.uilist.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.yuanping.uilist.R;
import com.example.yuanping.uilist.widget.practice4.CameraRotateXY;
import com.example.yuanping.uilist.widget.practice4.CameraRotateXYHittingFaceView;
import com.example.yuanping.uilist.widget.practice4.CameraRotateXYImp;
import com.example.yuanping.uilist.widget.practice4.ClipPathView;
import com.example.yuanping.uilist.widget.practice4.ClipRectView;
import com.example.yuanping.uilist.widget.practice4.FlipboardView;
import com.example.yuanping.uilist.widget.practice4.MatrixRotateView;
import com.example.yuanping.uilist.widget.practice4.MatrixScaleView;
import com.example.yuanping.uilist.widget.practice4.MatrixSkewView;
import com.example.yuanping.uilist.widget.practice4.MatrixTranslateView;
import com.example.yuanping.uilist.widget.practice4.RotateView;
import com.example.yuanping.uilist.widget.practice4.ScaleView;
import com.example.yuanping.uilist.widget.practice4.SkewView;
import com.example.yuanping.uilist.widget.practice4.TranslateView;

import java.util.ArrayList;
import java.util.List;

public class Practice4 extends AppCompatActivity {

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
        titles.add("clipRect()");
        titles.add("clipPath()");
        titles.add("translate()");
        titles.add("scale()");
        titles.add("rotate()");
        titles.add("skew()");
        titles.add("Matrix.translate()");
        titles.add("Matrix.scale()");
        titles.add("Matrix.rotate()");
        titles.add("Matrix.skew()");
        titles.add("Camera.rotateX/Y()");
        titles.add("Camera.rotateX/Y()修正版");
        titles.add("Camera.rotateX/Y()糊脸修正");
        titles.add("翻页效果");

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new UIFragment(new ClipRectView(this)));
        fragments.add(new UIFragment(new ClipPathView(this)));
        fragments.add(new UIFragment(new TranslateView(this)));
        fragments.add(new UIFragment(new ScaleView(this)));
        fragments.add(new UIFragment(new RotateView(this)));
        fragments.add(new UIFragment(new SkewView(this)));
        fragments.add(new UIFragment(new MatrixTranslateView(this)));
        fragments.add(new UIFragment(new MatrixScaleView(this)));
        fragments.add(new UIFragment(new MatrixRotateView(this)));
        fragments.add(new UIFragment(new MatrixSkewView(this)));
        fragments.add(new UIFragment(new CameraRotateXY(this)));
        fragments.add(new UIFragment(new CameraRotateXYImp(this)));
        fragments.add(new UIFragment(new CameraRotateXYHittingFaceView(this)));
        fragments.add(new UIFragment(new FlipboardView(this)));

        UIPagerAdapter adapter = new UIPagerAdapter(titles, fragments, getSupportFragmentManager());

        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
