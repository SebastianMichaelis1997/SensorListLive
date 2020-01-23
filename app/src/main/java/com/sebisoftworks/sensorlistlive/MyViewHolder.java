package com.sebisoftworks.sensorlistlive;


import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView nameTV;
    TextView rangeTV;
    TextView manufactererTV;
    TextView powerTV;
    TextView liveTV;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTV = itemView.findViewById(R.id.tv_name);
        rangeTV = itemView.findViewById(R.id.tv_range);
        manufactererTV = itemView.findViewById(R.id.tv_manufacterer);
        powerTV = itemView.findViewById(R.id.tv_power);
        liveTV = itemView.findViewById(R.id.tv_live);
    }

}
