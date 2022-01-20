package com.example.dispetser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


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
            databaseReference.child("Cuenta").child(username.getText().toString()).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if(snapshot.exists()){
                        databaseReference.child("Cuenta").child(username.getText().toString()).child("clave").addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if(snapshot.exists()){
                                    if(snapshot.getValue().toString().equals(password.getText().toString())){
                                        Intent i = new Intent(getApplicationContext(), Actions.class);
                                        i.putExtra("username", username.getText().toString());
                                        startActivity(i);
                                        username.setText("");
                                        password.setText("");
                                        finish();
                                    }else{
                                        Toast.makeText(getApplicationContext(),"La clave ingresada es incorrecta, intente nuevamente",Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
                    }else{
                        Toast.makeText(getApplicationContext(),"El nombre de usuario que está ingresando no existe",Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
        else{Toast.makeText(this, "Ingrese los datos completos",Toast.LENGTH_SHORT).show();}
    }
    private void inicializarFirebase(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }


}