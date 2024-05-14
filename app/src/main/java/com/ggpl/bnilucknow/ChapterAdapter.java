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
import com.squareup.picasso.Picasso;
import java.util.List;



public class ChapterAdapter extends RecyclerView.Adapter<ChapterAdapter.ViewHolder> {
    private List<AllChapterModel> allChapterModels;
    private Context context;

    public ChapterAdapter(List<AllChapterModel> allChapterModels, Context context) {
        this.allChapterModels = allChapterModels;
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
       // holder.image.setImageResource(allChapterModels.get(position).getImg());
       // Picasso.get().load(allChapterModels.get(position).getImg()).into(holder.image);

        if (position==0) {
            Picasso.get()
                    .load(allChapterModels.get(position).getImg()).placeholder(R.drawable.masterchapter).error(R.drawable.masterchapter).into(holder.image);
        }else if (position==1){
                Picasso.get()
                        .load(allChapterModels.get(position).getImg()).placeholder(R.drawable.primechapter).error(R.drawable.primechapter).into(holder.image);
        }else if (position==2){
            Picasso.get()
                    .load(allChapterModels.get(position).getImg()).placeholder(R.drawable.apexchapter).error(R.drawable.apexchapter).into(holder.image);
        }else if (position==3){
            Picasso.get()
                    .load(allChapterModels.get(position).getImg()).placeholder(R.drawable.emberaldchapter).error(R.drawable.emberaldchapter).into(holder.image);
        }else if (position==4){
            Picasso.get()
                    .load(allChapterModels.get(position).getImg()).placeholder(R.drawable.prosperitychapter).error(R.drawable.prosperitychapter).into(holder.image);
        }else if (position==5){
            Picasso.get()
                    .load(allChapterModels.get(position).getImg()).placeholder(R.drawable.mavericckschapter).error(R.drawable.mavericckschapter).into(holder.image);
        }else if (position==6){
            Picasso.get()
                    .load(allChapterModels.get(position).getImg()).placeholder(R.drawable.maestros).error(R.drawable.maestros).into(holder.image);
        }

        holder.textview.setText(allChapterModels.get(position).getChapter());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position == 0) {
                    Intent intent = new Intent(context, Chapter_Member_Activity2.class);
                    context.startActivity(intent);
                } else if (position == 1) {
                    Intent intent = new Intent(context, PrimeChapterActivity.class);
                    context.startActivity(intent);
                }else if (position == 2) {
                    Intent intent = new Intent(context, ApexChapertActivity.class);
                    context.startActivity(intent);
                }else if (position==3){
                   Intent intent = new Intent(context, EmeraldActivity.class);
                   context.startActivity(intent);
                }else if (position==4){
                    Intent intent = new Intent(context, ProsperityChapterActivity.class);
                    context.startActivity(intent);
                }else if (position==5){
                    Intent intent = new Intent(context, MavericksActivity.class);
                    context.startActivity(intent);
                }
                else if (position==6){
                    Intent intent = new Intent(context, MaestrosActivity.class);
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return allChapterModels.size();

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
