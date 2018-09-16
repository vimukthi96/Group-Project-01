package com.atheeshproperty.itaidapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext ;
    private List<String> mData ;
    private int[] imgData;




    public RecyclerViewAdapter(Context mContext, List<String> mData, int[] imgData) {
        this.mContext = mContext;
        this.mData = mData;
        this.imgData=imgData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardveiw_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {


                // imageView.setImageResource(drawableId);
        holder.subCategory.setText(mData.get(position) );
        holder.img_thumbnail.setImageResource(imgData[position]);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(mContext,mData.get(position), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContext,subtitleActivity.class);
                //Intent intent = new Intent( this,subtitleActivity.class);
                intent.putExtra("subcategoryValue",mData.get(position));
           //     intent.putExtra("categoryValue",)
                mContext.startActivity(intent);

            }
        });



    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView subCategory;
        ImageView img_thumbnail;
        CardView cardView ;

        public MyViewHolder(View itemView) {
            super(itemView);

            subCategory = (TextView) itemView.findViewById(R.id.subcategory_id) ;
            img_thumbnail = (ImageView) itemView.findViewById(R.id.img_id);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);


        }
    }


}
