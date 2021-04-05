package com.example.uzb_rus.core.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.uzb_rus.core.WordEntity

class WordCallBack : DiffUtil.ItemCallback<WordEntity>() {
    override fun areItemsTheSame(oldItem: WordEntity, newItem: WordEntity) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: WordEntity, newItem: WordEntity) = oldItem == newItem

}