package com.ggpl.bnilucknow;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import com.ggpl.bnilucknow.AllChapterModel;
import com.ggpl.bnilucknow.Retrofit.Api;
import com.ggpl.bnilucknow.Retrofit.Retrofit_Instance;
import com.ggpl.bnilucknow.databinding.ActivityBniChapters2Binding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BNI_Chapters_Activity2 extends AppCompatActivity {
    private ActivityBniChapters2Binding binding;
    private Api api;
    private List<AllChapterModel> allChapterModels = new ArrayList<>();
    private ChapterAdapter chapterAdapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBniChapters2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initview();
        onClickListener();
        fetchDataFromApi();
    }

    private void onClickListener() {
        binding.backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BNI_Chapters_Activity2.this, MainActivity.class));
                finish();
            }
        });
    }

    private void initview() {
        chapterAdapter1 = new ChapterAdapter(allChapterModels, this);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        binding.recycleViewStagged.setLayoutManager(layoutManager);
        binding.recycleViewStagged.setAdapter(chapterAdapter1);
    }

    private void fetchDataFromApi() {
        binding.progress.setVisibility(View.VISIBLE);

        api = Retrofit_Instance.getClient().create(Api.class);
        Call<List<AllChapterModel>> call = api.getData();
        call.enqueue(new Callback<List<AllChapterModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<AllChapterModel>> call, @NonNull Response<List<AllChapterModel>> response) {
                binding.progress.setVisibility(View.GONE);

                if (response.isSuccessful()) {
                    List<AllChapterModel> responseBody = response.body();
                    if (responseBody != null) {
                        allChapterModels.addAll(responseBody);
                        chapterAdapter1.notifyDataSetChanged();
                    }
                } else {
                    Log.e("API Error", "Failed to fetch data: " + response.code());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<AllChapterModel>> call, @NonNull Throwable t) {
                binding.progress.setVisibility(View.GONE);
                Log.e("API Error", "Failed to fetch data: " + t.getMessage());
            }
        });
    }
}
