package com.zoomcar.prateek.faltu.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zoomcar.prateek.faltu.R;

/**
 * Created by Prateek on 14/01/16.
 */
public class ZoomNowListAdapter extends RecyclerView.Adapter<ZoomNowListAdapter.ZoomNowViewHolder> {

    @Override
    public ZoomNowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ZoomNowViewHolder(inflater.inflate(R.layout.cell_zoom_now,parent,false));
    }

    @Override
    public void onBindViewHolder(ZoomNowViewHolder holder, int position) {
        holder.name.setText("Item number : "+position);
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    public class ZoomNowViewHolder extends RecyclerView.ViewHolder {

        protected TextView name;

        public ZoomNowViewHolder(View itemView) {
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.text_name);
        }
    }
}
