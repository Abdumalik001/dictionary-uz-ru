package com.example.uzb_rus.core.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.uzb_rus.core.WordEntity

@Database(entities = [WordEntity::class], version = 1, exportSchema = false)
abstract class WordDB :RoomDatabase(){
    abstract fun wordDao(): WordDao
}