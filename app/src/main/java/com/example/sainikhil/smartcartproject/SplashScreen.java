package com.example.sainikhil.smartcartproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Thread mythread=new Thread()
        {
            @Override
            public void run() {
                try {
                    sleep(3000);
                    Intent it=new Intent(getApplicationContext(),LoginPage.class);
                    startActivity(it);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        };
        mythread.start();
    }
}
