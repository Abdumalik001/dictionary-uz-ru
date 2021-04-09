package com.example.uzb_rus.core.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uzb_rus.core.WordEntity
import com.example.uzb_rus.databinding.ItemWordBinding

class WordAdapter2(context: Context) : RecyclerView.Adapter<WordAdapter2.VH>() {
    private val inflater = LayoutInflater.from(context)
    private lateinit var binding: ItemWordBinding
    private var list: List<WordEntity> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        binding = ItemWordBinding.inflate(inflater, parent, false)

        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int=list.size

    fun setList(list: List<WordEntity>) {
        this.list = list
        notifyItemRangeChanged(list.size-1, list.size)
    }

    class VH(val binding: ItemWordBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(word: WordEntity) {
            binding.word.text = word.word
        }
    }
}