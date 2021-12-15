package com.sonnguyen.module_dtpm.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.sonnguyen.module_dtpm.databinding.ActivityMainBinding;

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
        binding.buttonViewUser.setOnClickListener(v -> {
            Intent intent = new Intent(this, ViewUserActivity.class);
            startActivity(intent);
        });
        binding.buttonViewProduct.setOnClickListener(v -> {
            Intent intent = new Intent(this, ProductActivity.class);
            startActivity(intent);
        });
    }

}

