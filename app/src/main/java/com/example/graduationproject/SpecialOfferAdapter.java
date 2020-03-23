package com.example.graduationproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SpecialOfferAdapter extends RecyclerView.Adapter<SpecialOfferAdapter.oferviewholder> {
    ArrayList<Offers> offers;
    OnclickRecyclerView onclickRecyclerView;


    public class oferviewholder extends RecyclerView.ViewHolder {
        ImageView conIVinoffer=itemView.findViewById(R.id.contryimginoffer);
        TextView contrynameinoffer=itemView.findViewById(R.id.contrynameinoffer);
        TextView Spofername=itemView.findViewById(R.id.offernamesp);
        TextView balad=itemView.findViewById(R.id.bladname);
        TextView Offertime=itemView.findViewById(R.id.offertimesp);
        RatingBar ratingBar=itemView.findViewById(R.id.ratingBar);
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
    public SpecialOfferAdapter(ArrayList<Offers> ofer, OnclickRecyclerView onclickRecyclerView)
    {
        this.offers=ofer;
        this.onclickRecyclerView=onclickRecyclerView;
    }

    @NonNull
    @Override
    public oferviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.specialofferrow,null,false);
        oferviewholder ovh=new oferviewholder(v);
        return ovh;

    }

    @Override
    public void onBindViewHolder(@NonNull oferviewholder holder, int position) {
        Offers offer= offers.get(position);
        holder.Spofername.setText(offer.getName());
        holder.conIVinoffer.setImageResource(offer.getImg());
        holder.contrynameinoffer.setText(offer.getContryname());
        holder.balad.setText(offer.getBalad());
        holder.Offertime.setText(""+offer.getTime());
        holder.ratingBar.setRating(offer.getRating());


    }

    @Override
    public int getItemCount() {
        return offers.size();
    }




}
