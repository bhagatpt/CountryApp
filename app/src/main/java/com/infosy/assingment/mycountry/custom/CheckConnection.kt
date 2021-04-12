package com.infosy.assingment.mycountry.custom;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.view.inputmethod.InputMethodManager;


public class CheckConnection {

    Activity activity;
    private String TAG = "CheckConnection";

    public CheckConnection(Activity activity) {
        this.activity = activity;
    }

    public static boolean haveNetworkConnection(Context context) {
        boolean conntected = false;

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();

        if (netInfo != null) {
            if (netInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                conntected = true;
            } else if (netInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                conntected = true;
            } else {
                conntected = false;
            }
        }
        return conntected;
    }
}
