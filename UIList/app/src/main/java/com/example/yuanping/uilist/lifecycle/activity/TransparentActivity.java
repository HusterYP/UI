package com.example.yuanping.uilist.lifecycle.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.yuanping.uilist.R;

public class TransparentActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transparent);
        Log.d("@HusterYP",String.valueOf("Transparent Activity onCreate"));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("@HusterYP", String.valueOf("Transparent Activity  onSaveInstanceState"));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("@HusterYP", String.valueOf("Transparent Activity  onRestoreInstanceState"));
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("@HusterYP", String.valueOf(" Transparent Activity  onRestart"));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("@HusterYP", String.valueOf(" Transparent Activity  onStart"));
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("@HusterYP", String.valueOf(" Transparent Activity  onResume"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("@HusterYP", String.valueOf(" Transparent Activity  onPause"));
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("@HusterYP", String.valueOf(" Transparent Activity  onStop"));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("@HusterYP", String.valueOf(" Transparent Activity  onDestroy"));
    }
}
