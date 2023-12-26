package com.ggpl.bnilucknow;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.ggpl.bnilucknow.databinding.ActivityGalleryDetail2Binding;


public class Gallery_Detail_Activity2 extends AppCompatActivity {
    private ImageView imageView;
    ActivityGalleryDetail2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityGalleryDetail2Binding.inflate(getLayoutInflater( ));
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot( ));


        int imageId = getIntent( ).getIntExtra("imageId", 0);

        binding.fullimage.setImageResource(imageId);

    }
}