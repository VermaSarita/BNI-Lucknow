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
import com.ggpl.bnilucknow.Adapter.PrimeAdapter;
import com.ggpl.bnilucknow.Model.MasterModel.PrimePrime;
import com.ggpl.bnilucknow.Retrofit.Api;
import com.ggpl.bnilucknow.Retrofit.Retrofit_Instance;
import com.ggpl.bnilucknow.databinding.ActivityPrimeChapterBinding;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PrimeChapterActivity extends AppCompatActivity {
    ActivityPrimeChapterBinding binding;
    private List<PrimePrime> primePrimeList = new ArrayList<>();
    private PrimeAdapter primeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPrimeChapterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initview();
        fetchDataFromApi();

        binding.backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PrimeChapterActivity.this, BNI_Chapters_Activity2.class));
            }
        });

    }

    private void initview() {
        primeAdapter = new PrimeAdapter(primePrimeList, this);
        binding.recyclerview.setHasFixedSize(true);
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        binding.recyclerview.setAdapter(primeAdapter);
    }

    private void fetchDataFromApi() {
        binding.progress.setVisibility(View.VISIBLE); // Show the progress bar

        Api api = Retrofit_Instance.getClient1().create(Api.class);
        Call<List<PrimePrime>> call = api.getPrimeData();
        call.enqueue(new Callback<List<PrimePrime>>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(@NonNull Call<List<PrimePrime>> call, @NonNull Response<List<PrimePrime>> response) {
                binding.progress.setVisibility(View.GONE); // Hide the progress bar

                if (response.isSuccessful()) {
                    List<PrimePrime> responseBody = response.body();
                    if (responseBody != null) {
                        primePrimeList.addAll(responseBody);
                        primeAdapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(PrimeChapterActivity.this, "No data available", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Log.e("API Error", "Failed to fetch data: " + response.code());
                    Toast.makeText(PrimeChapterActivity.this, "Failed to fetch data. Please try again later.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<PrimePrime>> call, @NonNull Throwable t) {
                binding.progress.setVisibility(View.GONE); // Hide the progress bar
                Log.e("API Error", "Failed to fetch data: " + t.getMessage());
                Toast.makeText(PrimeChapterActivity.this, "An error occurred: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
