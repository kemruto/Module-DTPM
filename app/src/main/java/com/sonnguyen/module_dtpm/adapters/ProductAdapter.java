package com.sonnguyen.module_dtpm.adapters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sonnguyen.module_dtpm.R;
import com.sonnguyen.module_dtpm.databinding.ItemContainerProductBinding;
import com.sonnguyen.module_dtpm.model.Product;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductsViewHolder> {
    private final List<Product> products;

    public ProductAdapter(List<Product> products) {
        this.products = products;
    }

    @NonNull
    @Override
    public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemContainerProductBinding itemContainerProductBinding = ItemContainerProductBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new ProductsViewHolder(itemContainerProductBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsViewHolder holder, int position) {
        holder.setProductData(products.get(position));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ProductsViewHolder extends RecyclerView.ViewHolder {
        ItemContainerProductBinding binding;

        public ProductsViewHolder(@NonNull ItemContainerProductBinding itemContainerProductBinding) {
            super(itemContainerProductBinding.getRoot());
            binding = itemContainerProductBinding;
        }

        void setProductData(Product product) {
            if(product.image!=null){
                binding.imageProduct.setImageBitmap(getProductImage(product.image));
            }else{
                binding.imageProduct.setBackgroundResource(R.drawable.ic_hide_image);
            }
            binding.textNameProduct.setText(product.nameProduct);
            binding.textPrice.setText(product.price);
        }

        private Bitmap getProductImage(String encodedImage) {
            byte[] bytes = Base64.decode(encodedImage, Base64.DEFAULT);
            return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        }
    }
}
