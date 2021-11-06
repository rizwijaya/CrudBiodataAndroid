package com.murphy.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SqlHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "biodata.db"; //Inisialisasi Database biodata
    private static final int DATABASE_VERSION = 1;
    public SqlHelper(Context context) { //Inherite
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Buat tabel baru biodata
        String sql = "create table biodata (no integer primary key, nrp text null, nama text null);";
        Log.d("Data","onCreate"+sql);
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

    }
}
