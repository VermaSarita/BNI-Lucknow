package com.ggpl.bnilucknow;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MemberPinAdapter extends RecyclerView.Adapter<MemberPinAdapter.ViewHolder> {
    private List<MemberPinModel>memberPinModels;
    private Context context;

    public MemberPinAdapter(List<MemberPinModel> memberPinModels, Context context) {
        this.memberPinModels = memberPinModels;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.member_pin, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.image.setImageResource(memberPinModels.get(position).getImgid());
        holder.text1.setText(memberPinModels.get(position).getText1());
        holder.text2.setText(memberPinModels.get(position).getText2());
        holder.text3.setText(memberPinModels.get(position).getText3());
    }
    @Override
    public int getItemCount() {
        return memberPinModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text1,text2,text3;
        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            text1 = itemView.findViewById(R.id.text1);
            text2 = itemView.findViewById(R.id.text2);
            text3 = itemView.findViewById(R.id.text3);
        }
    }
}
