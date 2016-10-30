package com.example.ferhats.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.ferhats.broadcastreceiver.helper.ConnectionManager;

public class ConnectivityReceiver extends BroadcastReceiver {



    @Override
    public void onReceive(Context context, Intent intent) {
        boolean isConnected = ConnectionManager.isConnectedToInternet(context);
        if (!isConnected){
            Toast.makeText(context,"Aman Allah'ım internetten düştük",Toast.LENGTH_SHORT).show();
        }
    }
}
