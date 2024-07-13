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
import com.example.a2024b_integrative_client.model.object.ObjectBoundary;
import com.example.a2024b_integrative_client.model.user.UserBoundary;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class activity_main_screen extends AppCompatActivity implements ObjectCallback {
    List<ObjectBoundary> store_objects;
    RecyclerView main_LST_store;
    TextView welcome_text;
    SearchView search_text;
    Button search_button;
    UserBoundary userBoundary;
    String userName;
    ObjectApi objectApi;
    MiniAppCommandApi commandApi;
    UserApi userApi;
    Gson gson = new Gson();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_application_screen);
        objectApi = RetrofitClient.getInstance().create(ObjectApi.class);
        commandApi = RetrofitClient.getInstance().create(MiniAppCommandApi.class);
        userApi = RetrofitClient.getInstance().create(UserApi.class);
        Intent prev=getIntent();
        String json= prev.getStringExtra("UserBoundary");
        if(json!=null){
            userBoundary=gson.fromJson(json, UserBoundary.class);
        }
        findView();
        NevigationActivity.findNevigationButtens(this,userBoundary);

        userName = userBoundary.getUsername();
        welcome_text.setText("Welcome " + userName);
        store_objects = initViewsStores(userBoundary);
        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String store =search_text.getQuery().toString();
                Log.e("search_text", "search_text: " + store);
                findStore(store, userBoundary);
                search_text.setQuery("", false);
                search_text.clearFocus();
            }
        });
    }
    private void findStore(String store, UserBoundary userBoundary) {
        ObjectBoundary storeBoundary;
        String superapp = CurrentUser.getInstance().getTheUser().getUserId().getSuperapp();
        String email = CurrentUser.getInstance().getTheUser().getUserId().getEmail();
        objectApi.searchObjectsByExactAlias(store, superapp, email,1,0).enqueue(new Callback<List<ObjectBoundary>>() {
            @Override
            public void onResponse(Call<List<ObjectBoundary>> call, Response<List<ObjectBoundary>> response) {
                if (response.isSuccessful()) {
                    if (response.body()!=null){
                        List<ObjectBoundary> objectBoundary = response.body();
                        for (int i=0 ; i<objectBoundary.size();i++){
                            Log.e("store " + i, objectBoundary.get(i).getAlias() +"\n");
                        }
                        ObjectAdapter objectAdapter = new ObjectAdapter(objectBoundary);
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity_main_screen.this);
                        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
                        main_LST_store.setLayoutManager(linearLayoutManager);
                        main_LST_store.setAdapter(objectAdapter);
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
    private List<ObjectBoundary> initViewsStores(UserBoundary userBoundary){
        List<ObjectBoundary>store_objects = new ArrayList<>();
        String superapp = CurrentUser.getInstance().getTheUser().getUserId().getSuperapp();
        String email = CurrentUser.getInstance().getTheUser().getUserId().getEmail();
        objectApi.searchObjectsByType("store", superapp,email, 10,0 ).enqueue(new Callback<List<ObjectBoundary>>() {
            @Override
            public void onResponse(Call<List<ObjectBoundary>> call, Response<List<ObjectBoundary>> response) {
                if (response.isSuccessful()) {
                    if (response.body()!=null){
                        List<ObjectBoundary> objectBoundary = response.body();
                        for (int i=0 ; i<objectBoundary.size();i++){
                            Log.e("store " + i, objectBoundary.get(i).getAlias() +"\n");
                        }
                        ObjectAdapter objectAdapter = new ObjectAdapter(objectBoundary);
                        objectAdapter.setObjectCallback(activity_main_screen.this); // הגדרת callback
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity_main_screen.this);
                        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
                        main_LST_store.setLayoutManager(linearLayoutManager);
                        main_LST_store.setAdapter(objectAdapter);
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
        return store_objects;
    }
    @Override
    public void onObjectClick(ObjectBoundary object) {
        // טיפול באירוע הלחיצה על פריט ב-RecyclerView
        Log.d("activity_clubs_screen", "Clicked on: " + object.getAlias());
    }
    private void findView() {
        welcome_text = findViewById(R.id.welcome_text);
        search_text = findViewById(R.id.search_text);
        search_button = findViewById(R.id.search_button);
        main_LST_store = findViewById(R.id.club_recycler_view);
    }
}
