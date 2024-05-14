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
import com.ggpl.bnilucknow.Model.MasterModel.ProsperityModel;
import com.ggpl.bnilucknow.ProfileActivity;
import com.ggpl.bnilucknow.R;
import com.squareup.picasso.Picasso;
import java.util.List;


public class ProsperityAdapter extends RecyclerView.Adapter<ProsperityAdapter.ViewHolder> {
    private List<ProsperityModel> prosperityModels;
    private Context context;

    private int[] staticImages = {

            R.drawable.profile,//1
    };

    public ProsperityAdapter(List<ProsperityModel> prosperityModels, Context context) {
        this.prosperityModels = prosperityModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ProsperityAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.regional_team_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProsperityAdapter.ViewHolder holder, int position) {
        holder.topText.setText(prosperityModels.get(position).getfName());
        holder.bottomText.setText(prosperityModels.get(position).getCategory());
        holder.bottomText2.setText(prosperityModels.get(position).getcName());
        holder.initialname.setText(prosperityModels.get(position).getInitial());
        holder.lastname.setText(prosperityModels.get(position).getlName());


        int imageIndex = position % staticImages.length;

        Picasso.get()
                .load(staticImages[imageIndex])
                .into(holder.image);



        // Load image using Picasso
        String imagePath = prosperityModels.get(position).getmPhoto();
        if (imagePath != null && !imagePath.isEmpty()) {
            Picasso.get().load(imagePath).into(holder.image);
        } else {
            // Set a default drawable photo (placeholder image)
            holder.image.setImageResource(R.drawable.profile);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int clickedPosition = holder.getAdapterPosition();

                Context context = view.getContext();

                // Retrieve the data of the clicked item
                String title = prosperityModels.get(clickedPosition).getfName();
                String text = prosperityModels.get(clickedPosition).getlName();
                String categoery = prosperityModels.get(clickedPosition).getCategory();
                String myAsk = prosperityModels.get(clickedPosition).getAsk();
                String myGive = prosperityModels.get(clickedPosition).getGive();
                String mobNo = prosperityModels.get(clickedPosition).getNumber();
                String companyname = prosperityModels.get(clickedPosition).getcName();
                String business = prosperityModels.get(clickedPosition).getBusiness();
                int imageResourceId = staticImages[clickedPosition % staticImages.length];


                //  int imageResourceId = emeraldModelList[clickedPosition % staticImages.length];


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
        return prosperityModels.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView topText, bottomText, bottomText2 , initialname, lastname;
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
