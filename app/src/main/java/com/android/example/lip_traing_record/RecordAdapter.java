package com.android.example.lip_traing_record;

import static android.content.Context.MODE_PRIVATE;
import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

import android.app.ActionBar;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import com.android.example.lip_traing_record.MainActivity;

import com.daimajia.swipe.SwipeLayout;

public class RecordAdapter extends BaseAdapter {
    DatabaseQuery databaseQuery;
    private Context mContext;
    private ListView mlistview;
    private ArrayList<String> words = new ArrayList<String>();
    private ArrayList<String> iscorrect = new ArrayList<String>();

    public RecordAdapter(Context mContext, ListView mlistview) {
        this.mContext = mContext;
        this.mlistview = mlistview;
        databaseQuery = new DatabaseQuery(mContext);
        updateArraylist();
    }

    public void updateArraylist(){
        //insertDB();
        databaseQuery.getDatabaseRecord();
        words = databaseQuery.getWords();
        iscorrect = databaseQuery.getIscorrect();
    }

    public void insertDB(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        String date = sdf.format(c.getTime());

        Date currentTime = Calendar.getInstance().getTime();
        String time = dateFormat(currentTime);

        Record record = new Record("word5",1,date,time);
        databaseQuery.insertRecord(record);
    }


    public String dateFormat(Date currentTime){
        String hour;
        String minute;
        String second;
        hour = String.valueOf(currentTime.getHours());
        minute = String.valueOf(currentTime.getMinutes());
        second = String.valueOf(currentTime.getSeconds());
        return hour + ":" + minute + ":" + second;
    }


    @Override
    public int getCount() {
        return words.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater factory = LayoutInflater.from(mContext);
        View myView = factory.inflate(R.layout.record_list, null);
        myView.findViewById(R.id.red_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(mContext, "click delete" + i, Toast.LENGTH_SHORT).show();
                words.remove(i);
                iscorrect.remove(i);
                notifyDataSetChanged();
            }
        });
        TextView word =  myView.findViewById(R.id.text_data);
        word.setText("Lip Training Record: Word: "+words.get(i));
        TextView correct =  myView.findViewById(R.id.correctly);
        correct.setText("Correctly: "+ iscorrect.get(i));
        return myView;
    }
}
