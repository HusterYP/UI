package com.example.yuanping.uilist.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class BindServiceOfBinder extends Service {

    public BindServiceOfBinder() {
    }

    @Override
    public void onCreate() {
        Log.d("@HusterYP", String.valueOf("BindServiceOfBinder onCreate"));
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("@HusterYP", String.valueOf("BindServiceOfBinder onStartCommand"));
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d("@HusterYP", String.valueOf("BindServiceOfBinder onDestroy"));
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("@HusterYP", String.valueOf("BindServiceOfBinder onBind"));
        return new MyBinder();
    }

    class MyBinder extends Binder {
        public void saySomething(String msg) {
            Log.d("@HusterYP", String.valueOf("MyBinder Say : " + msg));
        }
    }
}
