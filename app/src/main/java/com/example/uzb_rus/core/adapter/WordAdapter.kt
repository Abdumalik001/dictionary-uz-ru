package com.example.uzb_rus.core.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.uzb_rus.R
import com.example.uzb_rus.core.WordEntity
import kotlinx.android.extensions.LayoutContainer


class WordAdapter(ctx: Context) : ListAdapter<WordEntity, WordAdapter.VH>(WordCallBack()) {
    private val inflater = LayoutInflater.from(ctx)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = inflater.inflate(R.layout.item_word, parent, false)
        return VH(v)

    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val word = getItem(position)
        holder.onBind(word)
    }

    class VH(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {

        fun onBind(wordEntity: WordEntity) {

        }

    }


}