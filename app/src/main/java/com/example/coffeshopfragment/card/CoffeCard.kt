package com.example.coffeshopfragment.card

import android.view.LayoutInflater

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeshopfragment.R


class CafeCard(val image: Int, val nameCoffe: String, val siteName: String) {}

class CafeCardAdapter(var items: ArrayList<CafeCard>) : RecyclerView.Adapter<CafeCardHolder>() {
    lateinit var onClick: (View) -> Unit

    init {
        this.items = items
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CafeCardHolder {
        val itemView =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.coffe_card, viewGroup, false)
        return CafeCardHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: CafeCardHolder, pos: Int) {
        val item = items.get(pos)
        viewHolder.bindCoffe(item, onClick)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}

class CafeCardHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var image: ImageView
    private var nameCoffe: TextView
    private var siteName: TextView
    private var ratingStar: TextView

    init {
        image = itemView.findViewById(R.id.imageView)
        nameCoffe = itemView.findViewById(R.id.textView)
        siteName = itemView.findViewById(R.id.textView3)
        ratingStar = itemView.findViewById(R.id.textView2)

    }

    fun bindCoffe(t: CafeCard, onClick: (View) -> Unit) = with(itemView) {
        image.setImageResource(t.image)
        nameCoffe.text = t.nameCoffe
        siteName.text = t.siteName

        val rb = findViewById<RatingBar>(R.id.ratingbar)
        rb.onRatingBarChangeListener = RatingBar.OnRatingBarChangeListener { ratingBar, rating, fromUser ->
            ratingStar.text = rating.toString()
        }

        setOnClickListener { onClick(itemView) }
    }
}