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
import com.ggpl.bnilucknow.Model.MasterModel.ApexMember;
import com.ggpl.bnilucknow.Retrofit.Api;
import com.ggpl.bnilucknow.Retrofit.Retrofit_Instance;
import com.ggpl.bnilucknow.databinding.ActivityApexChapertBinding;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ApexChapertActivity extends AppCompatActivity {
 ActivityApexChapertBinding binding;
    private Api api;
    private List<ApexMember> apexMemberList = new ArrayList<>();
    private ApexAdapter apexAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding= ActivityApexChapertBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
         initview();
        fetchDataFromApi();

        binding.backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ApexChapertActivity.this, BNI_Chapters_Activity2.class));
            }
        });

    }

    private void initview() {
        apexAdapter = new ApexAdapter(apexMemberList, this); // Initialize the class-level apexAdapter variable
        binding.recyclerview.setHasFixedSize(true);
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        binding.recyclerview.setAdapter(apexAdapter);
    }
    private void fetchDataFromApi() {
        binding.progress.setVisibility(View.VISIBLE); // Show the progress bar

        Api api = Retrofit_Instance.getClient1().create(Api.class);
        Call<List<ApexMember>> call = api.getAppData();
        call.enqueue(new Callback<List<ApexMember>>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(@NonNull Call<List<ApexMember>> call, @NonNull Response<List<ApexMember>> response) {
                binding.progress.setVisibility(View.GONE); // Hide the progress bar

                if (response.isSuccessful()) {
                    List<ApexMember> responseBody = response.body();
                    if (responseBody != null) {
                        apexMemberList.addAll(responseBody);
                        apexAdapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(ApexChapertActivity.this, "No data available", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Log.e("API Error", "Failed to fetch data: " + response.code());
                    Toast.makeText(ApexChapertActivity.this, "Failed to fetch data. Please try again later.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<ApexMember>> call, @NonNull Throwable t) {
                binding.progress.setVisibility(View.GONE); // Hide the progress bar
                Log.e("API Error", "Failed to fetch data: " + t.getMessage());
                Toast.makeText(ApexChapertActivity.this, "An error occurred: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}