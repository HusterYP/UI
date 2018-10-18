package com.example.yuanping.uilist.service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.yuanping.uilist.R;

public class ForegroundActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_service);
        init();
    }

    private void init() {
        Button startService = findViewById(R.id.start_service_of_binder);
        startService.setText("Start Foreground Service");
        Button stopService = findViewById(R.id.stop_service);
        stopService.setText("Stop Foreground Service");
    }

    public void startService(View view) {
        Intent intent = new Intent(this, ForegroundService.class);
        intent.putExtra("cmd", 0);
        startService(intent);
    }

    public void stopServiceOfBinder(View view) {
        Intent intent = new Intent(this, ForegroundService.class);
        intent.putExtra("cmd", 1);
        startService(intent);
    }
}

