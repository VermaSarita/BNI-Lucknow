package com.ggpl.bnilucknow;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ChapterAdapter extends RecyclerView.Adapter<ChapterAdapter.ViewHolder> {
    private List<ChapterModel> categoeryModels;
    private Context context;

    public ChapterAdapter(List<ChapterModel> categoeryModels, Context context) {
        this.categoeryModels = categoeryModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chapter_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.image.setImageResource(categoeryModels.get(position).getImgid());
        holder.textview.setText(categoeryModels.get(position).getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position == 0) {
                    Intent intent = new Intent(context, Chapter_Member_Activity2.class);
                    context.startActivity(intent);
                } else if (position == 1) {
                    Intent intent = new Intent(context, Chapter_Member_Activity2.class);
                    context.startActivity(intent);
                }else if (position == 2) {
                    Intent intent = new Intent(context, Chapter_Member_Activity2.class);
                    context.startActivity(intent);
                }else if (position==3){
                    Intent intent = new Intent(context, Chapter_Member_Activity2.class);
                    context.startActivity(intent);
                }else if (position==4){
                    Intent intent = new Intent(context, Chapter_Member_Activity2.class);
                    context.startActivity(intent);
                }else if (position==5){
                    Intent intent = new Intent(context, Chapter_Member_Activity2.class);
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoeryModels.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        TextView textview;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            textview = itemView.findViewById(R.id.textview);
        }
    }
}
