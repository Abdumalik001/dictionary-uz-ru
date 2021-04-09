package com.example.uzb_rus.core.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.uzb_rus.core.WordEntity

@Dao
interface WordDao {

    @Insert
    suspend fun insert(vararg wordEntity: WordEntity)

    @Query("Delete from  WORDS")
    fun deleteAllData()


    @Query("select * from WORDS order by word")
    fun getAllData(): LiveData<List<WordEntity>>

    @Query("select* from WORDS where id=:id")
    fun getWordById(id: Int): LiveData<WordEntity>


}