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

public class CategoeryAdapter extends RecyclerView.Adapter<CategoeryAdapter.ViewHolder> {
    private List<CategoeryModel> categoeryModels;
    private Context context;

    public CategoeryAdapter(List<CategoeryModel> categoeryModels, Context context) {
        this.categoeryModels = categoeryModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.idIVcourse.setImageResource(categoeryModels.get(position).getImgid());
        holder.idTVCourse.setText(categoeryModels.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return categoeryModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView idTVCourse,TEXT;
        ImageView idIVcourse;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            idIVcourse = itemView.findViewById(R.id.idIVcourse);
            idTVCourse = itemView.findViewById(R.id.idTVCourse);

        }
    }
}
