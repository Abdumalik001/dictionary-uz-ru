package com.example.uzb_rus.core.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.uzb_rus.core.WordEntity

@Database(entities = [WordEntity::class], version = 1, exportSchema = false)
abstract class WordDB : RoomDatabase() {
    abstract fun wordDao(): WordDao


    companion object {
        @Volatile
        private var INSTANCE: WordDB? = null

        fun getDataBase(context: Context): WordDB {
            val temp = INSTANCE
            if (temp != null) {
                return temp
            }

            synchronized(this) {

                val instance = Room
                    .databaseBuilder(context, WordDB::class.java, "ru.db")
                    .createFromAsset("ru.db")
                    .build()

                INSTANCE = instance
                return instance
            }

        }

    }

}