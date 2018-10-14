package com.example.yuanping.uilist.lifecycle.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.yuanping.uilist.R;

public class SpecialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special);
        Log.d("@HusterYP",String.valueOf("Special Activity onCreate"));
    }

    public void startSpecialActivity(View view) {
        Intent intent = new Intent(this, TransparentActivity.class);
        startActivity(intent);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void startTransparentDialog(View view) {
        Dialog dialog = new Dialog(this);
        dialog.create();
        dialog.show();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("@HusterYP", String.valueOf("Special Activity onSaveInstanceState"));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("@HusterYP", String.valueOf("Special Activity onRestoreInstanceState"));
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("@HusterYP", String.valueOf(" Special Activity onRestart"));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("@HusterYP", String.valueOf(" Special Activity onStart"));
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("@HusterYP", String.valueOf(" Special Activity onResume"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("@HusterYP", String.valueOf(" Special Activity onPause"));
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("@HusterYP", String.valueOf(" Special Activity onStop"));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("@HusterYP", String.valueOf(" Special Activity onDestroy"));
    }
}
