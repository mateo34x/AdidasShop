package com.example.adidasshop

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide

class ShoesAdapter(private val datalist: MutableList<GroceryItem> ) :
    RecyclerView.Adapter<ShoesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shoes_layout, parent, false)
        return ViewHolder(view)    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = datalist[position]
        holder.NameShoe.text = currentItem.name+" "
        holder.priceshoe.text = currentItem.price


        val encode = currentItem.fotoBase1
        encode.let {
            Glide.with(holder.itemView)
                .asBitmap()
                .load(it)
                .into(holder.ImgShoes)
        }


        holder.itemView.setOnClickListener {
            val enconde2 = currentItem.fotoBase2
            val intent = Intent(holder.itemView.context,DetailShoes::class.java)
            intent.putExtra("photo2",enconde2)
            holder.itemView.context.startActivity(intent)
        }

    }



    override fun getItemCount(): Int {
        return datalist.size
    }





    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ImgShoes: ImageView = itemView.findViewById(R.id.ImgShoes)
        val NameShoe: TextView = itemView.findViewById(R.id.NameShoe)
        val priceshoe: TextView = itemView.findViewById(R.id.priceshoe)
    }
}