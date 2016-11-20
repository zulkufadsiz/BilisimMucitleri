package com.example.samsung.gridlayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by samsung on 20.11.2016.
 */

public class MainMenu extends AppCompatActivity {
    Button btn;
    TextView tv1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        tv1 = (TextView)findViewById(R.id.tv1);
        btn = (Button)findViewById(R.id.btnstart1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenu.this,main.class);
                startActivity(intent);
            }
        });
    }
}
