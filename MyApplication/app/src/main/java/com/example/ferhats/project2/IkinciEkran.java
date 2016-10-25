package com.example.ferhats.project2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by ferhat's on 22.10.2016.
 */
public class IkinciEkran extends Activity {
    Button btnAct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ikinci_ekran);
        btnAct = (Button)findViewById(R.id.btnact);
        btnAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAct();
            }
        });

    }
    public void startAct(){
        Intent activity = new Intent("android.intent.action.ACTIVITYEKRANI");
        startActivity(activity);
    }
}
