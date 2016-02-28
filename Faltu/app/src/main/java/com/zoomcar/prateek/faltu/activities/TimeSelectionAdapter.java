package com.zoomcar.prateek.faltu.activities;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zoomcar.prateek.faltu.R;

/**
 * Created by Prateek on 08/01/16.
 */
public class TimeSelectionAdapter extends RecyclerView.Adapter<TimeSelectionAdapter.ViewHolder> {

    private String[] timeSlots = {"3:00 AM", "3:30 AM", "4:00 AM", "4:30 AM", "5:00 AM", "5:30 AM", "6:00 AM", "6:30 AM", "7:00 AM", "7:30 AM", "8:00 AM"};

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View timeCell =  LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_cell_time,parent,false);
        ViewHolder viewHolder = new ViewHolder(timeCell);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.time.setText(timeSlots[position]);
    }

    @Override
    public int getItemCount() {
        return timeSlots.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView time;

        public ViewHolder(View itemView) {
            super(itemView);
            time = (TextView) itemView.findViewById(R.id.time);
        }
    }
}
