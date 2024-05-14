package com.ggpl.bnilucknow;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.ggpl.bnilucknow.Model.Chapter.categoeryModel;
import com.squareup.picasso.Picasso;
import java.util.List;


public class CategoeryAdapter extends RecyclerView.Adapter<CategoeryAdapter.ViewHolder> {
    private List<categoeryModel> categoeryModels;
    private Context context;

    public CategoeryAdapter(List<categoeryModel> categoeryModels, Context context) {
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

        if (position==0) {
            Picasso.get().load(categoeryModels.get(position).getId()).placeholder(R.drawable.event).error(R.drawable.event).into(holder.image);
        }else if(position==1){
            Picasso.get().load(categoeryModels.get(position).getId()).placeholder(R.drawable.branding).error(R.drawable.branding).into(holder.image);
        }else if(position==2){
            Picasso.get().load(categoeryModels.get(position).getId()).placeholder(R.drawable.training).error(R.drawable.training).into(holder.image);
        }else if(position==3){
            Picasso.get().load(categoeryModels.get(position).getId()).placeholder(R.drawable.jewelry).error(R.drawable.jewelry).into(holder.image);
        }else if(position==4){
            Picasso.get().load(categoeryModels.get(position).getId()).placeholder(R.drawable.travel).error(R.drawable.travel).into(holder.image);
        }else if(position==5){
            Picasso.get().load(categoeryModels.get(position).getId()).placeholder(R.drawable.food).error(R.drawable.food).into(holder.image);
        }else if(position==6){
            Picasso.get().load(categoeryModels.get(position).getId()).placeholder(R.drawable.more).error(R.drawable.more).into(holder.image);
        }else if(position==7){
            Picasso.get().load(categoeryModels.get(position).getId()).placeholder(R.drawable.accounting).error(R.drawable.accounting).into(holder.image);
        }else if(position==8){
            Picasso.get().load(categoeryModels.get(position).getId()).placeholder(R.drawable.store).error(R.drawable.store).into(holder.image);
        }else if(position==9){
            Picasso.get().load(categoeryModels.get(position).getId()).placeholder(R.drawable.realstate).error(R.drawable.realstate).into(holder.image);
        }else if(position==10){
            Picasso.get().load(categoeryModels.get(position).getId()).placeholder(R.drawable.retail).error(R.drawable.retail).into(holder.image);
        }else if(position==11){
            Picasso.get().load(categoeryModels.get(position).getId()).placeholder(R.drawable.realstate).error(R.drawable.realstate).into(holder.image);
        }

      //  holder.idTVCourse.setText(categoeryModels.get(position).getId());
        holder.text.setText(categoeryModels.get(position).getCategory());
    }

    @Override
    public int getItemCount() {
        return categoeryModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text,TEXT;
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            text = itemView.findViewById(R.id.text);

        }
    }
}
