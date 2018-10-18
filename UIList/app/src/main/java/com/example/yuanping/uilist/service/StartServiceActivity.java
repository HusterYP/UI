package com.example.yuanping.uilist.service;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.yuanping.uilist.R;

public class StartServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_service);
    }

    public void startService(View view) {
        Intent intent = new Intent(this, StartService.class);
        startService(intent);
    }

    public void stopService(View view) {
        Intent intent = new Intent(this, StartService.class);
        stopService(intent);
    }
}
