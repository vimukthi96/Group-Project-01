package com.atheeshproperty.itaidapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        if(!isNetworkAvailable()){
            AlertDialog.Builder builder =new AlertDialog.Builder(SplashActivity.this);
            builder.setTitle("ERROR");
            builder.setMessage("No Internet or WIFI conection..");

            builder.setPositiveButton("RETRY", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
                }
            });
            builder.setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i2) {
                    finish();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
        else{
            if(isNetworkAvailable()){
                Thread thread = new Thread(){
                    public void run(){
                        try{
                            sleep(4000);
                        }
                        catch(Exception ex){
                            ex.printStackTrace();
                        }
                        finally {
                            startActivity(new Intent(SplashActivity.this,CategoryActivity.class));
                            finish();
                        }
                    }
                };
                thread.start();
            }
        }
    }
    private boolean isNetworkAvailable(){
        ConnectivityManager connectivityManager =(ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo =connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }

}


