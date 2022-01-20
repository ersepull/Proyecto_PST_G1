package com.example.dispetser;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Llenado extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    Spinner opciones;
    String usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        inicializarFirebase();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llenado);
        Bundle bundle = getIntent().getExtras();
        opciones= (Spinner)findViewById(R.id.spinner);
        usuario = databaseReference.child("Cuenta").child(bundle.getString("username")).getKey();
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.opciones, android.R.layout.simple_spinner_item);
        opciones.setAdapter(adapter);
    }

    public void volver(View view){
        Intent i = new Intent(this, Actions.class );
        i.putExtra("username", usuario);
        startActivity(i);
        finish();
    }

    private void inicializarFirebase(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
}
