package com.example.dispetser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Actions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actions);
        Bundle bundle = getIntent().getExtras();
        TextView log= (TextView) findViewById(R.id.Bienvenida);
        log.setText( "Bienvenido "+bundle.getString("username")+" a DISPETSER");
    }

    public void volver(View view) {
        finish();
    }

}