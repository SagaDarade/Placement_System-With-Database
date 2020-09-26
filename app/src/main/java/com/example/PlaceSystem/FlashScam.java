package com.example.PlaceSystem;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class FlashScam extends AppCompatActivity implements Runnable {

    Thread t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_scam);
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {

        try
        {
            Thread.sleep(3000);
        }
        catch (Exception ee)
        {
            ee.printStackTrace();
        }
        Intent i=new Intent(FlashScam.this, MainActivity.class);
        startActivity(i);
        finish();

    }
}
