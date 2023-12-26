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

public class RegionalTeamAdapter extends RecyclerView.Adapter<RegionalTeamAdapter.ViewHolder> {
    private List<RegionalTeamModel>regionalTeamModels;
    private Context context;

    public RegionalTeamAdapter(List<RegionalTeamModel> regionalTeamModels, Context context) {
        this.regionalTeamModels = regionalTeamModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.regional_team_layout, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.topText.setText(regionalTeamModels.get(position).getTitle());
        holder.bottomText.setText(regionalTeamModels.get(position).getText());
        holder.bottomText2.setText(regionalTeamModels.get(position).getText());
        holder.image.setImageResource(regionalTeamModels.get(position).getImgid());

    }

    @Override
    public int getItemCount() {
        return regionalTeamModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView topText,bottomText,bottomText2;
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            topText = itemView.findViewById(R.id.topText);
            bottomText = itemView.findViewById(R.id.bottomText);
            bottomText2 = itemView.findViewById(R.id.bottomText2);
            image = itemView.findViewById(R.id.image);

        }
    }
}
