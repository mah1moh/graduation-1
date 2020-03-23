package com.example.graduationproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewCompany extends AppCompatActivity implements OnclickRecyclerView {


    ArrayList<Companies> companies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_company);
        try{
        RecyclerView rvCompany=findViewById(R.id.companyRecycler);
        companies=new ArrayList<>();
        RecyclerViewCompanyAdapter Adapter=new RecyclerViewCompanyAdapter(companies,this);
        companies.add(new Companies("Egypt", R.drawable.an));
        companies.add(new Companies("Mectra", R.drawable.mectra));
        companies.add(new Companies("Travida", R.drawable.travida));
            companies.add(new Companies("Aan", R.drawable.an));
        RecyclerView.LayoutManager lm= new GridLayoutManager(this,2);
        rvCompany.setAdapter(Adapter);
        rvCompany.setLayoutManager(lm);
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void OnItemclicked(int position) {
        Intent intent=new Intent(getBaseContext(), ConpanyDetail.class);
        String name = companies.get(position).getName();
        int img= companies.get(position).getImg();
        intent.putExtra("name",name);
        intent.putExtra("img",img);
        startActivity(intent);

    }

    @Override
    public void OnAnotherItemclicked(int position) {

    }
}
