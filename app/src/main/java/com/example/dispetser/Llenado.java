package com.example.dispetser;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

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
    int porcentaje_comida;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    String alimentador;
    String identificador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        inicializarFirebase();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llenado);
        Bundle bundle = getIntent().getExtras();
        button1 = (Button) findViewById(R.id.button25);
        button2 = (Button) findViewById(R.id.button50);
        button3 = (Button) findViewById(R.id.button75);
        button4 = (Button) findViewById(R.id.button100);
        opciones= (Spinner)findViewById(R.id.spinner);
        usuario = databaseReference.child("Cuenta").child(bundle.getString("username")).getKey();
        DatabaseReference rf1= firebaseDatabase.getReference("Cuenta");
        rf1.child(usuario).child("Alimentadores").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<String> info = new ArrayList<>();
                final List<String> areas= new ArrayList<>();
                for(DataSnapshot areaSnapchot: snapshot.getChildren()){
                    String area_name= areaSnapchot.child("nombre").getValue(String.class);
                    porcentaje_comida = areaSnapchot.child("porcentaje_comida").getValue(Integer.class);
                    String id = areaSnapchot.child("id").getValue(String.class);
                    String infoAlimentador = area_name + "," + id;
                    info.add(infoAlimentador);
                    areas.add(area_name);
                }
                ArrayAdapter<String> areasAdapter= new ArrayAdapter<String>(Llenado.this, android.R.layout.simple_spinner_item,areas);
                opciones.setAdapter(areasAdapter);

                opciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        alimentador = parent.getItemAtPosition(position).toString();
                        for (String cadena: info){
                            String[] elementos = cadena.split(",");
                            if (elementos[0].equals(alimentador)){
                                identificador = elementos[1];
                            }
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(porcentaje_comida>=25){
                    Toast.makeText(getApplicationContext(), "El alimentador tiene más del 25 en su plato.",Toast.LENGTH_SHORT).show();
                }
                else{
                    databaseReference.child("Cuenta").child(usuario).child("Alimentadores").child(identificador).child("porcentaje_llenar").setValue(25);
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(porcentaje_comida>=50){
                    Toast.makeText(getApplicationContext(), "El alimentador tiene más del 50 en su plato.",Toast.LENGTH_SHORT).show();
                }
                else{
                    databaseReference.child("Cuenta").child(usuario).child("Alimentadores").child(identificador).child("porcentaje_llenar").setValue(50);
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(porcentaje_comida>=75){
                    Toast.makeText(getApplicationContext(), "El alimentador tiene más del 75 en su plato.",Toast.LENGTH_SHORT).show();
                }
                else{
                    databaseReference.child("Cuenta").child(usuario).child("Alimentadores").child(identificador).child("porcentaje_llenar").setValue(75);
                }
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(porcentaje_comida == 100){
                    Toast.makeText(getApplicationContext(), "El alimentador tiene el plato lleno.",Toast.LENGTH_SHORT).show();
                }
                else{
                    databaseReference.child("Cuenta").child(usuario).child("Alimentadores").child(identificador).child("porcentaje_llenar").setValue(100);
                }
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

}
