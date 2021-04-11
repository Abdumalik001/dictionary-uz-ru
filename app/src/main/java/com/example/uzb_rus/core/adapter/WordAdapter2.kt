package com.example.uzb_rus.core.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uzb_rus.R
import com.example.uzb_rus.core.WordEntity
import com.example.uzb_rus.databinding.ItemWordBinding

class WordAdapter2(context: Context) : RecyclerView.Adapter<WordAdapter2.VH>() {
    private val inflater = LayoutInflater.from(context)
    private lateinit var binding: ItemWordBinding
    private var list = ArrayList<WordEntity>()

    var onItemClickListener: IOnItemClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        binding = ItemWordBinding.inflate(inflater, parent, false)

        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val word = list[position]
        var isfav = word.isfav
        var isExpand = word.isExpand
        holder.onBind(list[position])
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
        holder.bind.constrainL.setOnClickListener {
            Log.d("TTTTT", "onBind: CLiCk")
//            if (holder.bind.expandList.visibility == View.GONE) {
//                holder.bind.expandList.visibility = View.VISIBLE
//
//            } else {
//                holder.bind.expandList.visibility = View.GONE
//            }
            if (isExpand == 0) {
                holder.bind.expandList.visibility = View.VISIBLE
                isExpand = 1

            } else {
                holder.bind.expandList.visibility = View.GONE
                isExpand = 0


            }

        }
    }

    override fun getItemCount(): Int = list.size

    fun setList(list: ArrayList<WordEntity>) {
        this.list = list
        notifyItemRangeChanged(0, list.size)
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


        }
    }

    private fun insertFav(word: WordEntity?, isfav: Int) {
        onItemClickListener!!.onItemClick(word, isfav)
    }

}