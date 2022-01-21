package com.example.dispetser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Actions extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    String usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        inicializarFirebase();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actions);
        Bundle bundle = getIntent().getExtras();
        TextView log= (TextView) findViewById(R.id.Bienvenida);
        usuario = databaseReference.child("Cuenta").child(bundle.getString("username")).getKey();
        log.setText( "Bienvenido "+usuario+" a DISPETSER");
    }

    public void volver(View view) {
        Intent i = new Intent(this, Login.class);
        startActivity(i);
        finish();
    }

    public void llenado(View view) {
        Intent i = new Intent(this, Llenado.class);
        i.putExtra("username", usuario);
        startActivity(i);
        finish();
    }

    public void registrar(View view) {
        Intent i = new Intent(this, Registrar.class);
        i.putExtra("username", usuario);
        startActivity(i);
        finish();
    }

    public void estadisticas(View view) {
        Intent i = new Intent(this, Estadisticas.class);
        i.putExtra("username", usuario);
        startActivity(i);
        finish();
    }

    public void web(View view) {
        Intent i = new Intent(this, webView.class);
        i.putExtra("username", usuario);
        startActivity(i);
        finish();
    }

    public void salir (View view) {finish();}

    private void inicializarFirebase(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
}