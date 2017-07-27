package com.example.nolgong.mobilecentertest;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;

/**
 * Created by nolgong on 2017. 7. 27..
 */

public class MyFirebaseInstanceIdService extends com.google.firebase.iid.FirebaseInstanceIdService {
    @Override
    public void onTokenRefresh() {
        //super.onTokenRefresh();
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d("Refreshed token : ",refreshedToken);

    }


}
