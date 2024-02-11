package com.example.careersync;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isLoggedIn()) {
                    SharedPreferences sharedPreferences = getSharedPreferences("login_preference", MODE_PRIVATE);
                    String userName = sharedPreferences.getString("userName", "");
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    intent.putExtra("userName", userName);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(MainActivity.this, Login.class);
                    startActivity(intent);
                }
                finish();
            }
        }, 2000);
    }

    private boolean isLoggedIn() {
        SharedPreferences sharedPreferences = getSharedPreferences("login_preference", MODE_PRIVATE);
        return sharedPreferences.getBoolean("isLoggedIn", false);
    }
}