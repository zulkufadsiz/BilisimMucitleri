package com.example.ferhats.broadcastreceiver.helper;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by ferhat's on 30.10.2016.
 */
public class ConnectionManager {

    public static boolean isConnectedToInternet(Context context){
        ConnectivityManager connectivityManager =(ConnectivityManager)context
                .getSystemService(context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null){
            NetworkInfo[] infos = connectivityManager.getAllNetworkInfo();
            if (infos!= null){
                for (NetworkInfo info: infos){
                    if (info.getState() == NetworkInfo.State.CONNECTED){
                        return  true;
                    }
                }
            }
        }
        return false;
    }
}
