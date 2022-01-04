package com.example.dispetser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
        Intent i = new Intent(this, Login.class);
        startActivity(i);
        finish();
    }

    public void llenado(View view) {
        Intent i = new Intent(this, Llenado.class);
        startActivity(i);
        finish();
    }

    public void cronograma(View view) {
        Intent i = new Intent(this, Cronograma.class);
        startActivity(i);
        finish();
    }

    public void estadisticas(View view) {
        Intent i = new Intent(this, Estadisticas.class);
        startActivity(i);
        finish();
    }

    public void salir (View view) {finish();}
}