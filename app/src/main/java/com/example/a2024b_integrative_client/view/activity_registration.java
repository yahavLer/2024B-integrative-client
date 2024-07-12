package com.example.a2024b_integrative_client.view;

import static com.example.a2024b_integrative_client.RoleEnumBoundary.ADM_USER;
import static com.example.a2024b_integrative_client.RoleEnumBoundary.MINIAPP_USER;
import static com.example.a2024b_integrative_client.RoleEnumBoundary.SUPERAPP_USER;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import com.example.a2024b_integrative_client.My_Signal;
import com.example.a2024b_integrative_client.R;
import com.example.a2024b_integrative_client.RoleEnumBoundary;
import com.example.a2024b_integrative_client.api.RetrofitClient;
import com.example.a2024b_integrative_client.api.UserApi;
import com.example.a2024b_integrative_client.model.CurrentUser;
import com.example.a2024b_integrative_client.model.user.NewUserBoundary;
import com.example.a2024b_integrative_client.model.user.UserBoundary;
import com.google.android.material.button.MaterialButton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class activity_registration extends AppCompatActivity {
    private AppCompatEditText signup_EDT_username;
    private AppCompatEditText signup_EDT_email;
    private AppCompatEditText signup_EDT_avatar;
    private AppCompatEditText signup_EDT_phone;
    private Spinner signup_SPN_roles;
    private Spinner signup_SPN_credit_card_company;
    private Spinner signup_SPN_club_membership;
    private MaterialButton signup_BTN_Register;
    private UserApi mApi;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_screen);
        mApi = RetrofitClient.getInstance().create(UserApi.class);
        findView();

        signup_SPN_roles.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });
        signup_BTN_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createUser
                        (signup_EDT_username.getText().toString(),
                        signup_EDT_email.getText().toString(),
                        signup_EDT_avatar.getText().toString(),
                        signup_EDT_phone.getText().toString(),
                        signup_SPN_roles.getSelectedItem().toString(),
                        signup_SPN_credit_card_company.getSelectedItem().toString(),
                        signup_SPN_club_membership.getSelectedItem().toString());
                signup_EDT_username.getText().clear();
                signup_EDT_email.getText().clear();
                signup_EDT_avatar.getText().clear();
                signup_EDT_phone.getText().clear();
                //TODO: clear spinner
            }
        });
    }

    private void findView() {
        signup_EDT_username =findViewById(R.id.signup_EDT_username);
        signup_EDT_email = findViewById(R.id.signup_EDT_email);
        signup_EDT_avatar = findViewById(R.id.signup_EDT_avatar);
        signup_EDT_phone = findViewById(R.id.signup_EDT_phone);
        signup_SPN_roles = findViewById(R.id.signup_SPN_roles);
        signup_SPN_credit_card_company = findViewById(R.id.signup_SPN_credit_card_company);
        signup_SPN_club_membership = findViewById(R.id.signup_SPN_club_membership);
        signup_BTN_Register = findViewById(R.id.signup_BTN_Register);
        String[] rolesArray = getResources().getStringArray(R.array.roles);
        String[] creditCardArray = getResources().getStringArray(R.array.credit_card_companies);
        String[] clubArray = getResources().getStringArray(R.array.clubs_membership);

        ArrayAdapter<String> roleAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item,rolesArray);
        signup_SPN_roles.setAdapter(roleAdapter);

        ArrayAdapter<String> creditCardAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item,creditCardArray);
        signup_SPN_credit_card_company.setAdapter(creditCardAdapter);

        ArrayAdapter<String> clubAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item,clubArray);
        signup_SPN_club_membership.setAdapter(clubAdapter);
    }

    private RoleEnumBoundary convertStringToEnum(String role){
        switch (role) {
            case "ADMIN":
                return ADM_USER;
            case "SUPERAPP_USER":
                return SUPERAPP_USER;
            case "MINIAPP_USER":
                return MINIAPP_USER;
            default:
                throw new IllegalArgumentException("Unknown role: " + role);
        }
    }

    private void createUser(String username, String email, String avatar, String phone, String role, String card, String club) {
        RoleEnumBoundary roleEnum=convertStringToEnum(role);
        NewUserBoundary newUser = new NewUserBoundary(roleEnum, username, avatar, email);
        mApi.createUser(newUser).enqueue(new Callback<UserBoundary>() {
            @Override
            public void onResponse(Call<UserBoundary> call, Response<UserBoundary> response) {
                if (response.isSuccessful()) {
                    if (response.body()!=null){
                        Log.e("createUser", "Response body: " + response.body().toString());
                        UserBoundary userBoundary = response.body();
                        Log.e("createUser", "UserId: " + userBoundary.getUserId());
                        Log.e("createUser", "Username: " + userBoundary.getUsername());
                        Log.e("createUser", "Role: " + userBoundary.getRole());
                        Log.e("createUser", "Avatar: " + userBoundary.getAvatar());

                        Log.e("createUser: ", "user creat succesfully" );
                    }else{
                        Log.e("UserBoundrey is null: " , "");
                    }
                    confirmNewUserUI(response.body());
                } else {
                    My_Signal.getInstance().toast("API call failed: " + response.code());
                }
            }
            @Override
            public void onFailure(Call<UserBoundary> call, Throwable t) {
                My_Signal.getInstance().toast("API call failed: " + t.getMessage());
            }
        });
        Log.e("createUser: ",newUser.getUsername());
    }

    private void confirmNewUserUI(UserBoundary user) {
        //TODO: check to add a delay before remove to the home page to show the success message
        CurrentUser.init(user);
        Intent intent = new Intent(activity_registration.this, activity_main_screen.class);
        intent.putExtra("userName", user.getUsername());
        startActivity(intent);
    }

}