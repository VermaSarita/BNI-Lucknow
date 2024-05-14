package com.ggpl.bnilucknow;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.ggpl.bnilucknow.Model.Chapter.categoeryModel;
import com.ggpl.bnilucknow.Retrofit.Api;
import com.ggpl.bnilucknow.Retrofit.Retrofit_Instance;
import com.ggpl.bnilucknow.databinding.ActivityCategoery2Binding;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoeryActivity2 extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Api api;
    ActivityCategoery2Binding binding;
    private CategoeryAdapter categoeryAdapter;
    private List<categoeryModel>categoeryModelList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityCategoery2Binding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        initview();
        OnclickListener();
        fetchDataFromApi();

    }

    private void initview() {

        categoeryAdapter = new CategoeryAdapter(categoeryModelList, this);

        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        binding.recyclerView.setAdapter(categoeryAdapter);
    }

    private void OnclickListener() {

        binding.backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CategoeryActivity2.this, MainActivity.class));
            }
        });
    }

    private void fetchDataFromApi() {
        binding.progress.setVisibility(View.VISIBLE);
        Api api = Retrofit_Instance.getClient().create(Api.class);
        Call<List<categoeryModel>> call = api.getCategoery();
        call.enqueue(new Callback<List<categoeryModel>>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(@NonNull Call<List<categoeryModel>> call, @NonNull Response<List<categoeryModel>> response) {
                if (response.isSuccessful()) {
                    // Handle successful response
                    List<categoeryModel> responseBody = response.body();
                    if (responseBody != null) {
                        // Clear existing data before adding new data
                        categoeryModelList.clear();
                        categoeryModelList.addAll(responseBody);
                        categoeryAdapter.notifyDataSetChanged(); // Notify adapter of data change
                    }
                } else {
                    // Handle unsuccessful response
                    binding.errorMessage.setVisibility(View.VISIBLE); // Show error message TextView
                    Log.e("API Error", "Failed to fetch data: " + response.code());
                }
                // Hide the progress bar regardless of the response status
                binding.progress.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(@NonNull Call<List<categoeryModel>> call, @NonNull Throwable t) {
                // Hide the progress bar in case of failure
                binding.progress.setVisibility(View.GONE);
                binding.errorMessage.setVisibility(View.VISIBLE); // Show error message TextView
                Log.e("API Error", "Failed to fetch data: " + t.getMessage());
            }
        });
    }


}