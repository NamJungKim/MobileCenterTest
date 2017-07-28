package com.example.nolgong.mobilecentertest;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
import com.microsoft.azure.mobile.MobileCenter;
import com.microsoft.azure.mobile.analytics.Analytics;
import com.microsoft.azure.mobile.crashes.Crashes;
import com.microsoft.azure.mobile.push.Push;
import com.microsoft.azure.mobile.push.PushListener;
import com.microsoft.azure.mobile.push.PushNotification;

import java.util.Map;


public class MainActivity extends AppCompatActivity {

    Button first,second,third;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Push push = Push.getInstance();
        push.setListener(new PushListener() {
            @Override
            public void onPushNotificationReceived(Activity activity, PushNotification pushNotification) {
                Log.d("MobileCenter Push ","pushNotification.getMessage()");
                /* The following notification properties are available. */
                String title = pushNotification.getTitle();
                String message = pushNotification.getMessage();
                Map<String, String> customData = pushNotification.getCustomData();

        /*
         * Message and title cannot be read from a background notification object.
         * Message being a mandatory field, you can use that to check foreground vs background.
         */
                if (message != null) {

            /* Display an alert for foreground push. */
                    AlertDialog.Builder dialog = new AlertDialog.Builder(activity);
                    if (title != null) {
                        dialog.setTitle(title);
                    }
                    dialog.setMessage(message);
                    if (!customData.isEmpty()) {
                        dialog.setMessage(message + "\n" + customData);
                    }
                    dialog.setPositiveButton(android.R.string.ok, null);
                    dialog.show();
                } else {

            /* Display a toast when a background push is clicked. */
                    Toast.makeText(activity, String.format(activity.getString(R.string.push_toast), customData), Toast.LENGTH_LONG).show(); // For example R.string.push_toast would be "Push clicked with data=%1s"
                }
            }
        });
        MobileCenter.start(getApplication(), "c72d1e69-28d9-4e98-ac29-b2c4fbbdcfe7",
                Analytics.class, Crashes.class);

        //Push.enableFirebaseAnalytics(getApplication());
        MobileCenter.start(getApplication(), "c72d1e69-28d9-4e98-ac29-b2c4fbbdcfe7", push.getClass());

        Log.d("token : ", FirebaseInstanceId.getInstance().getToken());
        FirebaseMessaging.getInstance().subscribeToTopic("notice");


        first = (Button)findViewById(R.id.first);
        second = (Button)findViewById(R.id.second);
        third = (Button)findViewById(R.id.third);

        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,FirstActivity.class);
                startActivity(intent);
            }
        });
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ThirdActivity.class);
                startActivity(intent);
            }
        });
    }
}
