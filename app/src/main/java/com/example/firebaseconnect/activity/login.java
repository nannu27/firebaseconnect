package com.example.firebaseconnect.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.firebaseconnect.R;

public class login extends AppCompatActivity {
    Button login;
    TextView registratiin;
    EditText text_user, text_pass;
    CheckBox keeplogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = findViewById(R.id.login);
        registratiin = findViewById(R.id.registration);
        text_user = findViewById(R.id.username);
        text_pass = findViewById(R.id.password);
        keeplogin = findViewById(R.id.keeplogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),tab_activity.class);
                startActivity(intent);
            }
        });

    }
}
