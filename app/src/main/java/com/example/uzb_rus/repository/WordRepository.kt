package com.example.uzb_rus.repository

import androidx.lifecycle.LiveData
import com.example.uzb_rus.core.WordEntity
import com.example.uzb_rus.core.db.WordDao

class WordRepository(private val dao: WordDao) {

    val readAllWords: LiveData<List<WordEntity>> = dao.getAllData()

    fun deleteAllWords() {
        dao.deleteAllData()
    }

    suspend fun insertWord(word: WordEntity) {
        dao.insert(word)
    }

//    fun getWordById(id: Int): LiveData<WordEntity> {
//        return dao.getWordById(id)
//    }


}