package com.example.ferhats.broadcastreceiver;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class main extends AppCompatActivity {
    private Context mContext = this;
    private ConnectivityReceiver mConnectivityReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mConnectivityReceiver = new ConnectivityReceiver();

    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(mConnectivityReceiver,new IntentFilter(
                ConnectivityManager.CONNECTIVITY_ACTION
        ));
    }

    @Override
    protected void onPause() {
        unregisterReceiver(mConnectivityReceiver);
        super.onPause();
    }
}
