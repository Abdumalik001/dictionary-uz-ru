package com.example.uzb_rus.core.app

import android.app.Application
import androidx.room.Room
import com.example.uzb_rus.core.db.WordDB

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        db = Room.databaseBuilder(applicationContext, WordDB::class.java, "mybase.db")
           // .createFromAsset("ru.db")
            .build()

    }

    companion object {
        private lateinit var db: WordDB
        fun getDatabase(): WordDB = db
    }
}