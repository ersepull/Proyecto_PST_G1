package com.example.dispetser;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
        DatabaseReference rf1= firebaseDatabase.getReference("Cuenta");
        rf1.child(usuario).child("Alimentadores").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                final List<String> areas= new ArrayList<>();
                for(DataSnapshot areaSnapchot: snapshot.getChildren()){
                    String area_name= areaSnapchot.child("nombre").getValue(String.class);
                    areas.add(area_name);
                }
                ArrayAdapter<String> areasAdapter= new ArrayAdapter<String>(Llenado.this, android.R.layout.simple_spinner_item,areas);
                opciones.setAdapter(areasAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
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

    public void agregarAlimentador(View view){
        String id=UUID.randomUUID().toString();
        Alimentador a= new Alimentador("Nuevo alimentador", id,0);
        databaseReference.child("Cuenta").child(usuario).child("Alimentadores").child(id).setValue(a);
    }
}
