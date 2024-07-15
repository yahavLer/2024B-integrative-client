package com.example.a2024b_integrative_client.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a2024b_integrative_client.R;
import com.example.a2024b_integrative_client.model.object.ObjectBoundary;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ActivityBenefitScreen extends AppCompatActivity {
    TextView benefitTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.benefit_screen);

        benefitTextView = findViewById(R.id.benefit_text);

        Intent intent = getIntent();
        String json = intent.getStringExtra("benefitList");
        if (json != null) {
            Gson gson = new Gson();
            Type type = new TypeToken<ArrayList<ObjectBoundary>>() {}.getType();
            ArrayList<ObjectBoundary> benefitList = gson.fromJson(json, type);

            StringBuilder benefitText = new StringBuilder();
            for (ObjectBoundary benefit : benefitList) {
                benefitText.append(benefit.toString()).append("\n\n");
            }
            benefitTextView.setText(benefitText.toString());
        } else {
            Log.e("ActivityBenefitScreen", "No benefit list received");
        }
    }
}
