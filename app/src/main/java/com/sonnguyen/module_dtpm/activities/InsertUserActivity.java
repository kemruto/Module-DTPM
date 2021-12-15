package com.sonnguyen.module_dtpm.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.widget.Toast;

import com.sonnguyen.module_dtpm.databinding.ActivityInsertUserBinding;
import com.sonnguyen.module_dtpm.helper.ConnectionHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertUserActivity extends AppCompatActivity {
    private ActivityInsertUserBinding binding;
    private Connection connection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInsertUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setListeners();
    }

    private void setListeners() {
        binding.buttonInsert.setOnClickListener(v -> insertData());
    }

    private void insertData() {
        String name = binding.inputName.getText().toString();
        String phone = binding.inputPhone.getText().toString();
        String email = binding.inputEmail.getText().toString();
        String password = binding.inputPassword.getText().toString();
        String status = binding.inputStatus.getText().toString();

        ConnectionHelper connectionHelper = new ConnectionHelper();
        connection = connectionHelper.connectionClass();
        try {
            if (connection != null) {
                String sqlInsert = "Insert into TaiKhoan values (' "
                        + name + " ',' " + phone + " ',' " + email + " ',' " + password + " ',' " + status + "')";
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(sqlInsert);
            }
        } catch (Exception e) {
            Log.e("aaa", "insertData: " + e.getMessage());
        }
    }
}