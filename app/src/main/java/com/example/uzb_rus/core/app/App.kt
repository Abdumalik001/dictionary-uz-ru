package com.example.uzb_rus.core.app

import android.app.Application
import androidx.room.Room
import com.example.uzb_rus.core.db.WordDB

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        db = Room.databaseBuilder(applicationContext, WordDB::class.java, "uz.db")
            .createFromAsset("uz.db")
            .build()

    }

    companion object {
        private lateinit var db: WordDB
        fun getDatabase(): WordDB = db
    }
}