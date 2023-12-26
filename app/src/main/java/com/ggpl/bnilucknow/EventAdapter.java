package com.ggpl.bnilucknow;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;


public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {
    private List<EventModel>eventModels;
    private Context context;

    public EventAdapter(List<EventModel> eventModels, Context context) {
        this.eventModels = eventModels;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.eventText1.setText(eventModels.get(position).getTitle());
        holder.eventText2.setText(eventModels.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return eventModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView eventText1,eventText2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            eventText1 = itemView.findViewById(R.id.eventText1);
            eventText2 = itemView.findViewById(R.id.eventText2);
        }
    }
}
