package com.example.a2024b_integrative_client.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a2024b_integrative_client.R;
import com.example.a2024b_integrative_client.model.user.UserBoundary;

public class activity_main_screen extends AppCompatActivity {
    TextView welcome_text;
    SearchView search_text;
    Button search_button;
    UserBoundary userBoundary;
    String userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_application_screen);
        findView();
        NevigationActivity.findNevigationButtens(this,userBoundary);
        Intent prev=getIntent();
        userBoundary = (UserBoundary)prev.getSerializableExtra("UserBoundary");
        userName = userBoundary.getUsername();
        welcome_text.setText("Welcome " + userName);
    }
    private void findView() {
        welcome_text = findViewById(R.id.welcome_text);
        search_text = findViewById(R.id.search_text);
        search_button = findViewById(R.id.search_button);
    }
}
