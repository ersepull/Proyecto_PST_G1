package com.example.dispetser;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class Registrar extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    String usuario;
    EditText nombreAlimetador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        inicializarFirebase();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        Bundle bundle = getIntent().getExtras();
        usuario = databaseReference.child("Cuenta").child(bundle.getString("username")).getKey();
        nombreAlimetador = (EditText) findViewById(R.id.nombreAlimentador);
    }

    public void registrarAlimentador(View view){
        String id= UUID.randomUUID().toString();
        Alimentador a= new Alimentador(nombreAlimetador.getText().toString(), id,0,false,0);
        databaseReference.child("Cuenta").child(usuario).child("Alimentadores").child(id).setValue(a);
        Toast.makeText(this, "El alimentador fue registrado.",Toast.LENGTH_SHORT).show();
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
