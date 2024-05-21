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
        ProsperityModel member = prosperityModels.get(position);

        holder.topText.setText(prosperityModels.get(position).getfName());
        holder.bottomText.setText(prosperityModels.get(position).getCategory());
        holder.bottomText2.setText(prosperityModels.get(position).getcName());
        holder.initialname.setText(prosperityModels.get(position).getInitial());
        holder.lastname.setText(prosperityModels.get(position).getlName());


        String imageUrl = member.getMphtopath();

        Picasso.get()
                .load(imageUrl)
                .placeholder(R.drawable.bnilogo)
                .error(R.drawable.ic_baseline_newspaper_24)
                .into(holder.image);





        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int clickedPosition = holder.getAdapterPosition();

                Context context = view.getContext();

                // Retrieve the data of the clicked item
                String title = member.getfName();
                String text = member.getlName();
                String category = member.getCategory();
                String myAsk = member.getAsk();
                String myGive = member.getGive();
                String mobNo = member.getNumber();
                String companyname = member.getcName();
                String business = member.getBusiness();
                String imageResourceUrl = member.getMphtopath();

                Intent intent = new Intent(context, ProfileActivity.class);

                intent.putExtra("title", title);
                intent.putExtra("text", text);
                intent.putExtra("category", category);
                intent.putExtra("myAsk", myAsk);
                intent.putExtra("myGive", myGive);
                intent.putExtra("mobNo", mobNo);
                intent.putExtra("companyname", companyname);
                intent.putExtra("business", business);
                intent.putExtra("imageResourceUrl", imageResourceUrl);

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
