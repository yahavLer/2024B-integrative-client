package com.example.a2024b_integrative_client.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a2024b_integrative_client.Adapter.ObjectAdapter;
import com.example.a2024b_integrative_client.R;
import com.example.a2024b_integrative_client.api.MiniAppCommandApi;
import com.example.a2024b_integrative_client.api.ObjectApi;
import com.example.a2024b_integrative_client.api.RetrofitClient;
import com.example.a2024b_integrative_client.api.UserApi;
import com.example.a2024b_integrative_client.model.object.ObjectBoundary;
import com.example.a2024b_integrative_client.model.user.UserBoundary;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class activity_benefit_of_club extends AppCompatActivity {
    RecyclerView main_LST_benefit;
    TextView benefit_text;
    String json;
    String clubName;
    List<ObjectBoundary> benefit_objects;
    UserBoundary userBoundary;
    ObjectApi objectApi;
    MiniAppCommandApi commandApi;
    UserApi userApi;
    Gson gson = new Gson();
    String jsonUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.benefit_of_club_screen);
        findView();
        objectApi = RetrofitClient.getInstance().create(ObjectApi.class);
        commandApi = RetrofitClient.getInstance().create(MiniAppCommandApi.class);
        userApi = RetrofitClient.getInstance().create(UserApi.class);

        Intent intent = getIntent();
        json = intent.getStringExtra("benefitList");
        clubName = intent.getStringExtra("clubName");
        jsonUser = intent.getStringExtra("UserBoundary");
        if (jsonUser != null) {
            userBoundary = gson.fromJson(jsonUser, UserBoundary.class);
        }
        NevigationActivity.findNevigationButtens(this, userBoundary);
        benefit_text.setText("Benefit of " + clubName);
        if (json != null) {
            Gson gson = new Gson();
            Type type = new TypeToken<ArrayList<ObjectBoundary>>() {
            }.getType();
            benefit_objects = gson.fromJson(json, type);
        } else {
            Log.e("ActivityStoresOfClubScreen", "No benefits list received");
        }
        initViewsBenefit(benefit_objects);
    }

    private void findView() {
        benefit_text = findViewById(R.id.benefit_text);
        main_LST_benefit = findViewById(R.id.benefit_of_club_recycler_view);
    }

    private void initViewsBenefit(List<ObjectBoundary> benefit_objects) {
        ObjectAdapter objectAdapter = new ObjectAdapter(benefit_objects);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity_benefit_of_club.this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        main_LST_benefit.setLayoutManager(linearLayoutManager);
        main_LST_benefit.setAdapter(objectAdapter);
    }
}
