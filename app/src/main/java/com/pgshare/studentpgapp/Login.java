package com.pgshare.studentpgapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class Login extends AppCompatActivity {


    TextInputEditText EtMail,EtPass;
    TextView Create_acc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EtMail=findViewById(R.id.EmailEt);
        EtPass=findViewById(R.id.PassEt);

        Create_acc=findViewById(R.id.ViewCreateAccount);
        Create_acc.setOnClickListener(view -> {
            Intent i=new Intent(Login.this, Register.class);
            startActivity(i);
        });


    }

    public void loginBtn(View view) {
        String Email = EtMail.getText().toString();
        String Pass = EtPass.getText().toString();

        if (TextUtils.isEmpty(Email)) {
            EtMail.setError("Please enter a Username");
            return;
        }

        if (TextUtils.isEmpty(Pass)) {
            EtPass.setError("Please enter a Password");
            return;
        }
        Intent HomeIntent=new Intent(Login.this, MainActivity.class);
        startActivity(HomeIntent);
    }
}