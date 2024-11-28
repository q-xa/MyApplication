package com.example.sj7;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

public class MyService extends Service {
    private MyBroadcastReceiver receiver;
    @Override
    public void onCreate() {
        super.onCreate();
        receiver = new MyBroadcastReceiver(getApplicationContext());
        IntentFilter filter = new IntentFilter("MyService.receiver");
        registerReceiver(receiver, filter);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }
}