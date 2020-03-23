package com.example.graduationproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class OferDetail extends AppCompatActivity implements OnclickRecyclerView {
    String ET_description="تقدم هذه الشركة للسياحة مجموعة مختلفة من البرامج في جميع انحاء العالم, والعروض التالية هي مجرد امثلة لما يمكن ان تقدمة الشركة - وفى حال عدم توافق هذه البرامج مع " +
            "متطلباتكم او الرغبه في فنادق ذات فئات اعلى او اقل او حجز فنادق معينة - الرجاء الاتصال بالشركة وذلك لتمكيننا من اعداد البرنامج الخاص الذى ترغبونه وبأرخص الأسعار..";
    RecyclerView ex_in,restOfOffers;
    SpecialOfferAdapter specialOfferAdapter;
    com.example.graduationproject.countryRecyclerAdapter countryRecyclerAdapter;
    ArrayList<Offers> contry,special;
    TextView desc;
    ImageView coImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try{
        setContentView(R.layout.activity_ofer_detail);
         desc=findViewById(R.id.GeneralofferDescrept);
         desc.setText(ET_description);
         coImg =findViewById(R.id.img);
            Intent intent=getIntent();
            int imgg= intent.getIntExtra("i",1);
        coImg.setImageResource(imgg);
        contry=new ArrayList<>();
        special=new ArrayList<>();
        contry.add(new Offers("turky", R.drawable.ex,1));
        contry.add(new Offers("Imarat", R.drawable.ex,2));
        contry.add(new Offers("China", R.drawable.an,3));
        contry.add(new Offers("Japan", R.drawable.ex,4));
        contry.add(new Offers("United States", R.drawable.ex,5));
        contry.add(new Offers("malisia", R.drawable.ex,6));
        special.add(new Offers("elsaha hotel","sharya","turkya", R.drawable.ex,3,3));
        special.add(new Offers("myamy Beach","alex","egypt", R.drawable.ex,3,3));
        special.add(new Offers("hotel elmasa","cairo","Egypt", R.drawable.ex,5,4));
        special.add(new Offers("mousq","cowalaLambor","malisya", R.drawable.ex,6,5));
        special.add(new Offers("elsaha hotel","sharya","turkya", R.drawable.ex,3,3));
        special.add(new Offers("elsaha hotel","sharya","turkya", R.drawable.ex,3,3));
        special.add(new Offers("elsaha hotel","sharya","turkya", R.drawable.ex,3,3));


            int GenralOfferName= intent.getIntExtra("n",0);

        if (GenralOfferName==1 ||GenralOfferName==5)
        {
            ex_in=findViewById(R.id.recyclerfordetails);
            countryRecyclerAdapter=new countryRecyclerAdapter(contry,this);
            RecyclerView.LayoutManager layoutManager =new GridLayoutManager(this,3);
            ex_in.setAdapter(countryRecyclerAdapter);
            ex_in.setLayoutManager(layoutManager);
        }
        else
            {
               restOfOffers=findViewById(R.id.recyclerfordetails);
                specialOfferAdapter=new SpecialOfferAdapter(special,this);
                RecyclerView.LayoutManager llayoutManager =new LinearLayoutManager(this);
                restOfOffers.setAdapter(specialOfferAdapter);
                restOfOffers.setLayoutManager(llayoutManager);

            }

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }


    }

    @Override
    public void OnItemclicked(int position) {
        startActivity(new Intent(getApplicationContext(),oferinstruction.class));

    }

    @Override
    public void OnAnotherItemclicked(int position) {

    }
}
