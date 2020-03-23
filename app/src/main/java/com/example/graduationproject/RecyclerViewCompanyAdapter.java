package com.example.graduationproject;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewCompanyAdapter extends RecyclerView.Adapter<RecyclerViewCompanyAdapter.My_comp_VH> {
    OnclickRecyclerView onclick;
    ArrayList<Companies> comp;
    public RecyclerViewCompanyAdapter(ArrayList<Companies> companies, OnclickRecyclerView onclickk)
    {
        this.onclick=onclickk;
     this.comp=companies;
    }

    @NonNull
    @Override
    public My_comp_VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.company_recyclerview_row,null,false);
         My_comp_VH vh=new My_comp_VH(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull My_comp_VH holder, int position) {
        Companies companies= comp.get(position);
        holder.cName.setText(companies.getName());
        holder.cIV.setImageResource(companies.getImg());

    }

    @Override
    public int getItemCount() {
        return comp.size();
    }

    public class My_comp_VH extends RecyclerView.ViewHolder {

        ImageView cIV=itemView.findViewById(R.id.company_im_view);
        TextView cName=itemView.findViewById(R.id.copmany_name);
        public My_comp_VH(@NonNull final View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onclick.OnItemclicked(getAdapterPosition());

                }
            });


        }
    }
}
