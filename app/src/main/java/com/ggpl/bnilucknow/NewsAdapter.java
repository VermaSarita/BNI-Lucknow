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

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private List<NewsModel>newsModels;
    private Context context;

    public NewsAdapter(List<NewsModel> newsModels, Context context) {
        this.newsModels = newsModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_layout_1, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.topText.setText(newsModels.get(position).getTitle());
        holder.bottomText.setText(newsModels.get(position).getText());
        holder.UserName.setText(newsModels.get(position).getUserName());
        holder.image.setImageResource(newsModels.get(position).getImgid());

    }

    @Override
    public int getItemCount() {
        return newsModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView topText,bottomText,UserName;
        ImageView image,UserImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            topText = itemView.findViewById(R.id.topText);
            bottomText = itemView.findViewById(R.id.bottomText);
            UserName = itemView.findViewById(R.id.UserName);
            image = itemView.findViewById(R.id.image);
            UserImage = itemView.findViewById(R.id.UserImage);
        }
    }
}
