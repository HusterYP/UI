package com.example.yuanping.uilist.lifecycle.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.yuanping.uilist.R;

public class CommonBActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_b);
        Log.d("@HusterYP",String.valueOf("----B onCreate"));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("@HusterYP", String.valueOf( "--Common B Activity " +
                "onSaveInstanceState"));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("@HusterYP", String.valueOf( "--Common B Activity " +
                "onRestoreInstanceState"));
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("@HusterYP",String.valueOf("----B onRestart"));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("@HusterYP",String.valueOf("----B onStart"));
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("@HusterYP",String.valueOf("----B onResume"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("@HusterYP",String.valueOf("----B onPause"));
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("@HusterYP",String.valueOf("----B onStop"));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("@HusterYP",String.valueOf("----B onDestroy"));
    }
}
