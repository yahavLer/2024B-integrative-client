package com.example.a2024b_integrative_client.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a2024b_integrative_client.R;
import com.example.a2024b_integrative_client.model.user.UserBoundary;

public class activity_profile_screen extends AppCompatActivity {
    UserBoundary userBoundary;
    TextView EDT_username;
    TextView EDT_email;
    TextView EDT_userId;
    TextView EDT_role;
    Button btn_favorite;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_screen);
        Intent prev=getIntent();
        userBoundary = (UserBoundary)prev.getSerializableExtra("UserBoundary");
        findView();
        NevigationActivity.findNevigationButtens(this,userBoundary);
        EDT_username.setText(userBoundary.getUsername());
        EDT_email.setText(userBoundary.getUserId().getEmail());
        EDT_userId.setText(userBoundary.getUserId().getSuperAPP()+" "+ userBoundary.getUserId().getEmail());
        EDT_role.setText(userBoundary.getRole().toString());
    }

    private void findView() {
        EDT_username = findViewById(R.id.profile_EDT_username);
        EDT_email = findViewById(R.id.profile_EDT_email);
        EDT_userId = findViewById(R.id.profile_EDT_userId);
        EDT_role = findViewById(R.id.profile_EDT_role);
        btn_favorite = findViewById(R.id.btn_favorite);
    }
}
