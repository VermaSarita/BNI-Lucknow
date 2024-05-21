package com.ggpl.bnilucknow;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.ggpl.bnilucknow.Model.MasterModel.masterMember;
import com.squareup.picasso.Picasso;
import java.util.List;


public class RegionalTeamAdapter extends RecyclerView.Adapter<RegionalTeamAdapter.ViewHolder> {
    private List<masterMember> masterMemberList;
    private Context context;

    public RegionalTeamAdapter(List<masterMember> masterMemberList, Context context) {
        this.masterMemberList = masterMemberList;
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
        masterMember member = masterMemberList.get(position);

        holder.topText.setText(member.getfName());
        holder.bottomText.setText(member.getCategory());
        holder.bottomText2.setText(member.getcName());
        holder.initialname.setText(member.getInitial());
        holder.lastname.setText(member.getlName());

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
        return masterMemberList.size();
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
