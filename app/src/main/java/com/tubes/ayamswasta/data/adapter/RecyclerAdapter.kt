package com.tubes.ayamswasta.data.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.tubes.ayamswasta.R
import com.tubes.ayamswasta.data.model.Menu

class RecyclerAdapter(foodData : List<Menu>, context: Context): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private val foodData : List<Menu>
    private val context : Context

    init{
        this.foodData = foodData
        this.context = context
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView
        init {
            itemImage = itemView.findViewById(R.id.cardimage)
            itemTitle = itemView.findViewById(R.id.namamenu)
            itemDetail = itemView.findViewById(R.id.hargamenu)

            itemView.setOnClickListener { v: View ->
                var position: Int = getAdapterPosition()
                Snackbar.make(v, "Clink on item ${foodData[position].menu_name}",
                    Snackbar.LENGTH_LONG).setAction("Action", null).show()
            }
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
        val dt : Menu = this.foodData[i]
        viewHolder.itemTitle.text = dt.menu_name
        viewHolder.itemDetail.text = "Rp " + dt.menu_harga.toString()
        viewHolder.itemImage.setImageResource(R.drawable.makanann)
    }
//    getitemcount
    override fun getItemCount(): Int {
        return foodData.size
    }
}