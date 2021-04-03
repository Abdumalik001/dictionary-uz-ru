package com.example.uzb_rus.core.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.uzb_rus.R
import com.example.uzb_rus.core.WordEntity


class WordAdapter(ctx: Context) : RecyclerView.Adapter<WordAdapter.VH>() {
    private val inflater = LayoutInflater.from(ctx)
    var list: List<WordEntity>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val vh = VH(inflater.inflate(R.layout.item_word, parent, false))

        return vh
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(list!![position])
    }

    override fun getItemCount(): Int = list!!.size


    class VH(var v: View) : RecyclerView.ViewHolder(v) {
        private val wordTxt: TextView = v.findViewById(R.id.word)
        private val meanTxt: TextView = v.findViewById(R.id.meaning)
        fun onBind(wordEntity: WordEntity) {
            wordTxt.text = wordEntity.word
            meanTxt.text = wordEntity.meaning
        }
    }


}