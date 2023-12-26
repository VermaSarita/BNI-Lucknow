package com.ggpl.bnilucknow;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.ggpl.bnilucknow.databinding.ActivityChapterMember2Binding;
import java.util.ArrayList;
import java.util.List;


public class Chapter_Member_Activity2 extends AppCompatActivity {
ActivityChapterMember2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityChapterMember2Binding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        initview();

    }

    private void initview() {

        List<RegionalTeamModel> regionalTeamModels = new ArrayList<>();
        regionalTeamModels.add(new RegionalTeamModel(R.drawable.girl,"ABUBHUTI DWIVEDI","Director Consultant-MASTERS","Iron Craft"));
        regionalTeamModels.add(new RegionalTeamModel(R.drawable.girl,"ABUBHUTI DWIVEDI","Director Consultant-MASTERS","Iron Craft"));
        regionalTeamModels.add(new RegionalTeamModel(R.drawable.girl,"ABUBHUTI DWIVEDI","Director Consultant-MASTERS","Iron Craft"));
        regionalTeamModels.add(new RegionalTeamModel(R.drawable.girl,"ABUBHUTI DWIVEDI","Director Consultant-MASTERS","Iron Craft"));
        regionalTeamModels.add(new RegionalTeamModel(R.drawable.girl,"ABUBHUTI DWIVEDI","Director Consultant-MASTERS","Iron Craft"));
        regionalTeamModels.add(new RegionalTeamModel(R.drawable.girl,"ABUBHUTI DWIVEDI","Director Consultant-MASTERS","Iron Craft"));
        regionalTeamModels.add(new RegionalTeamModel(R.drawable.girl,"ABUBHUTI DWIVEDI","Director Consultant-MASTERS","Iron Craft"));
        regionalTeamModels.add(new RegionalTeamModel(R.drawable.girl,"ABUBHUTI DWIVEDI","Director Consultant-MASTERS","Iron Craft"));
        regionalTeamModels.add(new RegionalTeamModel(R.drawable.girl,"ABUBHUTI DWIVEDI","Director Consultant-MASTERS","Iron Craft"));
        regionalTeamModels.add(new RegionalTeamModel(R.drawable.girl,"ABUBHUTI DWIVEDI","Director Consultant-MASTERS","Iron Craft"));

        RegionalTeamAdapter regionalTeamAdapter =new RegionalTeamAdapter(regionalTeamModels,this);
        binding.recyclerview.setHasFixedSize(true);
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        binding.recyclerview.setAdapter(regionalTeamAdapter);

    }
}