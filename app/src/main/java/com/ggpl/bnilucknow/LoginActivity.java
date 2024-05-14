package com.ggpl.bnilucknow;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.ggpl.bnilucknow.Model.Login.RequestLogin;
import com.ggpl.bnilucknow.Model.Login.ResponseLogin;
import com.ggpl.bnilucknow.Retrofit.Api;
import com.ggpl.bnilucknow.Retrofit.Retrofit_Instance;
import com.ggpl.bnilucknow.databinding.ActivityLoginBinding;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    Api api;
    Retrofit_Instance retrofitInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(LoginActivity.this, MainActivity.class));
//                finishAffinity();
                validateUserLogin();
            }
        });
    }

    private void validateUserLogin() {
        String email = binding.email.getText().toString().trim();
        String password = binding.password.getText().toString().trim();
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Email or password cannot be empty", Toast.LENGTH_SHORT).show();
            return;
        }

        Api apiService = Retrofit_Instance.getClient().create(Api.class);
        Call<ResponseLogin> call = apiService.login(new RequestLogin(""+binding.email.getText().toString(),""+binding.password.getText().toString()));
        call.enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(@NonNull Call<ResponseLogin> call, @NonNull Response<ResponseLogin> response) {
                if (response.isSuccessful()) {
                    ResponseLogin responseLogin = response.body();
                    assert response.body() != null;
//                    if (response.body().getError().equalsIgnoreCase("1"))
                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finishAffinity();
                } else {
                    try {
                        Log.e("Login Error", "Failed to login. Response: " + response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                  Toast.makeText(LoginActivity.this, "Failed to login. Please try again later.", Toast.LENGTH_SHORT).show();
                }
                binding.loginbtn.setVisibility(View.VISIBLE);
                binding.progress.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "An error occurred: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                binding.loginbtn.setVisibility(View.VISIBLE);
                binding.progress.setVisibility(View.GONE);
            }
        });
        binding.loginbtn.setVisibility(View.GONE);
        binding.progress.setVisibility(View.VISIBLE);

    }


}
