package com.example.junaedmohammed.wordexplorer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Junaed Mohammed on 24-Jan-18.
 */

public class FavoriteFunctions extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "favorite";
    private static final String TABLE_NAME = "favorite_table";

    private static final String TAB_id ="id";
    private static final String TAB_fav ="favorite_data";

    FavoriteFunctions(Context c){

        super(c,DATABASE_NAME,null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String s = "CREATE TABLE "+TABLE_NAME+" ( "+TAB_id+" INTEGER PRIMARY KEY, "+TAB_fav+" TEXT )";
        sqLiteDatabase.execSQL(s);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    void AddingFavoriteToTable(Data_item fd){

        SQLiteDatabase sqd = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(TAB_fav,fd.getName());


        sqd.insert(TABLE_NAME,null,cv);
        sqd.close();
    }


    String[] fav_data(){

        SQLiteDatabase sq = this.getReadableDatabase();

        String q = "SELECT * FROM "+TABLE_NAME;
        Cursor c = sq.rawQuery(q , null);

        String[] store_data = new String[c.getCount()];


        if (c.moveToFirst()){
            int counter = 0;
            do {
                store_data[counter]= new String(c.getString(c.getColumnIndex(TAB_fav)));
                counter= counter+1;
            } while (c.moveToNext());
        }
        return store_data ;


    }


    String fetch_data(int id){

        SQLiteDatabase sq = this.getReadableDatabase();

        String q = "SELECT "+TAB_fav+" FROM "+TABLE_NAME+" WHERE "+TAB_id+" = "+id;
        Cursor c = sq.rawQuery(q , null);

        String s= "";

        if (c.moveToFirst()){
            s = c.getString(c.getColumnIndex(TAB_fav+""));
        }
        return s;
    }


    int Update_data(int id, String data){

        SQLiteDatabase sqd = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TAB_fav,data);

        return sqd.update(TABLE_NAME, cv, TAB_id+" = ? ", new String[]{id+""});
    }

}
