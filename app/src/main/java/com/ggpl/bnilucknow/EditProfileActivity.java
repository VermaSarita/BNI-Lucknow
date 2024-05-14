package com.ggpl.bnilucknow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ggpl.bnilucknow.databinding.ActivityEditProfileBinding;

public class EditProfileActivity extends AppCompatActivity {
ActivityEditProfileBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityEditProfileBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());


    }
}