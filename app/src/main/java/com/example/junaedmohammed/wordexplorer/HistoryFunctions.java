package com.example.junaedmohammed.wordexplorer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Junaed Mohammed on 25-Jan-18.
 */

public class HistoryFunctions extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "history";
    private static final String TABLE_NAME = "history_table";

    private static final String TAB_id = "id";
    private static final String TAB_his = "history_data";

    HistoryFunctions(Context c) {

        super(c, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String s = "CREATE TABLE " + TABLE_NAME + " ( " + TAB_id + " INTEGER PRIMARY KEY, " + TAB_his + " TEXT )";
        sqLiteDatabase.execSQL(s);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    void AddingHistoryToTable(Data_item ht) {

        SQLiteDatabase sqd = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(TAB_his, ht.getName());


        sqd.insert(TABLE_NAME, null, cv);
        sqd.close();
    }

    String[] his_data() {

        SQLiteDatabase sq = this.getReadableDatabase();

        String q = "SELECT * FROM " + TABLE_NAME;
        Cursor c = sq.rawQuery(q, null);

        String[] store_data = new String[c.getCount()];

        if (c.moveToFirst()){
            int counter = 0;
            do {
                store_data[counter]= new String(c.getString(c.getColumnIndex(TAB_his)));
                counter= counter+1;
            } while (c.moveToNext());
        }
        c.close();
        return store_data;
    }


 /*   int Delete_data( String data){

        SQLiteDatabase sqd = this.getWritableDatabase();

        return sqd.delete(TABLE_NAME, TAB_id+" = ? ", new String[]{data});
    }*/
}