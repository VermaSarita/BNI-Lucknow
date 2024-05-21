package com.ggpl.bnilucknow.Adapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.ggpl.bnilucknow.AllChapterModel;
import com.ggpl.bnilucknow.R;
import com.squareup.picasso.Picasso;
import java.util.List;

public class chapterAdapter extends RecyclerView.Adapter<chapterAdapter.ViewHolder> {
    private List<AllChapterModel> allChapterModels;
    private int[] staticImageResIds; // Array of static image resource IDs
    private Context context;

    public chapterAdapter(List<AllChapterModel> allChapterModels, Context context) {
        this.allChapterModels = allChapterModels;
        this.context = context;
    }

    public void setStaticImageResIds(int[] staticImageResIds) {
        this.staticImageResIds = staticImageResIds;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chapter_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        if (position < 5 && staticImageResIds != null && position < staticImageResIds.length) {
            // If the position is within the range of static images and less than 5
            holder.bindStaticImage(staticImageResIds[position]);
        } else {
            // If the position is beyond the static images or 5 items, bind dynamic chapter data
            int dynamicPosition = position - Math.min(5, staticImageResIds != null ? staticImageResIds.length : 0);
            holder.bindChapterData(allChapterModels.get(dynamicPosition));
        }
    }

    @Override
    public int getItemCount() {
        // Return the total count of items, including both dynamic chapters and static images
        return Math.min(5, staticImageResIds != null ? staticImageResIds.length : 0) + allChapterModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView textview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            textview = itemView.findViewById(R.id.textview);
        }

        public void bindStaticImage(int staticImageResId) {
            // Bind static image
            image.setImageResource(staticImageResId);
            // Optionally, you can hide or modify other views specific to dynamic chapter data
            textview.setVisibility(View.VISIBLE);
        }

        public void bindChapterData(AllChapterModel chapterModel) {
            // Bind dynamic chapter data
            Picasso.get().load(chapterModel.getImgpath()).into(image);
            textview.setText(chapterModel.getChapter());
            // Optionally, you can modify views specific to static images
            textview.setVisibility(View.VISIBLE);
        }
    }
}
