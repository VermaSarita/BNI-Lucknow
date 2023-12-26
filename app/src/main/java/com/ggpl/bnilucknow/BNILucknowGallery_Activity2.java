package com.ggpl.bnilucknow;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import android.os.Bundle;
import com.ggpl.bnilucknow.databinding.ActivityBnilucknowGallery2Binding;
import java.util.ArrayList;

public class BNILucknowGallery_Activity2 extends AppCompatActivity {
    private ArrayList<LucknowGalleryModel>lucknowGalleryModels;
    ActivityBnilucknowGallery2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityBnilucknowGallery2Binding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        initview();
        OnClickListener();

    }

    private void OnClickListener() {

    }

    private void initview() {

        //**********BNI ALLCATEGORY*****************//

        lucknowGalleryModels=new ArrayList<>();
        lucknowGalleryModels.add(new LucknowGalleryModel(R.drawable.galleryimage1,"BNI CHAPTERS"));
        lucknowGalleryModels.add(new LucknowGalleryModel(R.drawable.galleryimage2,"BNI CHAPTERS"));
        lucknowGalleryModels.add(new LucknowGalleryModel(R.drawable.galleryimage4,"BNI CHAPTERS"));
        lucknowGalleryModels.add(new LucknowGalleryModel(R.drawable.galleryimage5,"BNI CHAPTERS"));
        lucknowGalleryModels.add(new LucknowGalleryModel(R.drawable.galleryimage6,"BNI CHAPTERS"));
        lucknowGalleryModels.add(new LucknowGalleryModel(R.drawable.galleryimage8,"BNI CHAPTERS"));
        lucknowGalleryModels.add(new LucknowGalleryModel(R.drawable.galleryimage9,"BNI CHAPTERS"));
        lucknowGalleryModels.add(new LucknowGalleryModel(R.drawable.galleryimage10,"BNI CHAPTERS"));
        lucknowGalleryModels.add(new LucknowGalleryModel(R.drawable.galleryimage11,"BNI CHAPTERS"));
        lucknowGalleryModels.add(new LucknowGalleryModel(R.drawable.galleryimage12,"BNI CHAPTERS"));
        lucknowGalleryModels.add(new LucknowGalleryModel(R.drawable.galleryimage13,"BNI CHAPTERS"));
        lucknowGalleryModels.add(new LucknowGalleryModel(R.drawable.galleryimage14,"BNI CHAPTERS"));
        lucknowGalleryModels.add(new LucknowGalleryModel(R.drawable.galleryimage15,"BNI CHAPTERS"));
        lucknowGalleryModels.add(new LucknowGalleryModel(R.drawable.galleryimage16,"BNI CHAPTERS"));
        lucknowGalleryModels.add(new LucknowGalleryModel(R.drawable.galleryimage17,"BNI CHAPTERS"));
        lucknowGalleryModels.add(new LucknowGalleryModel(R.drawable.galleryimage18,"BNI CHAPTERS"));
        lucknowGalleryModels.add(new LucknowGalleryModel(R.drawable.galleryimage19,"BNI CHAPTERS"));
        lucknowGalleryModels.add(new LucknowGalleryModel(R.drawable.galleryimage20,"BNI CHAPTERS"));
        lucknowGalleryModels.add(new LucknowGalleryModel(R.drawable.galleryimage21,"BNI CHAPTERS"));
        lucknowGalleryModels.add(new LucknowGalleryModel(R.drawable.galleryimage22,"BNI CHAPTERS"));
        lucknowGalleryModels.add(new LucknowGalleryModel(R.drawable.galleryimage23,"BNI CHAPTERS"));
        lucknowGalleryModels.add(new LucknowGalleryModel(R.drawable.galleryimage24,"BNI CHAPTERS"));
        lucknowGalleryModels.add(new LucknowGalleryModel(R.drawable.galleryimage25,"BNI CHAPTERS"));
        lucknowGalleryModels.add(new LucknowGalleryModel(R.drawable.galleryimage26,"BNI CHAPTERS"));
        lucknowGalleryModels.add(new LucknowGalleryModel(R.drawable.galleryimage27,"BNI CHAPTERS"));
        lucknowGalleryModels.add(new LucknowGalleryModel(R.drawable.galleryimage1,"BNI CHAPTERS"));

        // bniLucknowModels.add(new BNILucknowModel(R.drawable.chapters,"BNI CHAPTERS"));

        LucknowGalleryAdapter lucknowGalleryAdapter=new LucknowGalleryAdapter(lucknowGalleryModels,this);
        GridLayoutManager layoutManager=new GridLayoutManager(getApplicationContext(),2);
        binding.recyclerview.setLayoutManager(layoutManager);
        binding.recyclerview.setAdapter(lucknowGalleryAdapter);
    }
}

