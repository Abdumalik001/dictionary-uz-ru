package com.example.uzb_rus.core

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "WORDS")
data class WordEntity(
    @PrimaryKey
    val id: Int,
    val word: String?,
    val meaning: String?,
    @ColumnInfo(defaultValue = "0")
    val isfav: Int?

) : Parcelable