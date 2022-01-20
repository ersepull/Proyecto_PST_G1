package com.example.dispetser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {
    EditText user, nombre, apellido, contra, confirma, email;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        inicializarFirebase();
        Bundle bundle = getIntent().getExtras();
        user = (EditText) findViewById(R.id.user);
        nombre = (EditText) findViewById(R.id.nombre);
        apellido = (EditText) findViewById(R.id.apellido);
        contra = (EditText) findViewById(R.id.contra);
        confirma = (EditText) findViewById(R.id.confirma);
        email = (EditText) findViewById(R.id.email);

        user.setText(bundle.getString("username"));
        contra.setText(bundle.getString("password"));
        nombre.setText("");
        apellido.setText("");
        confirma.setText("");
        email.setText("");


    }
    private void inicializarFirebase(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference =firebaseDatabase.getReference();
    }
    public void volver(View view) {
        Intent i = new Intent(this, Login.class);
        startActivity(i);
        finish();
    }

    public void registrar(View view){
        if(!(user.getText().toString().equals("") || nombre.getText().toString().equals("") || apellido.getText().toString().equals("")
        || contra.getText().toString().equals("") || confirma.getText().toString().equals("") || email.getText().toString().equals(""))){
            Cuenta c= new Cuenta(user.getText().toString(),nombre.getText().toString(),apellido.getText().toString(),contra.getText().toString(),email.getText().toString());
            if(databaseReference.child("Cuenta").child(c.getUsuario()).equalTo("usuario").getClass()==null){
                databaseReference.child("Cuenta").child(c.getUsuario()).setValue(c);
                Toast.makeText(this, databaseReference.child("Cuenta").equalTo(c.getUsuario()).toString(),Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this, Actions.class);
                i.putExtra("username", user.getText().toString());
                startActivity(i);
                finish();}else{Toast.makeText(this, "El nombre de usuario ya esta en uso, escoja otro",Toast.LENGTH_SHORT).show();}
        }else{Toast.makeText(this, "Complete los datos de su perfil",Toast.LENGTH_SHORT).show();}
    }
}