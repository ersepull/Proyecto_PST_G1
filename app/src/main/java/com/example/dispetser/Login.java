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


public class Login extends AppCompatActivity {
    EditText username, password;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

    }
    public void registro(View view){
        Intent i = new Intent(this, Register.class );
        i.putExtra("username", username.getText().toString());
        i.putExtra("password", password.getText().toString());
        startActivity(i);
        username.setText("");
        password.setText("");
        finish();
    }
    public void acciones (View view){
        inicializarFirebase();
        if(!username.getText().toString().equals("") && !password.getText().toString().equals("")){
        Intent i = new Intent(this, Actions.class );
        i.putExtra("username", username.getText().toString());
        startActivity(i);
        username.setText("");
        password.setText("");
        finish();}
        else{Toast.makeText(this, "Ingrese los datos completos",Toast.LENGTH_SHORT).show();}
        Intent i = new Intent(this, Actions.class );
        if(username.equals("Grupo_1") && password.equals("12345")){
            startActivity(i);

        }
    }
    private void inicializarFirebase(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }


}