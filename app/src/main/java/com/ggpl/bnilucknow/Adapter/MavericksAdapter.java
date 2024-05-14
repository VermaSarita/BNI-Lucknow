package com.ggpl.bnilucknow.Adapter;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.ggpl.bnilucknow.Model.MasterModel.MavericksModel;
import com.ggpl.bnilucknow.ProfileActivity;
import com.ggpl.bnilucknow.R;
import com.squareup.picasso.Picasso;

import java.util.List;


public class MavericksAdapter extends RecyclerView.Adapter<MavericksAdapter.ViewHolder> {
    private List<MavericksModel> mavericksModels;
    private Context context;

    private int[] staticImages = {

            R.drawable.profile,//1
    };


    public MavericksAdapter(List<MavericksModel> mavericksModels, Context context) {
        this.mavericksModels = mavericksModels;
        this.context = context;
    }

    @NonNull
    @Override
    public MavericksAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.regional_team_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MavericksAdapter.ViewHolder holder, int position) {
        holder.topText.setText(mavericksModels.get(position).getfName());
        holder.bottomText.setText(mavericksModels.get(position).getCategory());
        holder.bottomText2.setText(mavericksModels.get(position).getcName());
        holder.initialname.setText(mavericksModels.get(position).getInitial());
        holder.lastname.setText(mavericksModels.get(position).getlName());



        int imageIndex = position % staticImages.length;

        Picasso.get()
                .load(staticImages[imageIndex])
                .into(holder.image);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int clickedPosition = holder.getAdapterPosition();

                Context context = view.getContext();

                // Retrieve the data of the clicked item
                String title = mavericksModels.get(clickedPosition).getfName();
                String text = mavericksModels.get(clickedPosition).getlName();
                String categoery = mavericksModels.get(clickedPosition).getCategory();
                String myAsk = mavericksModels.get(clickedPosition).getAsk();
                String myGive = mavericksModels.get(clickedPosition).getGive();
                String mobNo = mavericksModels.get(clickedPosition).getNumber();
                String companyname = mavericksModels.get(clickedPosition).getcName();
                String business = mavericksModels.get(clickedPosition).getBusiness();
                int imageResourceId = staticImages[clickedPosition % staticImages.length];


                Intent intent = new Intent(context, ProfileActivity.class);

                intent.putExtra("title", title);
                intent.putExtra("text", text);
                intent.putExtra("categoery", categoery);
                intent.putExtra("myAsk", myAsk);
                intent.putExtra("myGive", myGive);
                intent.putExtra("mobNo", mobNo);
                intent.putExtra("companyname", companyname);
                intent.putExtra("business", business);
                intent.putExtra("imageResourceId", imageResourceId);
                // intent.putExtra("imageResourceId", imageResourceId);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mavericksModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView topText, bottomText, bottomText2 ,initialname, lastname;
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            topText = itemView.findViewById(R.id.topText);
            bottomText = itemView.findViewById(R.id.bottomText);
            bottomText2 = itemView.findViewById(R.id.bottomText2);
            initialname = itemView.findViewById(R.id.initialname);
            lastname = itemView.findViewById(R.id.lastname);
            image = itemView.findViewById(R.id.image);
        }
    }
}
