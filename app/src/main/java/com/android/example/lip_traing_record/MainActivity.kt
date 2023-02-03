package com.android.example.lip_traing_record

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var mListView : ListView ?= null
    var db : DatabaseQuery ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.record)
        val mContext: Context = this
    //    db = DatabaseQuery(mContext)
//        db!!.storeData("文",1,"2023-02-02","14:20:20")
        var mListView = findViewById<ListView>(R.id.listview)
        var mAdapter : RecordAdapter? = null
        val users = arrayOf(
            "Virat Kohli", "Rohit Sharma", "Steve Smith",
            "Kane Williamson", "Ross Taylor"
        )
        mAdapter = RecordAdapter(mContext,mListView)
        mListView.adapter = mAdapter
        mListView.divider = null
  //      mListView.removeAllViews()
    }

    fun removeList(index : Int){
        mListView?.removeAllViews()
    }
}