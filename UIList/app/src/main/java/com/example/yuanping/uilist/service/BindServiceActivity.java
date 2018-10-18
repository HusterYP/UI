package com.example.yuanping.uilist.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.yuanping.uilist.R;

/**
 * 使用Binder来实现绑定服务
 */
public class BindServiceActivity extends AppCompatActivity {

    private ServiceConnection mServiceConnectionOfBinder;
    private ServiceConnection mServiceConnectionOfMsg;
    private Messenger mMessenger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_service);
        init();
    }

    private void init() {
        mServiceConnectionOfBinder = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Log.d("@HusterYP", String.valueOf("ServiceConnection onServiceConnected"));
                Log.d("@HusterYP", String.valueOf("ServiceConnection ComponentName " + name));
                BindServiceOfBinder.MyBinder binder = (BindServiceOfBinder.MyBinder) service;
                binder.saySomething("Hello Service");
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                Log.d("@HusterYP", String.valueOf("ServiceConnection Disconnected"));
            }
        };
        mServiceConnectionOfMsg = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                mMessenger = new Messenger(service);
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };
    }

    public void startServiceOfBinder(View view) {
        Intent intent = new Intent(this, BindServiceOfBinder.class);
        bindService(intent, mServiceConnectionOfBinder, Service.BIND_AUTO_CREATE);
    }

    public void startServiceOfMsg(View view) {
        Log.d("@HusterYP", String.valueOf("BindServiceActivity Process: " + Process.myPid()));
        Intent intent = new Intent(this, BindServiceOfMsg.class);
        bindService(intent, mServiceConnectionOfMsg, Service.BIND_AUTO_CREATE);
    }

    public void stopServiceOfBinder(View view) {
        unbindService(mServiceConnectionOfBinder);
    }

    public void stopServiceOfMsg(View view) {
        unbindService(mServiceConnectionOfMsg);
    }

    public void sendMsg(View view) throws RemoteException {
        Message message = new Message();
        message.what = 1;
        mMessenger.send(message);
    }
}
