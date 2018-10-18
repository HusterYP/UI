package com.example.yuanping.uilist.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.util.Log;

public class BindServiceOfMsg extends Service {

    private final Messenger mMessenger = new Messenger(new InComingHandler());

    public BindServiceOfMsg() {
    }

    @Override
    public void onCreate() {
        Log.d("@HusterYP", String.valueOf("BindServiceOfMsg onCreate"));
        Log.d("@HusterYP", String.valueOf("BinderServiceOfMsg Process: " + Process.myPid()));
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("@HusterYP", String.valueOf("BindServiceOfMsg onUnbind"));
        return super.onUnbind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("@HusterYP", String.valueOf("BindServiceOfMsg onStartCommand"));
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d("@HusterYP", String.valueOf("BindServiceOfMsg onDestroy"));
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("@HusterYP", String.valueOf("BindServiceOfMsg onBind"));
        return mMessenger.getBinder();
    }

    class InComingHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            Log.d("@HusterYP", String.valueOf("InCommingHandle Receive Msg: " + msg));
        }
    }
}
