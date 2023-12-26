package com.ggpl.bnilucknow;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LucknowGalleryAdapter extends RecyclerView.Adapter<LucknowGalleryAdapter.ViewHolder> {
    private List<LucknowGalleryModel> lucknowGalleryModels;
    private Context context;

    public LucknowGalleryAdapter(List<LucknowGalleryModel> lucknowGalleryModels, Context context) {
        this.lucknowGalleryModels = lucknowGalleryModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_layout, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.idIVImage.setImageResource(lucknowGalleryModels.get(position).getImgid());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int imageId = lucknowGalleryModels.get(position).getImgid();

                Intent intent = new Intent(view.getContext(), Gallery_Detail_Activity2.class);
                intent.putExtra("imageId", imageId);
                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return lucknowGalleryModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView idIVImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            idIVImage = itemView.findViewById(R.id.idIVImage);
        }
    }
}
