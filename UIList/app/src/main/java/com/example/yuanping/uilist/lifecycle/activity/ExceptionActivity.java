package com.example.yuanping.uilist.lifecycle.activity;

import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.yuanping.uilist.R;

/**
 * 验证异常情况下Activity启动时的生命周期
 */
public class ExceptionActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exception);
        Log.d("@HusterYP", String.valueOf("--Exception Activity onCreate"));
        if (savedInstanceState == null) {
            Log.d("@HusterYP", String.valueOf("onCreate savedInstanceState null"));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("@HusterYP", String.valueOf("--Exception Activity " +
                "onSaveInstanceState"));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("@HusterYP", String.valueOf("--Exception Activity " +
                "onRestoreInstanceState"));
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("@HusterYP", String.valueOf("--Exception Activity onRestart"));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("@HusterYP", String.valueOf("--Exception Activity onStart"));
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("@HusterYP", String.valueOf("--Exception Activity onResume"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("@HusterYP", String.valueOf("--Exception Activity onPause"));
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("@HusterYP", String.valueOf("--Exception Activity onStop"));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("@HusterYP", String.valueOf("--Exception Activity onDestroy"));
    }
}
