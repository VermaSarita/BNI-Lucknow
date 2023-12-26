package com.ggpl.bnilucknow;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import android.os.Bundle;
import com.ggpl.bnilucknow.databinding.ActivityCategoery2Binding;
import java.util.ArrayList;
import java.util.List;


public class CategoeryActivity2 extends AppCompatActivity {
    private RecyclerView recyclerView;
    ActivityCategoery2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityCategoery2Binding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        initview();
        OnclickListener();

    }

    private void initview() {

        List<CategoeryModel> categoeryModels = new ArrayList<>();
        categoeryModels.add(new CategoeryModel(R.drawable.event,"EVENT AND WEDDING"));
        categoeryModels.add(new CategoeryModel(R.drawable.branding,"BRANDING AND MARKETING"));
        categoeryModels.add(new CategoeryModel(R.drawable.training,"TRAINING AND EDUCATION"));
        categoeryModels.add(new CategoeryModel(R.drawable.jewelry,"JEWELLERY"));
        categoeryModels.add(new CategoeryModel(R.drawable.travel,"TRAVEL"));
        categoeryModels.add(new CategoeryModel(R.drawable.food,"FOOD/BEVERAGES"));
        categoeryModels.add(new CategoeryModel(R.drawable.more,"OTHER"));
        categoeryModels.add(new CategoeryModel(R.drawable.accounting,"ACCOUNTANCY"));
        categoeryModels.add(new CategoeryModel(R.drawable.consultancy,"CONSULTANCY"));
        categoeryModels.add(new CategoeryModel(R.drawable.store,"REAL STATE"));
        categoeryModels.add(new CategoeryModel(R.drawable.realstate,"MANUFACTURING"));
        categoeryModels.add(new CategoeryModel(R.drawable.retail,"RETAIL"));
        //categoeryModels.add(new CategoeryModel(R.drawable.realstate,"BNI"));

        CategoeryAdapter categoeryAdapter =new CategoeryAdapter(categoeryModels, getApplicationContext());
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        binding.recyclerView.setAdapter(categoeryAdapter);

    }

    private void OnclickListener() {


    }
}