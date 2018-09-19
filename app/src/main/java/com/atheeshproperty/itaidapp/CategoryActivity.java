package com.atheeshproperty.itaidapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CategoryActivity extends AppCompatActivity implements View.OnClickListener {

    boolean doubleBackPressed;

    @Override
    public void onBackPressed() {

        if(doubleBackPressed){
            super.onBackPressed();
        }
        else{
            doubleBackPressed=true;
            final ConstraintLayout coordinatorLayout = (ConstraintLayout) findViewById(R.id.coordinator);

            Toast.makeText(this,"Press back again to exit!",Toast.LENGTH_SHORT).show();
            new android.os.Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleBackPressed=false;
                }
            },2000);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        Button btnProgramming = findViewById(R.id.btnProgramming);
        Button btnStatistic = findViewById(R.id.btnStatistics);
        Button btnWebDevelopment = findViewById(R.id.btnWebDevelopment);
        Button btnDatabaseDesign = findViewById(R.id.btnDataBase);
        Button btnDataStructure = findViewById(R.id.btnDataStructures);
        Button btnMaths = findViewById(R.id.btnMathematics);

        btnProgramming.setOnClickListener(this);
        btnDatabaseDesign.setOnClickListener(this);
        btnDataStructure.setOnClickListener(this);
        btnMaths.setOnClickListener(this);
        btnStatistic.setOnClickListener(this);
        btnWebDevelopment.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent =new Intent(this,SubCategoryActivity.class);

        switch(v.getId()){
            case R.id.btnDataBase:
                intent.putExtra("categoryValue","Database Development");
                break;

            case R.id.btnDataStructures:
                intent.putExtra("categoryValue","Data structures and Algorithms");
                break;
            case R.id.btnMathematics:
                intent.putExtra("categoryValue","Discrete mathematics");
                break;

            case R.id.btnProgramming:
                intent.putExtra("categoryValue","Programming");
                break;
            case R.id.btnWebDevelopment:
                intent.putExtra("categoryValue","Web Development");
                break;

            case R.id.btnStatistics:
                intent.putExtra("categoryValue","Statistics");
                break;

        }
        startActivity(intent);

    }
}
