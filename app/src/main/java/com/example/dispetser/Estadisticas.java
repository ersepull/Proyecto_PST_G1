package com.example.dispetser;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Estadisticas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);
    }

    public void volver(View view){
        Intent i = new Intent(this, Actions.class );
        startActivity(i);
        finish();
    }
}
