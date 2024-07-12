package com.example.a2024b_integrative_client.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import com.example.a2024b_integrative_client.My_Signal;
import com.example.a2024b_integrative_client.R;
import com.example.a2024b_integrative_client.api.RetrofitClient;
import com.example.a2024b_integrative_client.api.UserApi;
import com.example.a2024b_integrative_client.model.CurrentUser;
import com.example.a2024b_integrative_client.model.user.UserBoundary;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class activity_login extends AppCompatActivity {

    private MaterialTextView Login_LBL_Login;
    private AppCompatEditText Login_EDT_Email;
    private MaterialButton Login_BTN_Login;
    private UserApi mApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
        mApi = RetrofitClient.getInstance().create(UserApi.class);

        findView();

        Login_BTN_Login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(activity_login.this, activity_main_screen.class);
//                startActivity(intent);
//                finish(); // Optional: Finish current activity to prevent going back to login screen
//            }
            @Override
            public void onClick(View view) {
                login(Login_EDT_Email.getText().toString());
            }
        });
    }

    private void login(String email){
        String supperapp = "2024B.gal.angel";
        mApi.login(supperapp,email).enqueue(new Callback<UserBoundary>() {
            @Override
            public void onResponse(Call<UserBoundary> call, Response<UserBoundary> response) {
                if (response.isSuccessful()) {
                    openUserAccount(response.body());
                } else {
                    My_Signal.getInstance().toast("API call failed: " + response.code());
                }
            }
            @Override
            public void onFailure(Call<UserBoundary> call, Throwable t) {
                My_Signal.getInstance().toast("API call failed: " + t.getMessage());
            }
        });
    }
    private void openUserAccount(UserBoundary body) {
        //Todo: load all the details
        CurrentUser.init(body);
        Intent intent = new Intent(this, activity_main_screen.class);
        intent.putExtra("UserBoundary", body);
        startActivity(intent);
    }

    private void findView() {
        Login_LBL_Login =findViewById(R.id.Login_LBL_Login);
        Login_EDT_Email =findViewById(R.id.Login_EDT_Email);
        Login_BTN_Login =findViewById(R.id.Login_BTN_Login);

    }
}
