package com.example.graduationproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class OffersRecyclerviewAdapter extends RecyclerView.Adapter<OffersRecyclerviewAdapter.oferviewholder>{
    ArrayList<Offers> offers;
    OnclickRecyclerView onclickRecyclerView;


    public class oferviewholder extends RecyclerView.ViewHolder {
        ImageView oIV=itemView.findViewById(R.id.ofer_iv);
        TextView oName=itemView.findViewById(R.id.ofername);
        public oferviewholder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onclickRecyclerView.OnItemclicked(getAdapterPosition());
                }
            });
        }
    }
    public OffersRecyclerviewAdapter(ArrayList<Offers> ofer, OnclickRecyclerView onclickRecyclerView)
    {
        this.offers=ofer;
        this.onclickRecyclerView=onclickRecyclerView;
    }

    @NonNull
    @Override
    public oferviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.offer,null,false);
        oferviewholder ovh=new oferviewholder(v);
        return ovh;

    }

    @Override
    public void onBindViewHolder(@NonNull oferviewholder holder, int position) {
        Offers offer= offers.get(position);
        holder.oName.setText(offer.getName());
        holder.oIV.setImageResource(offer.getImg());

    }

    @Override
    public int getItemCount() {
        return offers.size();
    }





}
