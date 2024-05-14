package com.ggpl.bnilucknow;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.ggpl.bnilucknow.Adapter.EmeraldAdapter;
import com.ggpl.bnilucknow.Model.MasterModel.EmeraldModel;
import com.ggpl.bnilucknow.Retrofit.Api;
import com.ggpl.bnilucknow.Retrofit.Retrofit_Instance;
import com.ggpl.bnilucknow.databinding.ActivityEmeraldBinding;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class EmeraldActivity extends AppCompatActivity {
    ActivityEmeraldBinding binding;
    private Api api;
    private List<EmeraldModel> emeraldModelList = new ArrayList<>();
    private EmeraldAdapter emeraldAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEmeraldBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initview();
        onclickListener();
        fetchDataFromApi();

    }

    private void initview() {
        emeraldAdapter = new EmeraldAdapter(emeraldModelList, this);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        binding.recyclerview.setLayoutManager(layoutManager);
        binding.recyclerview.setAdapter(emeraldAdapter);

    }

    private void onclickListener() {
        binding.backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EmeraldActivity.this, BNI_Chapters_Activity2.class));
            }
        });
    }

    private void fetchDataFromApi() {
        binding.progress.setVisibility(View.VISIBLE); // Show the progress bar

        Api api = Retrofit_Instance.getClient1().create(Api.class);
        Call<List<EmeraldModel>> call = api.getEmeraldData();
        call.enqueue(new Callback<List<EmeraldModel>>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(@NonNull Call<List<EmeraldModel>> call, @NonNull Response<List<EmeraldModel>> response) {
                binding.progress.setVisibility(View.GONE); // Hide the progress bar

                if (response.isSuccessful()) {
                    List<EmeraldModel> responseBody = response.body();
                    if (responseBody != null) {
                        emeraldModelList.addAll(responseBody);
                        emeraldAdapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(EmeraldActivity.this, "No data available", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Log.e("API Error", "Failed to fetch data: " + response.code());
                    Toast.makeText(EmeraldActivity.this, "Failed to fetch data. Please try again later.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<EmeraldModel>> call, @NonNull Throwable t) {
                binding.progress.setVisibility(View.GONE); // Hide the progress bar
                Log.e("API Error", "Failed to fetch data: " + t.getMessage());
                Toast.makeText(EmeraldActivity.this, "An error occurred: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
