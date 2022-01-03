package com.example.dispetser;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Llenado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llenado);
    }

    public void volver(View view){
        Intent i = new Intent(this, Actions.class );
        startActivity(i);
        finish();}
}
