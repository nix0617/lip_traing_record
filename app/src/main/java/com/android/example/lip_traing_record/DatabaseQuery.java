package com.android.example.lip_traing_record;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseQuery extends SQLiteOpenHelper {

    private static final String TABLE_NAME = "Record";
    private static final String COLUMN_ID = "gameID";
    private static final String COLUMN_WORD = "word";
    private static final String COLUMN_ISCORRECT = "iscorrect";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_TIME = "time";

    private ArrayList<String> words = new ArrayList<String>();
    private ArrayList<String> iscorrect = new ArrayList<String>();
    private ArrayList<String> id = new ArrayList<String>();

    Context mContext;


   public DatabaseQuery(Context mContext) {
        super(mContext, "Lip_Training", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = ("CREATE TABLE Record(gameID INTEGER PRIMARY KEY AUTOINCREMENT, word text, iscorrect int, date text, time text); ");
       // String sql = ("CREATE TABLE GamesLog(gameID int PRIMARY KEY, playDate text, playTime text, duration int, winningStatus int); ");
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + "Record");
        onCreate(sqLiteDatabase);
    }

    public void getDatabaseRecord(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME,null);
        c.moveToFirst();
        for(int i=0;i<c.getCount();i++){
            id.add(c.getString(0));
            words.add(c.getString(1));
            iscorrect.add(c.getString(2));
            c.moveToNext();
        }
    }

    public ArrayList<String> getId(){
        return id;
    }


    public ArrayList<String> getWords(){
       return words;
    }

    public ArrayList<String> getIscorrect(){
        return iscorrect;
    }

    public void insertRecord(Record record){
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put("word", record.getWord());
        values.put("iscorrect", record.getIsCorrect());
        values.put("date", record.getDate());
        values.put("time", record.getTime());

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME, null, values);
        //String query = ("INSERT INTO GamesLog('12', 'ok' );");
        //db.execSQL(query);
    }

    public void deleteRecord(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_ID + "=" + id,null);
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