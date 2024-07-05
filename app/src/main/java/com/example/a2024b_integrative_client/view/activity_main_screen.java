package com.example.a2024b_integrative_client.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a2024b_integrative_client.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class activity_main_screen extends AppCompatActivity {
    TextView welcome_text;
    SearchView search_text;
    Button search_button;
    BottomNavigationView bottom_navigation;
    String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_application_screen);
        findView();
        userName = getIntent().getStringExtra("userName");
        welcome_text.setText("Welcome " + userName);
        setupBottomNavigation();

    }

    private void setupBottomNavigation() {
        bottom_navigation.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        // Action when Home is clicked
                        welcome_text.setText("Home selected");
                        Intent intent_main = new Intent(activity_main_screen.this, activity_main_screen.class);
                        startActivity(intent_main);
                        return true;
                    case R.id.navigation_profile:
                        // Action when Profile is clicked
                        Intent intent_profile = new Intent(activity_main_screen.this, activity_profile_screen.class);
                        startActivity(intent_profile);
                        return true;
                    case R.id.navigation_clubs:
                        // Action when Clubs is clicked
                        Intent intent_clubs = new Intent(activity_main_screen.this, activity_clubs_screen.class);
                        startActivity(intent_clubs);
                        return true;
                    case R.id.navigation_credit_cards:
                        // Action when Credit Cards is clicked
                        welcome_text.setText("Credit Cards selected");
                        return true;
                }
                return false;
            }
        });
    }
    private void findView() {
        welcome_text = findViewById(R.id.welcome_text);
        search_text = findViewById(R.id.search_text);
        search_button = findViewById(R.id.search_button);
        bottom_navigation = findViewById(R.id.bottom_navigation);
    }
}
