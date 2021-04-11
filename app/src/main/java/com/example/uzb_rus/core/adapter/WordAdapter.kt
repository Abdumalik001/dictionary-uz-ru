package com.example.uzb_rus.core.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.uzb_rus.R
import com.example.uzb_rus.core.WordEntity
import com.example.uzb_rus.databinding.ItemWordBinding
import com.example.uzb_rus.viewmodel.WordViewModel


class WordAdapter(ctx: Context) : ListAdapter<WordEntity, WordAdapter.VH>(WordCallBack()) {
    private val inflater = LayoutInflater.from(ctx)
    private lateinit var binding: ItemWordBinding

    var onItemClickListener: IOnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {

        binding = ItemWordBinding.inflate(inflater, parent, false)

        return VH(binding)

    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val word = getItem(position)
        var isfav = word.isfav
        holder.onBind(word)

        holder.bind.icFavorite.setOnClickListener {
            if (isfav == 0) {
                holder.bind.icFavorite.setImageResource(R.drawable.ic_favorite)
                isfav = 1
                insertFav(word, isfav!!)
            } else {
                holder.bind.icFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                isfav = 0
                insertFav(word, isfav!!)

            }
        }





    }


    class VH(val bind: ItemWordBinding) : RecyclerView.ViewHolder(bind.root) {
        lateinit var word: WordEntity

        fun onBind(wordEntity: WordEntity) {
            bind.word.text = wordEntity.word
            bind.id.text = wordEntity.id.toString()
            bind.meaning.text = wordEntity.meaning
            this.word = wordEntity
            if (word.isfav == 0) {
                bind.icFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24)
            } else {
                bind.icFavorite.setImageResource(R.drawable.ic_favorite)
            }


            bind.constrainL.setOnClickListener {
                Log.d("TTTTT", "onBind: CLiCk")
                if (bind.expandList.visibility == View.GONE) {
                    bind.expandList.visibility = View.VISIBLE
                } else {
                    bind.expandList.visibility = View.GONE
                }
            }


        }

    }


    private fun insertFav(word: WordEntity?, isfav: Int) {
        onItemClickListener!!.onItemClick(word, isfav)
    }

}

