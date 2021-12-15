package com.sonnguyen.module_dtpm.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sonnguyen.module_dtpm.databinding.ItemContainerUserBinding;
import com.sonnguyen.module_dtpm.model.User;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersViewHolder> {
    private final List<User> users;


    public UsersAdapter(List<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemContainerUserBinding itemContainerUserBinding = ItemContainerUserBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new UsersViewHolder(itemContainerUserBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersViewHolder holder, int position) {
        holder.setUserData(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class UsersViewHolder extends RecyclerView.ViewHolder {
        ItemContainerUserBinding binding;

        public UsersViewHolder(@NonNull ItemContainerUserBinding itemContainerUserBinding) {
            super(itemContainerUserBinding.getRoot());
            binding = itemContainerUserBinding;
        }

        void setUserData(User user) {
            binding.textName.setText(user.name);
            binding.textRole.setText(user.role);
            binding.textPhone.setText(user.phone);
            binding.textEmail.setText(user.email);
        }
    }
}
