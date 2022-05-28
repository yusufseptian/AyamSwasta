package com.tubes.ayamswasta

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
//    image list
    private val images = intArrayOf(
    R.drawable.makanann
    )
//    title list
    private val titles = arrayOf(
    "Ayam Goreng"
    )
//    detail list
    private val details = arrayOf(
    "Rp 13.000"
    )
//    viewholder class
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView
        init {
            itemImage = itemView.findViewById(R.id.cardimage)
            itemTitle = itemView.findViewById(R.id.namamenu)
            itemDetail = itemView.findViewById(R.id.hargamenu)

//            itemView.setOnClickListener { v: View ->
//                var position: Int = getAdapterPosition()
//                Snackbar.make(v, "Clink on item $(titles[position])",
//                    Snackbar.LENGTH_LONG).setAction("Action", null).show()
//            }
        }
    }

//    oncreateviewholder
    override fun onCreateViewHolder(ViewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(ViewGroup.context)
            .inflate(R.layout.card_layout, ViewGroup, false)
        return ViewHolder(v)
    }
//    onbindviewholder
    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text = titles[i]
        viewHolder.itemDetail.text = details[i]
        viewHolder.itemImage.setImageResource(images[i])
    }
//    getitemcount
    override fun getItemCount(): Int {
        return titles.size
    }
}