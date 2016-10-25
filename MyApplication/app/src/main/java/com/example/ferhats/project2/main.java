package com.example.ferhats.project2;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class main extends Activity {
    MediaPlayer intro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intro = MediaPlayer.create(main.this,R.raw.coolblast);
        intro.start();
        Thread timer = new Thread(){
            public void run(){

                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    Intent intent  = new Intent("android.intent.action.IKINCIEKRAN");
                    startActivity(intent);
                }
            }
        };
        timer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        intro.release();
        finish();
    }
}
