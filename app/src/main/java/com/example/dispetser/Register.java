package com.example.dispetser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    EditText user, nombre, apellido, contra, confirma, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
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
    public void volver(View view) {
        Intent i = new Intent(this, Login.class);
        startActivity(i);
        finish();
    }

    public void registrar(View view){
        if(!(user.getText().toString().equals("") || nombre.getText().toString().equals("") || apellido.getText().toString().equals("")
        || contra.getText().toString().equals("") || confirma.getText().toString().equals("") || email.getText().toString().equals("")) ){
            Intent i = new Intent(this, Actions.class);
            i.putExtra("username", user.getText().toString());
            startActivity(i);
            finish();
        }else{Toast.makeText(this, "Complete los datos de su perfil",Toast.LENGTH_SHORT).show();}
    }
}