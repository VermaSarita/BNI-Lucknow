package com.ggpl.bnilucknow;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import com.ggpl.bnilucknow.databinding.ActivityBniChapters2Binding;
import java.util.ArrayList;
import java.util.List;


public class BNI_Chapters_Activity2 extends AppCompatActivity {
    ActivityBniChapters2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityBniChapters2Binding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        initview();
        onClickListener();

    }

    private void onClickListener() {
        binding.backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BNI_Chapters_Activity2.this, BNI_Lucknow_Fragment.class));
            }
        });

    }

    private void initview() {

        List<ChapterModel>chapterModels = new ArrayList<>();
        chapterModels.add(new ChapterModel(R.drawable.masterchapter,"Master Chapter"));
        chapterModels.add(new ChapterModel(R.drawable.primechapter,"Prime Chapter"));
        chapterModels.add(new ChapterModel(R.drawable.apexchapter,"Apex Chapter"));
        chapterModels.add(new ChapterModel(R.drawable.emberaldchapter,"Emeralds Chapter"));
        chapterModels.add(new ChapterModel(R.drawable.prosperitychapter,"Prosperity Chapter"));
        chapterModels.add(new ChapterModel(R.drawable.mavericckschapter,"Mavericks Chapter"));

        ChapterAdapter chapterAdapter=new ChapterAdapter(chapterModels,this);
        GridLayoutManager layoutManager=new GridLayoutManager(getApplicationContext(),3);
        binding.recycleViewStagged.setLayoutManager(layoutManager);
        binding.recycleViewStagged.setAdapter(chapterAdapter);


    }
}