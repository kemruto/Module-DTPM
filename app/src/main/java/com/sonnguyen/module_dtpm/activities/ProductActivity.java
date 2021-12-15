package com.sonnguyen.module_dtpm.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.sonnguyen.module_dtpm.adapters.ProductAdapter;
import com.sonnguyen.module_dtpm.adapters.UsersAdapter;
import com.sonnguyen.module_dtpm.databinding.ActivityProductBinding;
import com.sonnguyen.module_dtpm.helper.ConnectionHelper;
import com.sonnguyen.module_dtpm.model.Product;
import com.sonnguyen.module_dtpm.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends AppCompatActivity {
    private ActivityProductBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loadData();
    }

    private void loadData() {
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            Connection connection = connectionHelper.connectionClass();
            if (connection != null) {
                String sqlSelect = "Select * from SanPham";
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(sqlSelect);
                List<Product> productList = new ArrayList<>();
                while (rs.next()) {
                    Product product = new Product();
                    product.nameProduct = rs.getString(2);
                    product.image = rs.getString(3);
                    product.price = rs.getString(7);
                    productList.add(product);
                }
                if (productList.size() > 0) {
                    ProductAdapter productAdapter = new ProductAdapter(productList);
                    binding.productsRecyclerView.setAdapter(productAdapter);
                    binding.productsRecyclerView.setVisibility(View.VISIBLE);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}