package com.atheeshproperty.itaidapp;

/**
 * Created by vimukthi on 6/8/2018.
 */


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    /**
     * Private constructor to andoid object creation from outside classes.
     *
     * @param context
     */
    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }
    /**
     * Read all quotes from the database.
     *
     * @return a List of quotes
     */
      public List<String> getSubCategory(String name) {
        String value=name;
        String sqlquery;
        List<String> list = new ArrayList<>();
        //List<String> list1=new ArrayList<>();
            sqlquery="Select * from itaidTable where category="+"\'"+value+"\'group by subcategory";
        Cursor cursor = database.rawQuery(sqlquery,null);
        //Cursor cursor  = database.query(true ,new String[]{category,subcategory,subtitle,link}, null,null,subcategory,null,null,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(1));

            cursor.moveToNext();

        }
        cursor.close();
        return list;
    }
    public List<String> getSubTitle(String name){
          String cat = name;
          String sqlquery="select * from itaidTable where subcategory="+"\'"+cat+"\'";
          List<String> list = new ArrayList<>();
          Cursor cursor = database.rawQuery(sqlquery,null);
          cursor.moveToFirst();
          while (!cursor.isAfterLast()) {
              list.add(cursor.getString(2));
              cursor.moveToNext();
            }
            cursor.close();
          return list;
    }
    //public List<String> getLink(String name) {
    public String getLink(String subtitle, String subcategory) {
        String subT = subtitle;
        String SubC= subcategory;
       // String SubT= subtitle;
        String sqlquery;
        //List<String> list = new ArrayList<>();
        sqlquery = "Select * from itaidTable where  subcategory="+"\'"+SubC+"\'" + "AND subtitle="+"\'"+subT+"\'" ;

        Cursor cursor = database.rawQuery(sqlquery, null);
        String ret = "";
        if (cursor.getCount() >= 1) {
            cursor.moveToFirst();

            try {
                for (int i = 0; i < cursor.getCount(); i++) {
                    ret = cursor.getString(3);
                    // String message = cc.getString(1);

                }
                cursor.moveToNext();
            } catch (Exception e) {

            }
        } cursor.close();
            return ret;
        }
    }



    // cursor.moveToFirst();
        //while (!cursor.isAfterLast()) {
        //    list.add(cursor.getString(2));
        //    cursor.moveToNext();
        //}

