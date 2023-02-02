package com.android.example.lip_traing_record;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import java.util.ArrayList;
import java.util.List;

public class DatabaseQuery {
    SQLiteDatabase db;
    String sql;
    Cursor cursor = null;
    String[] columns = { "word", "isCorrect", "date", "time"};
    String dataStr = String.format("%4s %-10s %7s\n", "sID", "sName", "sGender");

    Context mContext;
    int i;

    DatabaseQuery(){
        db = SQLiteDatabase.openDatabase("/data/data/com.android.example.lip_traing_record/databases/game", null, SQLiteDatabase.CREATE_IF_NECESSARY);
    }


    DatabaseQuery(Context mContext){

        // super(mContext,dataBase,null,1);
        this.mContext = mContext;

        try {
            db = SQLiteDatabase.openDatabase("/data/data/com.example.tic_tac_teo/databases/game", null, SQLiteDatabase.CREATE_IF_NECESSARY);
            sql = ("CREATE TABLE GamesLog(gameID int PRIMARY KEY, playDate text, playTime text, duration int, winningStatus int); ");
            db.execSQL(sql);
        }catch (SQLiteException e){
            // PlayActivity.showMessage(mContext, e.getMessage());
        }
    }

    public void storeData(String date,String time,int duration,int status){
        try {

            //get the count of row
            i =   db.rawQuery("select * from GamesLog",null).getCount();
            //PlayActivity.showMessage(mContext, String.valueOf(i));

            sql = ("INSERT INTO GamesLog(gameID,playDate,playTime,duration,winningStatus) values " + "('"+i+"','"+date+"','"+time+"',"+duration+","+status+");");
            db.execSQL(sql);


        }catch (SQLiteException e){
            //PlayActivity.showMessage(mContext, e.getMessage());
        }
    }
    public Cursor getAllData(){

        try{
            cursor = db.rawQuery("select * from GamesLog",null);

        }catch (Exception e){

        }
        return cursor;
    }



}