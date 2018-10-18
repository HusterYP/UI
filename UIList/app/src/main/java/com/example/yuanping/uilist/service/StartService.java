package com.example.yuanping.uilist.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class StartService extends Service {

    public StartService() {
        Log.d("@HusterYP", String.valueOf("StartService Constructor"));
    }

    @Override
    public void onCreate() {
        Log.d("@HusterYP", String.valueOf("StartService onCreate"));
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("@HusterYP", String.valueOf("StartService onStartCommand"));
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d("@HusterYP", String.valueOf("StartService onDestroy"));
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("@HusterYP", String.valueOf("StartService onBind"));
        return null;
    }
}
