package com.sebisoftworks.sensorlistlive;


import android.hardware.Sensor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    ArrayList<String[]> mData;


    public MyAdapter(ArrayList<String[]> aData) {
        mData = aData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View neueView = inflater.inflate(R.layout.friendview, parent, false);
        MyViewHolder viewholder = new MyViewHolder(neueView);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String[] friend = mData.get(position);

        holder.powerTV.setText("Power: " + friend[1]);
        holder.nameTV.setText("Name: " + friend[0]);
        holder.manufactererTV.setText("Vendor: " + friend[2]);
        holder.rangeTV.setText("Range: " + friend[3]);
        holder.liveTV.setText("Live " + friend[4]);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
