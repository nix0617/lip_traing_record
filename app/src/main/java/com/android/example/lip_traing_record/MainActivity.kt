package com.android.example.lip_traing_record

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var mListView : ListView ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.record)
        val mContext: Context = this
        var mListView = findViewById<ListView>(R.id.listview)
        var mAdapter : RecordAdapter? = null
        mAdapter = RecordAdapter(mContext,mListView)
        mListView.adapter = mAdapter
        mListView.divider = null
    }

    fun removeList(index : Int){
        mListView?.removeAllViews()
    }
}