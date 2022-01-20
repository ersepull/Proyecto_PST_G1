package com.example.dispetser;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Cronograma extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    String usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        inicializarFirebase();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cronograma);
        Bundle bundle = getIntent().getExtras();
        usuario = databaseReference.child("Cuenta").child(bundle.getString("username")).getKey();
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
