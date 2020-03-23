package com.example.graduationproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    ArrayList<Offers> offers;
    Context context;
    public ListViewAdapter(ArrayList<Offers> off, Context cont){this.offers=off;this.context=cont;}

    @Override
    public int getCount() {
        return offers.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v =convertView;
        if (v==null) v = LayoutInflater.from(context).inflate(R.layout.offer, null, false);
        TextView name = v.findViewById(R.id.ofername);
        ImageView iv=v.findViewById(R.id.ofer_iv);
        name.setText(offers.get(position).getName());
        iv.setImageResource(offers.get(position).getImg());
        return v;
    }
}
