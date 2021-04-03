package com.example.uzb_rus

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.uzb_rus.core.WordEntity
import com.example.uzb_rus.core.adapter.WordAdapter
import com.example.uzb_rus.core.app.App
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: WordAdapter
    private lateinit var rv: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dao = App.getDatabase().wordDao()
        adapter = WordAdapter(this)
        rv = findViewById(R.id.rv)
        rv.adapter = adapter

        GlobalScope.launch {

            displayData()
        }
    }

    private fun displayData() {
        val list = App.getDatabase().wordDao().getAllData()
        adapter.list = list
        for (item in list) {
            Log.d("TTT", "displayData:${item} ")
        }

    }
}