package com.example.a2024b_integrative_client.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a2024b_integrative_client.R;

public class activity_welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcom_screen);

        Button btnRegister = findViewById(R.id.btn_register);
        Button btnLogin = findViewById(R.id.btn_login);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_welcome.this, activity_registration.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_welcome.this, activity_login.class);
                startActivity(intent);
            }
        });
    }
}