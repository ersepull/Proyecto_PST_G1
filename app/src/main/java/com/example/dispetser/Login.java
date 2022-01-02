package com.example.dispetser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class Login extends AppCompatActivity {
    EditText username, password;

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
    }
    public void acciones(View view){
        if(!username.getText().toString().equals("") && !password.getText().toString().equals("")){
        Intent i = new Intent(this, Actions.class );
        i.putExtra("username", username.getText().toString());
        startActivity(i);
        username.setText("");
        password.setText("");}
        else{Toast.makeText(this, "Ingrese los datos completos",Toast.LENGTH_SHORT).show();}
    }
}