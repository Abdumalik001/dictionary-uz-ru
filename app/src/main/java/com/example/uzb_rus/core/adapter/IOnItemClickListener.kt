package com.example.uzb_rus.core.adapter

import com.example.uzb_rus.core.WordEntity

interface IOnItemClickListener {
    fun onItemClick(wordEntity: WordEntity?, isfav: Int)

}