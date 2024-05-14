package com.ggpl.bnilucknow;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.ggpl.bnilucknow.Adapter.ApexAdapter;
import com.ggpl.bnilucknow.Adapter.ProsperityAdapter;
import com.ggpl.bnilucknow.Model.MasterModel.ApexMember;
import com.ggpl.bnilucknow.Model.MasterModel.ProsperityModel;
import com.ggpl.bnilucknow.Retrofit.Api;
import com.ggpl.bnilucknow.Retrofit.Retrofit_Instance;
import com.ggpl.bnilucknow.databinding.ActivityProsperityChapterBinding;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ProsperityChapterActivity extends AppCompatActivity {
ActivityProsperityChapterBinding binding;
    private Api api;
    private List<ProsperityModel> prosperityModels = new ArrayList<>();
    private ProsperityAdapter prosperityAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding= ActivityProsperityChapterBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        initview();
        fetchDataFromApi();

        binding.backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProsperityChapterActivity.this, BNI_Chapters_Activity2.class));
            }
        });

    }

    private void initview() {
        prosperityAdapter  =new ProsperityAdapter(prosperityModels,this);
        binding.recyclerview.setHasFixedSize(true);
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        binding.recyclerview.setAdapter(prosperityAdapter);


    }

    private void fetchDataFromApi() {
        binding.progress.setVisibility(View.VISIBLE); // Show the progress bar

        Api api = Retrofit_Instance.getClient1().create(Api.class);
        Call<List<ProsperityModel>> call = api.getProsperityData();
        call.enqueue(new Callback<List<ProsperityModel>>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(@NonNull Call<List<ProsperityModel>> call, @NonNull Response<List<ProsperityModel>> response) {
                binding.progress.setVisibility(View.GONE); // Hide the progress bar

                if (response.isSuccessful()) {
                    List<ProsperityModel> responseBody = response.body();
                    if (responseBody != null) {
                        prosperityModels.addAll(responseBody);
                        prosperityAdapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(ProsperityChapterActivity.this, "No data available", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Log.e("API Error", "Failed to fetch data: " + response.code());
                    Toast.makeText(ProsperityChapterActivity.this, "Failed to fetch data. Please try again later.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<ProsperityModel>> call, @NonNull Throwable t) {
                binding.progress.setVisibility(View.GONE); // Hide the progress bar
                Log.e("API Error", "Failed to fetch data: " + t.getMessage());
                Toast.makeText(ProsperityChapterActivity.this, "An error occurred: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}