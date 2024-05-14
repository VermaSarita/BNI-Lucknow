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
import com.ggpl.bnilucknow.Adapter.MaestrosAdapter;
import com.ggpl.bnilucknow.Model.MasterModel.MaestrosModel;
import com.ggpl.bnilucknow.Retrofit.Api;
import com.ggpl.bnilucknow.Retrofit.Retrofit_Instance;
import com.ggpl.bnilucknow.databinding.ActivityMaestrosBinding;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MaestrosActivity extends AppCompatActivity {
ActivityMaestrosBinding binding;
    private Api api;
    private List<MaestrosModel> maestrosModels = new ArrayList<>();
    private MaestrosAdapter maestrosAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMaestrosBinding.inflate( getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        initview();
        fetchDataFromApi();

        binding.backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MaestrosActivity.this, BNI_Chapters_Activity2.class));
            }
        });
    }

    private void initview() {

        maestrosAdapter  =new MaestrosAdapter(maestrosModels,this);
        binding.recyclerview.setHasFixedSize(true);
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        binding.recyclerview.setAdapter(maestrosAdapter);


    }

    private void fetchDataFromApi() {
        binding.progress.setVisibility(View.VISIBLE); // Show the progress bar

        Api api = Retrofit_Instance.getClient1().create(Api.class);
        Call<List<MaestrosModel>> call = api.getMaestrosData();
        call.enqueue(new Callback<List<MaestrosModel>>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(@NonNull Call<List<MaestrosModel>> call, @NonNull Response<List<MaestrosModel>> response) {
                binding.progress.setVisibility(View.GONE); // Hide the progress bar

                if (response.isSuccessful()) {
                    List<MaestrosModel> responseBody = response.body();
                    if (responseBody != null) {
                        maestrosModels.addAll(responseBody);
                        maestrosAdapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(MaestrosActivity.this, "No data available", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Log.e("API Error", "Failed to fetch data: " + response.code());
                    Toast.makeText(MaestrosActivity.this, "Failed to fetch data. Please try again later.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<MaestrosModel>> call, @NonNull Throwable t) {
                binding.progress.setVisibility(View.GONE); // Hide the progress bar
                Log.e("API Error", "Failed to fetch data: " + t.getMessage());
                Toast.makeText(MaestrosActivity.this, "An error occurred: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}