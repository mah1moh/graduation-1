package com.example.graduationproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class ConpanyDetail extends AppCompatActivity implements OnclickRecyclerView{


    ArrayList<Offers> oferd=new ArrayList<>();
    ArrayList<Offers> excluseve=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conpany_detail);
        try{
            Intent i=getIntent();
            String companyName=i.getStringExtra("name");
            int Img=i.getIntExtra("img",-1);
            ImageView imageView=findViewById(R.id.c_logo_detail);
            imageView.setImageResource(Img);
            TextView cname=findViewById(R.id.c_name_detail);
            cname.setText(companyName);

        RecyclerView oferrecycler,exclusev;
        OffersRecyclerviewAdapter normal;
        oferd.add(new Offers("ExternalTourism", R.drawable.ex,1));
        oferd.add(new Offers("Honey moon", R.drawable.honeymoon,2));
        oferd.add(new Offers("Nail Croze", R.drawable.croz,3));
        oferd.add(new Offers("One Day Offers", R.drawable.onnday,4));
        oferd.add(new Offers("InternalTourism", R.drawable.iinn,5));
        oferd.add(new Offers("Torism Tours", R.drawable.tours,6));
       normal=new OffersRecyclerviewAdapter(oferd,this);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        oferrecycler=findViewById(R.id.ofersrecycler);
        oferrecycler.setAdapter(normal);
        oferrecycler.setLayoutManager(layoutManager);
            excluseve.add(new Offers("Torism Tours", R.drawable.tours,7));
            excluseve.add(new Offers("شم النسيم", R.drawable.nasim,8));
            excluseve.add(new Offers("VIP OFFERS", R.drawable.vip,9));
            exclusev=findViewById(R.id.list);
            exOfferadapter exOfferadapter=new exOfferadapter(excluseve,this);
            RecyclerView.LayoutManager exxxx= new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
            exclusev.setLayoutManager(exxxx);
            exclusev.setAdapter(exOfferadapter);

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void OnItemclicked(int position) {
        int id=oferd.get(position).getId();
        int img=oferd.get(position).getImg();
        Intent intent=new Intent(getBaseContext(),OferDetail.class);
        intent.putExtra("n",id);
        intent.putExtra("i",img);
        startActivity(intent);

    }


    @Override
    public void OnAnotherItemclicked(int position) {
        String name=excluseve.get(position).getName();
        int img=excluseve.get(position).getImg();
        Intent intent=new Intent(getBaseContext(),OferDetail.class);
        intent.putExtra("n",name);
        intent.putExtra("i",img);
        startActivity(intent);

    }

}
