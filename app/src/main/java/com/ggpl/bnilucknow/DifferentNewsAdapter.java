package com.ggpl.bnilucknow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DifferentNewsAdapter extends RecyclerView.Adapter<DifferentNewsAdapter.ViewHolder> {
    private List<DifferentNewsModel> differentNewsModels;
    private Context context;

    public DifferentNewsAdapter(List<DifferentNewsModel> differentNewsModels, Context context) {
        this.differentNewsModels = differentNewsModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext( )).inflate(R.layout.news_layout_2, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.Title.setText(differentNewsModels.get(position).getTitle( ));
        holder.contentNews.setText(differentNewsModels.get(position).getText( ));
        holder.NewsImage.setImageResource(differentNewsModels.get(position).getImgid( ));


    }

    @Override
    public int getItemCount() {

        return differentNewsModels.size( );

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Title, contentNews, UserName;
        ImageView NewsImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Title = itemView.findViewById(R.id.Title);
            contentNews = itemView.findViewById(R.id.contentNews);
            NewsImage = itemView.findViewById(R.id.NewsImage);

        }
    }
}
