package com.ggpl.bnilucknow;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import android.os.Bundle;

import com.ggpl.bnilucknow.databinding.ActivityMenberPin2Binding;

import java.util.ArrayList;
import java.util.List;


public class Menber_Pin_Activity2 extends AppCompatActivity {
    ActivityMenberPin2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityMenberPin2Binding.inflate( getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        initview();
    }

    private void initview() {

        List<MemberPinModel> memberPinModelArrayList = new ArrayList<>();
        memberPinModelArrayList.add(new MemberPinModel(R.drawable.goldenclub,"Golden Club Member","Apex","Golden Club Member"));
        memberPinModelArrayList.add(new MemberPinModel(R.drawable.green1,"Green Pin Member","Apex","Green Pin Member"));
        memberPinModelArrayList.add(new MemberPinModel(R.drawable.crorpatipin,"Crorepati Pin Member","Apex","Crorepati Pin Member"));
        memberPinModelArrayList.add(new MemberPinModel(R.drawable.millianrearpin,"Millian Club Member","Apex","Millian Club Member"));


        MemberPinAdapter memberPinAdapter =new MemberPinAdapter(memberPinModelArrayList, getApplicationContext());
        binding.MemberPinRecyclerView.setHasFixedSize(true);
        binding.MemberPinRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        binding.MemberPinRecyclerView.setAdapter(memberPinAdapter);

    }
}