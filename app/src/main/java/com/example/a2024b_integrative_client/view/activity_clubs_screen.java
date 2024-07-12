package com.example.a2024b_integrative_client.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a2024b_integrative_client.R;
import com.example.a2024b_integrative_client.model.user.UserBoundary;

public class activity_clubs_screen extends AppCompatActivity {
    UserBoundary userBoundary;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clubs_screen);
        Intent prev=getIntent();
        userBoundary = (UserBoundary)prev.getSerializableExtra("UserBoundary");
        NevigationActivity.findNevigationButtens(this,userBoundary);
    }
}
