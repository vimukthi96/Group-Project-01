package com.atheeshproperty.itaidapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class subtitleActivity extends AppCompatActivity {
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subtitle);
        Intent i=getIntent();
        final String subcategoryValue=i.getStringExtra("subcategoryValue");
        this.listView = (ListView) findViewById(R.id.listView);
       // String sub ="c_1basic";
        ImageView imageView=(ImageView)findViewById(R.id.imageView);
        int drawableId = getResources().getIdentifier(subcategoryValue,"drawable",getPackageName());
        imageView.setImageResource(drawableId);


        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        final List<String > quo = databaseAccess.getSubTitle(subcategoryValue);
        databaseAccess.close();


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1 , quo){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView textView = (TextView) view.findViewById(android.R.id.text1);
                textView.setTextColor(Color.BLUE);
                textView.setTypeface(textView.getTypeface(), Typeface.BOLD);
                textView.setGravity(Gravity.CENTER);
                textView.setPadding(0,10,0,10);
               // textView.setMinLines(3);
              //  textView.setAllCaps(true);
                //textView.setTextSize(20);
                textView.setShadowLayer(1.5f,-2,2, Color.GREEN);
            return view;
            }

        };
        //ArrayAdapter adapter=
        this.listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                TextView textView = (TextView) view;
                String message =textView.getText().toString();
                Toast.makeText(subtitleActivity.this, message, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(subtitleActivity.this,WebViewerActivity.class);
                intent.putExtra("subtitle",message);
                intent.putExtra("title",subcategoryValue);
                startActivity(intent);

                Toast.makeText(subtitleActivity.this, message, Toast.LENGTH_LONG).show();


            }
        });
    }


}


