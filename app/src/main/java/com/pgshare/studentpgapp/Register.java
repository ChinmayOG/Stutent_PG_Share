package com.pgshare.studentpgapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {


    Button RegisterBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        RegisterBtn=findViewById(R.id.buttonRegister);
        RegisterBtn.setOnClickListener(view -> {
            Intent LoginIntent=new Intent(Register.this, Login.class);
            startActivity(LoginIntent);
        });


    }
}