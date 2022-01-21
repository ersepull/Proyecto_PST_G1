package com.example.dispetser;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

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

public class Estadisticas extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    TextView mensaje;
    Spinner opciones;
    String usuario;
    String alimentador;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        inicializarFirebase();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);
        Bundle bundle = getIntent().getExtras();
        mensaje = (TextView) findViewById(R.id.mensajeEstadisticas);
        opciones= (Spinner)findViewById(R.id.spinner1);
        usuario = databaseReference.child("Cuenta").child(bundle.getString("username")).getKey();
        DatabaseReference rf1= firebaseDatabase.getReference("Cuenta");
        rf1.child(usuario).child("Alimentadores").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<String> info = new ArrayList<>();
                final List<String> areas= new ArrayList<>();
                for(DataSnapshot areaSnapchot: snapshot.getChildren()){
                    String area_name= areaSnapchot.child("nombre").getValue(String.class);
                    String activacion = areaSnapchot.child("activacion").getValue(String.class);
                    String id = areaSnapchot.child("id").getValue(String.class);
                    String porcentaje_comida = areaSnapchot.child("porcentaje_comida").getValue(String.class);
                    String porcentaje_llenar = areaSnapchot.child("porcentaje_llenar").getValue(String.class);
                    String infoAlimentador = area_name + "," + (activacion) + "," + id + "," + (porcentaje_comida) + "," + (porcentaje_llenar);
                    areas.add(area_name);
                    info.add(infoAlimentador);
                }
                ArrayAdapter<String> areasAdapter= new ArrayAdapter<String>(Estadisticas.this, android.R.layout.simple_spinner_item,areas);
                opciones.setAdapter(areasAdapter);

                opciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        alimentador = parent.getSelectedItem().toString();

                            mensaje.setText(alimentador);



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
