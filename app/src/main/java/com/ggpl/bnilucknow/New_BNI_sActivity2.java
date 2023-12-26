package com.ggpl.bnilucknow;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.os.Bundle;

import com.ggpl.bnilucknow.databinding.ActivityNewBniSactivity2Binding;

import java.util.ArrayList;
import java.util.List;

public class New_BNI_sActivity2 extends AppCompatActivity {
    ActivityNewBniSactivity2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewBniSactivity2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initViews();
        setOnClickListener();
    }

    private void setOnClickListener() {


    }

    private void initViews() {
        //*************top news*************//
        List<NewsModel> newsModels = new ArrayList<>();
        newsModels.add(new NewsModel(R.drawable.news, "Adobe is bringing generative AI to Photoshop...", "Google has announced a new tool, \"About this Image...", "Archna"));
        NewsAdapter newsAdapter = new NewsAdapter(newsModels, getApplicationContext());
        binding.Topnews.setHasFixedSize(true);
        binding.Topnews.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        binding.Topnews.setAdapter(newsAdapter);

        //*************all news*************//

        List<DifferentNewsModel> differentNewsModels = new ArrayList<>();
        differentNewsModels.add(new DifferentNewsModel(R.drawable.news, "Benjamin Vallejo, Jr., marine biology professor at the Institute of Environmental Science and Meteorology, University of the Philippines Diliman ..", "Invasive species can have serious impacts on human health, native species and local economies. For instance, consumption of shellfish contaminated by toxic algae – some species of which are transferred to new areas in ballast water – can cause severe illness and death.The prototype of the sterilising system, funded by the Philippine Council for Industry, Energy, and Emerging Technology Research and Development, uses a combination of ultraviolet rays and mechanical methods to reduce the number of invasive species in ballast water. "));
        differentNewsModels.add(new DifferentNewsModel(R.drawable.news5, "Benjamin Vallejo, Jr., marine biology professor at the Institute of Environmental Science and Meteorology, University of the Philippines Diliman ..", "Invasive species can have serious impacts on human health, native species and local economies. For instance, consumption of shellfish contaminated by toxic algae – some species of which are transferred to new areas in ballast water – can cause severe illness and death.The prototype of the sterilising system, funded by the Philippine Council for Industry, Energy, and Emerging Technology Research and Development, uses a combination of ultraviolet rays and mechanical methods to reduce the number of invasive species in ballast water."));
        differentNewsModels.add(new DifferentNewsModel(R.drawable.news6, "Benjamin Vallejo, Jr., marine biology professor at the Institute of Environmental Science and Meteorology, University of the Philippines Diliman ..", "Invasive species can have serious impacts on human health, native species and local economies. For instance, consumption of shellfish contaminated by toxic algae – some species of which are transferred to new areas in ballast water – can cause severe illness and death.The prototype of the sterilising system, funded by the Philippine Council for Industry, Energy, and Emerging Technology Research and Development, uses a combination of ultraviolet rays and mechanical methods to reduce the number of invasive species in ballast water."));
        DifferentNewsAdapter differentNewsAdapter = new DifferentNewsAdapter(differentNewsModels, getApplicationContext());

        binding.AllNewsRecyclerview.setHasFixedSize(true);
        binding.AllNewsRecyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        binding.AllNewsRecyclerview.setAdapter(differentNewsAdapter);

    }
}
