package com.example.nolgong.mobilecentertest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.microsoft.azure.mobile.MobileCenter;
import com.microsoft.azure.mobile.analytics.Analytics;
import com.microsoft.azure.mobile.crashes.Crashes;
import com.microsoft.azure.mobile.MobileCenter;
import com.microsoft.azure.mobile.push.Push;


public class MainActivity extends AppCompatActivity {

    Button first,second,third;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileCenter.start(getApplication(), "c72d1e69-28d9-4e98-ac29-b2c4fbbdcfe7",
                Analytics.class, Crashes.class);
        MobileCenter.start(getApplication(), "c72d1e69-28d9-4e98-ac29-b2c4fbbdcfe7", Push.class);


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
