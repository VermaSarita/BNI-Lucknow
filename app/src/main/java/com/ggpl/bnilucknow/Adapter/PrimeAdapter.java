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


public class PrimeAdapter extends RecyclerView.Adapter<PrimeAdapter.ViewHolder>{
    private List<PrimePrime> primePrimeList;
    private Context context;

    private int[] staticImages = {

            R.drawable.profile,//1
    };

    public PrimeAdapter(List<PrimePrime> primePrimeList, Context context) {
        this.primePrimeList = primePrimeList;
        this.context = context;
    }

    @NonNull
    @Override
    public PrimeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.regional_team_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PrimeAdapter.ViewHolder holder, int position) {
        holder.topText.setText(primePrimeList.get(position).getfName());
        holder.bottomText.setText(primePrimeList.get(position).getCategory());
        holder.bottomText2.setText(primePrimeList.get(position).getcName());
        holder.initialname.setText(primePrimeList.get(position).getInitial());
        holder.lastname.setText(primePrimeList.get(position).getlName());


        int imageIndex = position % staticImages.length;

        Picasso.get()
                .load(staticImages[imageIndex])
                .into(holder.image);

     ////load

        String imagePath = primePrimeList.get(position).getmPhoto();
        if (imagePath != null && !imagePath.isEmpty()) {
            Picasso.get().load(imagePath).into(holder.image);
        } else {
            holder.image.setImageResource(R.drawable.profile);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int clickedPosition = holder.getAdapterPosition();

                Context context = view.getContext();

                String title = primePrimeList.get(clickedPosition).getfName();
                String text = primePrimeList.get(clickedPosition).getlName();
                String categoery = primePrimeList.get(clickedPosition).getCategory();
                String myAsk = primePrimeList.get(clickedPosition).getAsk();
                String myGive = primePrimeList.get(clickedPosition).getGive();
                String mobNo = primePrimeList.get(clickedPosition).getNumber();
                String companyname = primePrimeList.get(clickedPosition).getcName();
                String business = primePrimeList.get(clickedPosition).getBusiness();
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
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return primePrimeList.size();
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
