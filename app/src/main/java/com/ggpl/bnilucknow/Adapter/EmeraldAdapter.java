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
import com.ggpl.bnilucknow.Model.MasterModel.EmeraldModel;
import com.ggpl.bnilucknow.ProfileActivity;
import com.ggpl.bnilucknow.R;
import com.squareup.picasso.Picasso;
import java.util.List;


public class EmeraldAdapter extends RecyclerView.Adapter<EmeraldAdapter.ViewHolder>{
    private List<EmeraldModel> emeraldModelList;
    private Context context;

    private int[] staticImages = {

            R.drawable.profile,//1
    };

    public EmeraldAdapter(List<EmeraldModel> emeraldModelList, Context context) {
        this.emeraldModelList = emeraldModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public EmeraldAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.regional_team_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmeraldAdapter.ViewHolder holder, int position) {
        holder.topText.setText(emeraldModelList.get(position).getfName());
        holder.bottomText.setText(emeraldModelList.get(position).getCategory());
        holder.bottomText2.setText(emeraldModelList.get(position).getcName());
        holder.initialname.setText(emeraldModelList.get(position).getInitial());
        holder.lastname.setText(emeraldModelList.get(position).getlName());

        int imageIndex = position % staticImages.length;

        Picasso.get()
                .load(staticImages[imageIndex])
                .into(holder.image);

        //load


        String imagePath = emeraldModelList.get(position).getmPhoto();
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

                // Retrieve the data of the clicked item
                String title = emeraldModelList.get(clickedPosition).getfName();
                String text = emeraldModelList.get(clickedPosition).getlName();
                String categoery = emeraldModelList.get(clickedPosition).getCategory();
                String myAsk = emeraldModelList.get(clickedPosition).getAsk();
                String myGive = emeraldModelList.get(clickedPosition).getGive();
                String mobNo = emeraldModelList.get(clickedPosition).getNumber();
                String companyname = emeraldModelList.get(clickedPosition).getcName();
                String business = emeraldModelList.get(clickedPosition).getBusiness();
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
        return emeraldModelList.size();
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
