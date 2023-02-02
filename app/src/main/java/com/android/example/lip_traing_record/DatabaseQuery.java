package com.android.example.lip_traing_record;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseQuery extends SQLiteOpenHelper {

    private static final String TABLE_NAME = "record";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_WORD = "word";
    private static final String COLUMN_ISCORRECT = "isCorrect";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_TIME = "time";


    Context mContext;


    DatabaseQuery(Context mContext) {
        super(mContext, "game", null, 1);


    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = ("CREATE TABLE GamesLog(gameID int PRIMARY KEY, playDate text, playTime text, duration int, winningStatus int); ");
        sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    /*public String addOne(Record record){
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_ID,record.getId());
        cv.put(COLUMN_ISCORRECT,record.getIsCorrect());
        cv.put(COLUMN_WORD,record.getWord());
        cv.put(COLUMN_DATE,record.getDate());
        cv.put(COLUMN_TIME,record.getTime());
        //cv.put();

    }*/
}