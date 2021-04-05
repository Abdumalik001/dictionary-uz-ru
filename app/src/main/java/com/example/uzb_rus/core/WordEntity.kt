package com.example.uzb_rus.core

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "WORDS")
data class WordEntity(

    val word: String?,
    val meaning: String?,
    @ColumnInfo(defaultValue = "0")
    var isfav: Int = 0

) {
    @PrimaryKey(autoGenerate = true)
    var id: Int=0

}