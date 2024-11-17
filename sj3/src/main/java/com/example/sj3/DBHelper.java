package com.example.sj3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context){

        super(context, "myregdb", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="create table user(";
        sql+="id integer primary key autoincrement,";
        sql+="username varchar(20),password varchar(20),";
        sql+="sex varchar(20),love varchar(20),";
        sql+="major varchar(20),banji varchar(20),";
        sql+="selectdate varchar(20),jieshao varchar(20),";
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
