package com.example.uzb_rus

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.uzb_rus.core.WordEntity
import com.example.uzb_rus.core.adapter.WordAdapter
import com.example.uzb_rus.core.app.App
import com.example.uzb_rus.core.db.WordDao
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val adapter by lazy(LazyThreadSafetyMode.NONE) { WordAdapter(this) }

    private lateinit var rv: RecyclerView

    private var dao: WordDao? = null
    private var list: MutableList<WordEntity>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dao = App.getDatabase().wordDao()

        rv = findViewById(R.id.rv)
        rv.adapter = adapter

        GlobalScope.launch {
            addData()
            displayData()
        }
        adapter.submitList(list)
    }

    private fun addData() {
        for (i in 0..50) {
            dao!!.insert(WordEntity( "salom $i", "salom salom $i"))
        }
    }


    private fun displayData() {
        list = dao!!.getAllData()
    }
}