package com.example.uzb_rus.core

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "WORDS")
data class WordEntity(

    var word: String,
    var meaning: String,
    @NonNull
    var isFav: Int = 0,
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
) {
    constructor() : this("", "")
}