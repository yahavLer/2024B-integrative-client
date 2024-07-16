package com.example.a2024b_integrative_client.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a2024b_integrative_client.Adapter.ObjectAdapter;
import com.example.a2024b_integrative_client.My_Signal;
import com.example.a2024b_integrative_client.ObjectCallback;
import com.example.a2024b_integrative_client.R;
import com.example.a2024b_integrative_client.api.MiniAppCommandApi;
import com.example.a2024b_integrative_client.api.ObjectApi;
import com.example.a2024b_integrative_client.api.RetrofitClient;
import com.example.a2024b_integrative_client.api.UserApi;
import com.example.a2024b_integrative_client.model.CurrentUser;
import com.example.a2024b_integrative_client.model.miniappCommand.CreatedBy;
import com.example.a2024b_integrative_client.model.miniappCommand.MiniAppCommandBoundary;
import com.example.a2024b_integrative_client.model.miniappCommand.TargetObject;
import com.example.a2024b_integrative_client.model.object.ObjectBoundary;
import com.example.a2024b_integrative_client.model.user.UserBoundary;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class activity_clubs extends AppCompatActivity implements ObjectCallback {
    UserBoundary userBoundary;
    List<ObjectBoundary> club_objects;
    RecyclerView main_LST_club;
    TextView welcome_text;
    SearchView search_text;
    Button search_button;
    ObjectApi objectApi;
    MiniAppCommandApi commandApi;
    UserApi userApi;
    String jsonUser;
    Gson gson = new Gson();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clubs_screen);
        objectApi = RetrofitClient.getInstance().create(ObjectApi.class);
        commandApi = RetrofitClient.getInstance().create(MiniAppCommandApi.class);
        userApi = RetrofitClient.getInstance().create(UserApi.class);
        Intent prev=getIntent();
        jsonUser= prev.getStringExtra("UserBoundary");
        if(jsonUser!=null){
            userBoundary=gson.fromJson(jsonUser, UserBoundary.class);
        }
        findView();
        NevigationActivity.findNevigationButtens(this,userBoundary);
        club_objects = initViewsClubs(userBoundary);
        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String club =search_text.getQuery().toString();
                Log.e("search_text", "search_text: " + club);
                findClub(club, userBoundary);
                search_text.setQuery("", false);
                search_text.clearFocus();
            }
        });
    }

    private void findClub(String clubName, UserBoundary userBoundary) {
        ObjectBoundary clubBoundary;
        String superapp = CurrentUser.getInstance().getTheUser().getUserId().getSuperapp();
        String email = CurrentUser.getInstance().getTheUser().getUserId().getEmail();
        objectApi.searchObjectsByExactAlias(clubName, superapp, email,1,0).enqueue(new Callback<List<ObjectBoundary>>() {
            @Override
            public void onResponse(Call<List<ObjectBoundary>> call, Response<List<ObjectBoundary>> response) {
                if (response.isSuccessful()) {
                    if (response.body()!=null){
                        List<ObjectBoundary> objectBoundary = response.body();
                        for (int i=0 ; i<objectBoundary.size();i++){
                            Log.e("club " + i, objectBoundary.get(i).getAlias() +"\n");
                        }
                        ObjectAdapter objectAdapter = new ObjectAdapter(objectBoundary);
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity_clubs.this);
                        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
                        main_LST_club.setLayoutManager(linearLayoutManager);
                        main_LST_club.setAdapter(objectAdapter);
                    }
                } else {
                    My_Signal.getInstance().toast("API call failed: " + response.code());
                }
            }
            @Override
            public void onFailure(Call<List<ObjectBoundary>> call, Throwable t) {
                My_Signal.getInstance().toast("API call failed: " + t.getMessage());
            }
        });
    }

    private List<ObjectBoundary> initViewsClubs(UserBoundary userBoundary){
        List<ObjectBoundary>club_objects = new ArrayList<>();
        String superapp = CurrentUser.getInstance().getTheUser().getUserId().getSuperapp();
        String email = CurrentUser.getInstance().getTheUser().getUserId().getEmail();
        objectApi.searchObjectsByType("club", superapp,email, 10,0 ).enqueue(new Callback<List<ObjectBoundary>>() {
            @Override
            public void onResponse(Call<List<ObjectBoundary>> call, Response<List<ObjectBoundary>> response) {
                if (response.isSuccessful()) {
                    if (response.body()!=null){
                        List<ObjectBoundary> objectBoundary = response.body();
                        for (int i=0 ; i<objectBoundary.size();i++){
                            Log.e("club " + i, objectBoundary.get(i).getAlias() +"\n");
                        }
                        ObjectAdapter objectAdapter = new ObjectAdapter(objectBoundary);
                        objectAdapter.setObjectCallback(activity_clubs.this); // הגדרת callback
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity_clubs.this);
                        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
                        main_LST_club.setLayoutManager(linearLayoutManager);
                        main_LST_club.setAdapter(objectAdapter);
                    }
                } else {
                    My_Signal.getInstance().toast("API call failed: " + response.code());
                }
            }
            @Override
            public void onFailure(Call<List<ObjectBoundary>> call, Throwable t) {
                My_Signal.getInstance().toast("API call failed: " + t.getMessage());
            }
        });
        return club_objects;
    }

    @Override
    public void onObjectClick(ObjectBoundary object) {
        TargetObject clubTargetObject = new TargetObject(object.getObjectId());
        CreatedBy createdBy = new CreatedBy(userBoundary.getUserId());
        MiniAppCommandBoundary commandBoundary = new MiniAppCommandBoundary("findBenefitsByClub", clubTargetObject, createdBy);

        Log.d("commandBoundary", "Command: " + commandBoundary.getCommand());
        Log.d("commandBoundary", "Target Object: " + commandBoundary.getTargetObject().getObjectId());
        Log.d("commandBoundary", "Created By: " + commandBoundary.getInvokedBy().getUserId().getEmail());
        Log.d("commandBoundary", "Timestamp: " + commandBoundary.getInvocationTimestamp());

        commandApi.invokeCommand("findYourBenefit", false, commandBoundary).enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                Log.e("club ", "command");
                if (response.isSuccessful()) {
                    Object responseBody = response.body();
                    ArrayList<Object> benefit = (ArrayList<Object>) responseBody;
                    Gson gson = new Gson();
                    String json = gson.toJson(benefit);
                    Type type = new TypeToken<ArrayList<ObjectBoundary>>() {}.getType();
                    ArrayList<ObjectBoundary> benefitList = gson.fromJson(json, type);

                    for (int i = 0; i < benefitList.size(); i++) {
                        Log.e("benefit  " + i, benefitList.get(i).toString() + "\n");
                    }

                    Intent intent = new Intent(activity_clubs.this, activity_stores_of_club.class);
                    intent.putExtra("benefitList", gson.toJson(benefitList));
                    intent.putExtra("clubName", object.getAlias());
                    intent.putExtra("UserBoundary", jsonUser);
                    startActivity(intent);

                    Log.d("API_CALL", "Success: ");
                } else {
                    Log.d("API_CALL", "Failed: " + response.code() + ", Error body: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                Log.e("API_CALL", "Error: " + t.getMessage());
            }
        });
    }


    private void findView() {
        welcome_text = findViewById(R.id.welcome_text);
        search_text = findViewById(R.id.search_text);
        search_button = findViewById(R.id.search_button);
        main_LST_club = findViewById(R.id.club_recycler_view);
    }
}