package com.sonnguyen.module_dtpm.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;

import com.sonnguyen.module_dtpm.databinding.ActivityMainBinding;

import java.sql.Connection;
import java.sql.DriverManager;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();
    }

    private void init() {
        binding.buttonInput.setOnClickListener(v -> {
            Intent intent = new Intent(this, InsertUserActivity.class);
            startActivity(intent);
        });
        binding.buttonViewData.setOnClickListener(v -> {
            Intent intent = new Intent(this, ViewUserActivity.class);
            startActivity(intent);
        });
    }

}

