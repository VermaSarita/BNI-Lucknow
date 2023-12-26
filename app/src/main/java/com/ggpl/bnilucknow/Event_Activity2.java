package com.ggpl.bnilucknow;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;
import com.ggpl.bnilucknow.databinding.ActivityEvent2Binding;
import java.util.ArrayList;
import java.util.List;


public class Event_Activity2 extends AppCompatActivity {
    private VideoView videoView;
    String videoUrl = "https://www.youtube.com/watch?v=x16NxoY1wo8";
    private RecyclerView recyclerView;
    ActivityEvent2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityEvent2Binding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        initview();
        onclickListener();

    }

    private void initview() {

        List<EventModel> eventModels = new ArrayList<>();
        eventModels.add(new EventModel("LTRT/DCRT MEET JULY 2020","Online"));
        eventModels.add(new EventModel("LTRT/DCRT MEET JULY 2020","Online"));
        eventModels.add(new EventModel("LTRT/DCRT MEET JULY 2020","Online"));

        EventAdapter eventAdapter =new EventAdapter(eventModels, getApplicationContext());
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        binding.recyclerView.setAdapter(eventAdapter);

        //***********videoview************//
        videoView = findViewById(R.id.idVideoView);
        Uri uri = Uri.parse(videoUrl);
        videoView.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        mediaController.setMediaPlayer(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();

    }


    private void onclickListener() {
        binding.backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Event_Activity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}