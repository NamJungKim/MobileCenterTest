package com.example.nolgong.mobilecentertest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        Log.d("From : ",remoteMessage.getFrom());

        if(remoteMessage.getData().size()>0){
            Log.d("Message data payload : ",""+remoteMessage.getData());
        }
        if(remoteMessage.getNotification() != null){
            Log.d("Notification Body: ",""+remoteMessage.getNotification().getBody());
        }
    }
}
