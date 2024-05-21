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
import com.ggpl.bnilucknow.Model.MasterModel.PrimePrime;
import com.ggpl.bnilucknow.ProfileActivity;
import com.ggpl.bnilucknow.R;
import com.squareup.picasso.Picasso;
import java.util.List;

public class PrimeAdapter extends RecyclerView.Adapter<PrimeAdapter.ViewHolder> {
    private List<PrimePrime> primePrimeList;
    private Context context;

    public PrimeAdapter(List<PrimePrime> primePrimeList, Context context) {
        this.primePrimeList = primePrimeList;
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
        PrimePrime primePrime = primePrimeList.get(position);
        holder.topText.setText(primePrime.getfName());
        holder.bottomText.setText(primePrime.getCategory());
        holder.bottomText2.setText(primePrime.getcName());
        holder.initialname.setText(primePrime.getInitial());
        holder.lastname.setText(primePrime.getlName());


        String imagePath = primePrime.getMphtopath();
        if (imagePath != null && !imagePath.isEmpty()) {
            Picasso.get().load(imagePath).into(holder.image);
        } else {
            holder.image.setImageResource(R.drawable.profile);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int clickedPosition = holder.getAdapterPosition();
                PrimePrime clickedItem = primePrimeList.get(clickedPosition);

                Intent intent = new Intent(context, ProfileActivity.class);
                intent.putExtra("title", clickedItem.getfName());
                intent.putExtra("text", clickedItem.getlName());
                intent.putExtra("categoery", clickedItem.getCategory());
                intent.putExtra("myAsk", clickedItem.getAsk());
                intent.putExtra("myGive", clickedItem.getGive());
                intent.putExtra("mobNo", clickedItem.getNumber());
                intent.putExtra("companyname", clickedItem.getcName());
                intent.putExtra("business", clickedItem.getBusiness());
                intent.putExtra("imageUrl", clickedItem.getMphtopath()); // Pass image URL to profile activity
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return primePrimeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView topText, bottomText, bottomText2, initialname, lastname;
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
