package com.ggpl.bnilucknow;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.ggpl.bnilucknow.databinding.ActivityProfileBinding;



public class ProfileActivity extends AppCompatActivity {
    ActivityProfileBinding binding;

    private ImageView imageView;
    private TextView titleTextView;
    private TextView textTextView;
    private TextView text2TextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        initview();
        onclickListener();


       // int imageId = getIntent().getIntExtra("imageId", 0);
        String title = getIntent().getStringExtra("title");
        String text = getIntent().getStringExtra("text");
        String categoery = getIntent().getStringExtra("categoery");
        String myAsk = getIntent().getStringExtra("myAsk");
        String myGive = getIntent().getStringExtra("myGive");
        String mobNo = getIntent().getStringExtra("mobNo");
        String companyname = getIntent().getStringExtra("companyname");
        String business = getIntent().getStringExtra("business");
        int imageResourceId = getIntent().getIntExtra("imageResourceId", 0);
        //String imagePath = getIntent().getStringExtra("imagePath");



        // Set data to views
        binding.name.setText(title);
        binding.businessCategoery.setText(categoery);
        binding.lname.setText(text);
        binding.MyAsk.setText(myAsk);
        binding.Mygive.setText(myGive);
        binding.mobileNo.setText(mobNo);
        binding.comapneName.setText(companyname);
        binding.business.setText(business);
        binding.profileImage.setImageResource(imageResourceId);

    }

    private void onclickListener() {
        binding.backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, BNI_Chapters_Activity2.class));
            }
        });

    }

    private void initview() {




    }



    }
