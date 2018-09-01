package com.atheeshproperty.itaidapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.atheeshproperty.splashscreentest.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnNavToProgrammingScreen =  findViewById(R.id.btnProgramming);
        Button btnNavToWeb = findViewById(R.id.btnWebDevelopment);


        btnNavToProgrammingScreen.setOnClickListener(this);
        btnNavToWeb.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnProgramming:
                Intent intent = new Intent(MainActivity.this, programmingBtnActivity.class);
                startActivity(intent);
                break;

            case R.id.btnWebDevelopment:
                Intent secondintent = new Intent(MainActivity.this, webDevelopmentBtnActivity.class);
                startActivity(secondintent);
                break;

        }
    }
}
