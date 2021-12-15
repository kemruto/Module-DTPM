package com.sonnguyen.module_dtpm.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.widget.Toast;

import com.sonnguyen.module_dtpm.databinding.ActivityInsertUserBinding;
import com.sonnguyen.module_dtpm.helper.ConnectionHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertUserActivity extends AppCompatActivity {
    private ActivityInsertUserBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInsertUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setListeners();
    }

    private void setListeners() {
        binding.buttonInsert.setOnClickListener(v -> {
            if (isValidDataInsert()) {
                insertData();
            }
        });
    }

    private void insertData() {
        String name = binding.inputName.getText().toString();
        String phone = binding.inputPhone.getText().toString();
        String email = binding.inputEmail.getText().toString();
        String password = binding.inputPassword.getText().toString();
        String status = binding.inputStatus.getText().toString();

        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connection = connectionHelper.connectionClass();
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

    private Boolean isValidDataInsert() {
        if (binding.inputName.getText().toString().trim().isEmpty()) {
            showToast("Hãy nhập họ tên");
            return false;
        } else if (binding.inputPhone.getText().toString().trim().isEmpty()) {
            showToast("Hãy nhập sđt");
            return false;
        } else if (binding.inputPassword.getText().toString().trim().isEmpty()) {
            showToast("Hãy nhập password");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(binding.inputEmail.getText().toString()).matches()) {
            showToast("Nhập sai định dạng email");
            return false;
        } else if (!binding.inputStatus.getText().toString().trim().equals("Nhan vien")
                || !binding.inputStatus.getText().toString().trim().equals("User")) {
            showToast("");
            return false;
        } else if (binding.inputEmail.getText().toString().trim().isEmpty()) {
            showToast("Hãy nhập email");
            return false;
        } else {
            return true;
        }
    }

    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}