package com.ggpl.bnilucknow;
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
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AllChapterModel chapterModel = allChapterModels.get(position);

        String imgUrl = chapterModel.getImgpath();

        Picasso.get().load(imgUrl)
                .placeholder(R.drawable.bnilogo) // Placeholder image while loading
                .error(R.drawable.bnilogo) // Image on error
                .into(holder.image); // Target ImageView


        holder.textview.setText(chapterModel.getChapter());

        holder.itemView.setOnClickListener(view -> {
            Intent intent;
            switch (position) {
                case 0:
                    intent = new Intent(context, Chapter_Member_Activity2.class);
                    break;
                case 1:
                    intent = new Intent(context, PrimeChapterActivity.class);
                    break;
                case 2:
                    intent = new Intent(context, ApexChapertActivity.class);
                    break;
                case 3:
                    intent = new Intent(context, EmeraldActivity.class);
                    break;
                case 4:
                    intent = new Intent(context, ProsperityChapterActivity.class);
                    break;
                case 5:
                    intent = new Intent(context, MavericksActivity.class);
                    break;
                case 6:
                    intent = new Intent(context, MaestrosActivity.class);
                    break;
                default:
                    return;
            }
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return allChapterModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView textview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            textview = itemView.findViewById(R.id.textview);
        }
    }
}
