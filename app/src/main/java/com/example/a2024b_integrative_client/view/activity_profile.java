package com.example.a2024b_integrative_client.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.a2024b_integrative_client.R;
import com.example.a2024b_integrative_client.model.user.UserBoundary;
import com.google.gson.Gson;

public class activity_profile extends AppCompatActivity {
    UserBoundary userBoundary;
    TextView EDT_Hello;
    TextView EDT_username;
    TextView EDT_email;
    TextView EDT_userId;
    TextView EDT_role;
    ImageView profileImage;
    Gson gson= new Gson();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_screen);
        Intent prev=getIntent();
        String json= prev.getStringExtra("UserBoundary");
        if(json!=null){
            userBoundary=gson.fromJson(json, UserBoundary.class);
        }
        findView();
        NevigationActivity.findNevigationButtens(this,userBoundary);
        if (userBoundary != null) {
            String avatarUrl = userBoundary.getAvatar();
            String userName = userBoundary.getUsername();
            EDT_Hello.setText("Hello " + userBoundary.getUsername());
            EDT_username.setText(userBoundary.getUsername());
            EDT_email.setText(userBoundary.getUserId().getEmail());
            EDT_userId.setText(userBoundary.getUserId().getSuperapp()+" "+ userBoundary.getUserId().getEmail());
            EDT_role.setText(userBoundary.getRole().toString());
            // Load the image using Glide
            Glide.with(this)
                    .load(avatarUrl)
                    .placeholder(R.drawable.unavailable_photo) // optional, shows while loading
                    .error(R.drawable.error) // optional, shows if there's an error
                    .into(profileImage);
        }

    }

    private void findView() {
        EDT_Hello = findViewById(R.id.Hello);
        EDT_username = findViewById(R.id.profile_EDT_username);
        EDT_email = findViewById(R.id.profile_EDT_email);
        EDT_userId = findViewById(R.id.profile_EDT_userId);
        EDT_role = findViewById(R.id.profile_EDT_role);
        profileImage = findViewById(R.id.profile_image);
    }
}
