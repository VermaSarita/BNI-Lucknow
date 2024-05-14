package com.ggpl.bnilucknow;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.ggpl.bnilucknow.Model.MasterModel.masterMember;
import com.ggpl.bnilucknow.RegionalTeamAdapter;
import com.ggpl.bnilucknow.Retrofit.Api;
import com.ggpl.bnilucknow.Retrofit.Retrofit_Instance;
import com.ggpl.bnilucknow.databinding.ActivityChapterMember2Binding;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Chapter_Member_Activity2 extends AppCompatActivity {
    ActivityChapterMember2Binding binding;
    private Api api;
    private List<masterMember> masterMemberList = new ArrayList<>();
    private RegionalTeamAdapter regionalTeamAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChapterMember2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initview();
        fetchDataFromApi();

        binding.backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Chapter_Member_Activity2.this, BNI_Chapters_Activity2.class));
            }
        });
    }

    private void initview() {
        regionalTeamAdapter = new RegionalTeamAdapter(masterMemberList, this);
        binding.recyclerview.setHasFixedSize(true);
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        binding.recyclerview.setAdapter(regionalTeamAdapter);
    }

    private void fetchDataFromApi() {
        binding.progress.setVisibility(View.VISIBLE); // Show the progress bar

        Api api = Retrofit_Instance.getClient1().create(Api.class);
        Call<List<masterMember>> call = api.getMasters();
        call.enqueue(new Callback<List<masterMember>>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(@NonNull Call<List<masterMember>> call, @NonNull Response<List<masterMember>> response) {
                binding.progress.setVisibility(View.GONE); // Hide the progress bar

                if (response.isSuccessful()) {
                    List<masterMember> responseBody = response.body();
                    if (responseBody != null) {
                        masterMemberList.addAll(responseBody);
                        regionalTeamAdapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(Chapter_Member_Activity2.this, "No data available", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Log.e("API Error", "Failed to fetch data: " + response.code());
                    Toast.makeText(Chapter_Member_Activity2.this, "Failed to fetch data. Please try again later.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<masterMember>> call, @NonNull Throwable t) {
                binding.progress.setVisibility(View.GONE); // Hide the progress bar
                Log.e("API Error", "Failed to fetch data: " + t.getMessage());
                Toast.makeText(Chapter_Member_Activity2.this, "An error occurred: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
