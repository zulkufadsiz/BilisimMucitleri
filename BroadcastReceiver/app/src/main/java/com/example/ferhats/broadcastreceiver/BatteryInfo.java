package com.example.ferhats.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BatteryInfo extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
      if (intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)){
          Toast.makeText(context,"Güce bağlandım",Toast.LENGTH_SHORT).show();
      }else {
          Toast.makeText(context,"Güçten düştüm",Toast.LENGTH_SHORT).show();
      }
    }
}
