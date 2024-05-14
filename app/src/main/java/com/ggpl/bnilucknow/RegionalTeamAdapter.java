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

    private int[] staticImages = {

            R.drawable.profile,//1
            R.drawable.profile,//2
            R.drawable.amit_sarigwala,//3
            R.drawable.amit_jain,//4
            R.drawable.anshul_agrwal,//5
            R.drawable.annu_ashthana,//6
            R.drawable.anuj_gupta,//7
            R.drawable.anupam,//8
            R.drawable.profile,//9
            R.drawable.arvindra_mishra,//10
            R.drawable.babita,//11
            R.drawable.bhaskar_gupta,//12
            R.drawable.dharmendra,//13
            R.drawable.profile,//14
            R.drawable.garima,//15
            R.drawable.profile,//16
            R.drawable.profile,//17
            R.drawable.harsh,//18
            R.drawable.profile,//19
            R.drawable.karan_piplanu,//20    done
            R.drawable.sahanwaj,//21
            R.drawable.faran,//22
            R.drawable.mrigang,//23
            R.drawable.nandini,//24
            R.drawable.nitin_agrawal,//25
            R.drawable.prateek_agrawal,//26
            R.drawable.prem,//27
            R.drawable.puneesh_agrawal,//28
            R.drawable.rachana,//29
            R.drawable.rahul_agrawal,//30
            R.drawable.ramneek,//31
            R.drawable.ravi_prakash,//32
            R.drawable.sachin_kapoor,//33
            R.drawable.sachin_saxena,//34
            R.drawable.satveersingh,//35
            R.drawable.saurabh_sri,//36
            R.drawable.shadman_sheikh,//37
            R.drawable.shashank_jain,//38
            R.drawable.profile,//39
            R.drawable.shishir_khare,//40
            R.drawable.sonu_bajpeyi,//41
            R.drawable.tanay,//42
            R.drawable.tarang,//43
            R.drawable.vijay_singh,//44
            R.drawable.vinayak_nayh,//45
            R.drawable.vishanu,//1
            R.drawable.vivek_shri,//1

    };
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

        holder.topText.setText(masterMemberList.get(position).getfName());
        holder.bottomText.setText(masterMemberList.get(position).getCategory());
        holder.bottomText2.setText(masterMemberList.get(position).getcName());
        holder.initialname.setText(masterMemberList.get(position).getInitial());
        holder.lastname.setText(masterMemberList.get(position).getlName());



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
                String title = masterMemberList.get(clickedPosition).getfName();
                String text = masterMemberList.get(clickedPosition).getlName();
                String categoery = masterMemberList.get(clickedPosition).getCategory();
                String myAsk = masterMemberList.get(clickedPosition).getAsk();
                String myGive = masterMemberList.get(clickedPosition).getGive();
                String mobNo = masterMemberList.get(clickedPosition).getNumber();
                String companyname = masterMemberList.get(clickedPosition).getcName();
                String business = masterMemberList.get(clickedPosition).getBusiness();
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
