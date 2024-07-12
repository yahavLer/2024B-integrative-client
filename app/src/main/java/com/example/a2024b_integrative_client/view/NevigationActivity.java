package com.example.a2024b_integrative_client.view;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.example.a2024b_integrative_client.R;
import com.example.a2024b_integrative_client.model.user.UserBoundary;
import com.google.android.material.button.MaterialButton;

public class NevigationActivity {

    public static void findNevigationButtens(Activity actvity, UserBoundary userBoundary) {
        MaterialButton navigation_home = actvity.findViewById(R.id.navigation_home);
        MaterialButton navigation_profile = actvity.findViewById(R.id.navigation_profile);
        MaterialButton navigation_clubs = actvity.findViewById(R.id.navigation_clubs);
        navigation_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHome = new Intent(actvity, activity_main_screen.class);
                intentHome.putExtra("UserBoundary", userBoundary);
                actvity.startActivity(intentHome);
            }
        });

        navigation_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentProfile = new Intent(actvity, activity_profile_screen.class);
                intentProfile.putExtra("UserBoundary", userBoundary);
                actvity.startActivity(intentProfile);
            }
        });

        navigation_clubs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentClubs = new Intent(actvity, activity_clubs_screen.class);
                intentClubs.putExtra("UserBoundary", userBoundary);
                actvity.startActivity(intentClubs);
            }
        });
    }
}



