package com.infosy.assingment.mycountry.custom

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager

class CheckConnection(var activity: Activity) {

    companion object {
        fun haveNetworkConnection(context: Context): Boolean {
            var conntected = false
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val netInfo = cm.activeNetworkInfo
            if (netInfo != null) {
                conntected = if (netInfo.type == ConnectivityManager.TYPE_WIFI) {
                    true
                } else netInfo.type == ConnectivityManager.TYPE_MOBILE
            }
            return conntected
        }
    }
}