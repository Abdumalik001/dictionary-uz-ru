package com.example.uzb_rus.core.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.uzb_rus.core.WordEntity

@Dao
interface WordDao {


    @Insert
    fun insert(vararg wordEntity: WordEntity)

    @Delete
    fun delete(wordEntity: WordEntity)

    @Query("select * from  WORDS")
    fun getAllData(): List<WordEntity>

}