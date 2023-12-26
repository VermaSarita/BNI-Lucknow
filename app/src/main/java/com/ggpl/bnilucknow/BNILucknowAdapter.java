package com.ggpl.bnilucknow;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class BNILucknowAdapter extends RecyclerView.Adapter<BNILucknowAdapter.ViewHolder>{
    private List<BNILucknowModel>bniLucknowModels;
    private Context context;

    public BNILucknowAdapter(List<BNILucknowModel> bniLucknowModels, Context context) {
        this.bniLucknowModels = bniLucknowModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bni_lucknoe_layout, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.titleImage.setImageResource(bniLucknowModels.get(position).getImgid());
        holder.headingtext.setText(bniLucknowModels.get(position).getTitle());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int clickedPosition = holder.getAdapterPosition();

                // Ensure that you're using the correct context from the view
                Context context = view.getContext();


                if (clickedPosition == 0) {
                    Intent intent = new Intent(context, BNI_Chapters_Activity2.class);
                    context.startActivity(intent);
                } else if (clickedPosition == 1) {
                    Intent intent = new Intent(context, CategoeryActivity2.class);
                    context.startActivity(intent);
                }else if (clickedPosition == 2) {
                    Intent intent = new Intent(context, CategoeryActivity2.class);
                    context.startActivity(intent);
                }else if (clickedPosition==5){
                    Intent intent = new Intent(context, BNILucknowGallery_Activity2.class);
                    context.startActivity(intent);
                }else if (clickedPosition==3){
                    Intent intent = new Intent(context, Event_Activity2.class);
                    context.startActivity(intent);
                }else if (clickedPosition==6){
                    Intent intent = new Intent(context, Menber_Pin_Activity2.class);
                    context.startActivity(intent);
                }else if (clickedPosition==4){
                    Intent intent = new Intent(context, New_BNI_sActivity2.class);
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return bniLucknowModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView headingtext;
        ImageView titleImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            headingtext = itemView.findViewById(R.id.headingtext);
            titleImage = itemView.findViewById(R.id.titleImage);

        }
    }
}
