package com.example.careersync;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.careersync.model.LoginAuth;
import com.example.careersync.model.UserT;

import java.io.IOException;

import retrofit2.Response;

public class Login extends AppCompatActivity {

    private static final String KEY_PASSWORD = "password";
    public static String USERNAME;
    //    public static UserT userT;
    EditText etUserName, etPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUserName = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = etUserName.getText().toString();
                String password = etPassword.getText().toString();
                LoginAuth userCredentials = new LoginAuth(userName, password);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        perFormLogin(userCredentials);
                    }
                }).start();

            }
        });
    }

    private void perFormLogin(LoginAuth userCredentials) {
        try {
            Response<UserT> response = RetrofitClient.getInstance().apiInterface.login(userCredentials).execute();
            if (response.isSuccessful()) {
                UserT userT = response.body();
                Constants.setUserT(userT);
                Log.d("api", userT.toString());
                Constants.MESSAGE = getString(R.string.login_successfully);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        setLoginStatus(true, userT.getUserName());
                        navigateToHome(Constants.MESSAGE, userT.getUserName());
                    }
                });
            } else {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(Login.this, "incorrect username or password", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        } catch (IOException e) {
            Log.e("api", "error in login  " + e.getLocalizedMessage());
        }
    }

    private void setLoginStatus(Boolean isLoggedIn, String userName) {
        SharedPreferences sharedPreferences = getSharedPreferences("login_preference", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isLoggedIn", isLoggedIn);
        editor.putString("userName", userName);
        editor.apply();
    }

    private void navigateToHome(String message, String userName) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
//        USERNAME = userName;
        Intent intent = new Intent(Login.this, HomeActivity.class);
        intent.putExtra("userName", userName);
        startActivity(intent);
    }
}