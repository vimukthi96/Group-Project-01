package com.atheeshproperty.itaidapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class SubCategoryActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        //String catValue="Programming";
        Intent i=getIntent();
        String categoryValue=i.getStringExtra("categoryValue");

        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        List<String> quotes = databaseAccess.getSubCategory(categoryValue);
        databaseAccess.close();
        String[] quo=new String[quotes.size()];
        quo=quotes.toArray(quo);
        int [] img=new int[quo.length];
        for(int y=0;y<quo.length;y++){
         img[y]=(getResources().getIdentifier(quo[y].toString(),"drawable",getPackageName()));
    }



        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,quotes,img);
        myrv.setLayoutManager(new GridLayoutManager(this,2));
        myrv.setAdapter(myAdapter);



    }
}
