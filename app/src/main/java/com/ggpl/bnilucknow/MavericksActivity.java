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
import com.ggpl.bnilucknow.Adapter.MavericksAdapter;
import com.ggpl.bnilucknow.Model.MasterModel.MavericksModel;
import com.ggpl.bnilucknow.Retrofit.Api;
import com.ggpl.bnilucknow.Retrofit.Retrofit_Instance;
import com.ggpl.bnilucknow.databinding.ActivityMavericksBinding;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MavericksActivity extends AppCompatActivity {
ActivityMavericksBinding binding;
    private Api api;
    private List<MavericksModel> mavericksModels = new ArrayList<>();
    private MavericksAdapter mavericksAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding= ActivityMavericksBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        initview();
        fetchDataFromApi();

        binding.backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MavericksActivity.this, BNI_Chapters_Activity2.class));
            }
        });
    }

    private void initview() {

        mavericksAdapter =new MavericksAdapter(mavericksModels,this);
        binding.recyclerview.setHasFixedSize(true);
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        binding.recyclerview.setAdapter(mavericksAdapter);
    }

    private void fetchDataFromApi() {
        binding.progress.setVisibility(View.VISIBLE); // Show the progress bar

        Api api = Retrofit_Instance.getClient1().create(Api.class);
        Call<List<MavericksModel>> call = api.getMeveriksdata();
        call.enqueue(new Callback<List<MavericksModel>>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(@NonNull Call<List<MavericksModel>> call, @NonNull Response<List<MavericksModel>> response) {
                binding.progress.setVisibility(View.GONE); // Hide the progress bar

                if (response.isSuccessful()) {
                    List<MavericksModel> responseBody = response.body();
                    if (responseBody != null) {
                        mavericksModels.addAll(responseBody);
                        mavericksAdapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(MavericksActivity.this, "No data available", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Log.e("API Error", "Failed to fetch data: " + response.code());
                    Toast.makeText(MavericksActivity.this, "Failed to fetch data. Please try again later.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<MavericksModel>> call, @NonNull Throwable t) {
                binding.progress.setVisibility(View.GONE); // Hide the progress bar
                Log.e("API Error", "Failed to fetch data: " + t.getMessage());
                Toast.makeText(MavericksActivity.this, "An error occurred: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}