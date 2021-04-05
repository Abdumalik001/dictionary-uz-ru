package com.example.uzb_rus.core.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.uzb_rus.core.WordEntity

@Dao
interface WordDao {


    @Insert
    fun insert(vararg wordEntity: WordEntity)

    @Query("Delete from  WORDS")
    fun deleteAllData()

    @Query("""select * from WORDS""")
    fun getAllData(): MutableList<WordEntity>

//    @Query("SELECT* FROM WORDS WHERE id>0 and id<=:count")
//    fun getData(count: Int): ArrayList<WordEntity>

}