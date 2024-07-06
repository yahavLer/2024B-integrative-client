package com.example.a2024b_integrative_client.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a2024b_integrative_client.R;
import com.google.android.material.button.MaterialButton;

public class activity_main_screen extends AppCompatActivity {
    TextView welcome_text;
    SearchView search_text;
    Button search_button;
    String userName;
    MaterialButton navigation_home;
    MaterialButton navigation_profile;
    MaterialButton navigation_clubs;
    MaterialButton navigation_credit_cards;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_application_screen);
        findView();
        userName = getIntent().getStringExtra("userName");
        welcome_text.setText("Welcome " + userName);
        setupButtonListeners();

    }
    private void setupButtonListeners() {
        navigation_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHome = new Intent(activity_main_screen.this, activity_main_screen.class);
                startActivity(intentHome);
            }
        });

        navigation_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentProfile = new Intent(activity_main_screen.this, activity_profile_screen.class);
                startActivity(intentProfile);
            }
        });

        navigation_clubs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentClubs = new Intent(activity_main_screen.this, activity_clubs_screen.class);
                startActivity(intentClubs);
            }
        });

        navigation_credit_cards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCards = new Intent(activity_main_screen.this, activity_credit_cards_screen.class);
                startActivity(intentCards);
            }
        });
    }

    private void findView() {
        welcome_text = findViewById(R.id.welcome_text);
        search_text = findViewById(R.id.search_text);
        search_button = findViewById(R.id.search_button);
        navigation_home = findViewById(R.id.navigation_home);
        navigation_profile = findViewById(R.id.navigation_profile);
        navigation_clubs = findViewById(R.id.navigation_clubs) ;
        navigation_credit_cards = findViewById(R.id.navigation_credit_cards);
    }
}
