package com.example.coffeshopfragment.comment

import android.view.LayoutInflater

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeshopfragment.R


class CommentCard(val text: String) {}

class CommentCardAdapter(var items: ArrayList<CommentCard>) : RecyclerView.Adapter<CommentCardHolder>() {
    lateinit var onClick: (View) -> Unit

    init {
        this.items = items
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CommentCardHolder {
        val itemView =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.comment_card, viewGroup, false)
        return CommentCardHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: CommentCardHolder, pos: Int) {
        val item = items.get(pos)
        viewHolder.bindComment(item, onClick)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}

class CommentCardHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var text: TextView


    init {
        text = itemView.findViewById(R.id.textView5)
    }

    fun bindComment(t: CommentCard, onClick: (View) -> Unit) = with(itemView) {
        text.text = t.text
        setOnClickListener { onClick(itemView) }
    }
}