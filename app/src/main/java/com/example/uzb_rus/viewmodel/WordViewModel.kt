package com.example.uzb_rus.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.uzb_rus.core.WordEntity
import com.example.uzb_rus.core.db.WordDB
import com.example.uzb_rus.core.db.WordDao
import com.example.uzb_rus.repository.WordRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WordViewModel(application: Application) : AndroidViewModel(application) {
    val readAllWord: LiveData<List<WordEntity>>
    private val repository: WordRepository
    private val dao: WordDao

    init {
        dao = WordDB.getDataBase(application).wordDao()
        readAllWord = dao.getAllData()
        repository = WordRepository(dao)
    }

    fun insertWord(word: WordEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertWord(word)
        }
    }

    fun deleteAllWords() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllWords()
        }
    }

    fun getWordById(id: Int): LiveData<WordEntity> {
        return dao.getWordById(id)
    }


}