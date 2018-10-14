package com.example.yuanping.uilist.lifecycle.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.yuanping.uilist.R;

/**
 * 验证正常情况下Activity启动时的生命周期
 */
public class CommonAActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_a);
        Log.d("@HusterYP", String.valueOf("A onCreate"));
    }

    public void startB(View view) {
        Intent intent = new Intent(this, CommonBActivity.class);
        startActivity(intent);
    }

    public void startA(View view) {
        Intent intent = new Intent(this, CommonAActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("@HusterYP", String.valueOf("--Common A Activity " +
                "onSaveInstanceState"));
        if (outState == null) {
            Log.d("@HusterYP", String.valueOf("onSaveInstanceState Bundle is null"));
            outState = new Bundle();
        } else {
            Log.d("@HusterYP", String.valueOf("onSaveInstanceState Bundle is not null"));
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("@HusterYP", String.valueOf("--Common A Activity " +
                "onRestoreInstanceState"));
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("@HusterYP", String.valueOf("A onRestart"));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("@HusterYP", String.valueOf("A onStart"));
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("@HusterYP", String.valueOf("A onResume"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("@HusterYP", String.valueOf("A onPause"));
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("@HusterYP", String.valueOf("A onStop"));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("@HusterYP", String.valueOf("A onDestroy"));
    }
}
