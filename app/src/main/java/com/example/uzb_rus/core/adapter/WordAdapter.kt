package com.example.uzb_rus.core.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.uzb_rus.core.WordEntity
import com.example.uzb_rus.databinding.ItemWordBinding


class WordAdapter(ctx: Context) : ListAdapter<WordEntity, WordAdapter.VH>(WordCallBack()) {
    private val inflater = LayoutInflater.from(ctx)
    private lateinit var binding: ItemWordBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {

        binding = ItemWordBinding.inflate(inflater, parent, false)

        return VH(binding)

    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val word = getItem(position)
        holder.onBind(word)
    }

    class VH(val bind: ItemWordBinding) : RecyclerView.ViewHolder(bind.root) {


        fun onBind(wordEntity: WordEntity) {
            bind.word.text = wordEntity.word
            bind.id.text = wordEntity.id.toString()
            // bind.meaning.text = wordEntity.meaning
        }

    }


}