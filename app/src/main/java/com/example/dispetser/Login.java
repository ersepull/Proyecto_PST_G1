package com.example.dispetser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void registro(View view){
        Intent i = new Intent(this, Register.class );
        //i.putExtra("direccion", et1.getText().toString());
        startActivity(i);
    }
    public void acciones(View view){
        EditText et1 = (EditText) findViewById(R.id.editText);
        Intent i = new Intent(this, Actions.class );
        i.putExtra("username", et1.getText().toString());
        startActivity(i);
    }
}