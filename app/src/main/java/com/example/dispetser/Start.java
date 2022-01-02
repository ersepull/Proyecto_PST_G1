package com.example.dispetser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

public class Start extends AppCompatActivity {
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Handler handler = new Handler();
        Intent i = new Intent(this, Login.class );
        handler.postDelayed(new Runnable() {
            public void run() {
                startActivity(i);
                finish();
            }
        }, 5000);
    }
}