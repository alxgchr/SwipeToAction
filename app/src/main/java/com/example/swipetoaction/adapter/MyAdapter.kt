package com.example.swipetoaction.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.contentValuesOf
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.swipetoaction.R
import com.example.swipetoaction.model.Item

class MyAdapter(internal var context: Context, internal var itemList:MutableList<Item>): RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(context).load(itemList[position].image).into(holder.txt_cart_img)
        holder.txt_cart_pice.text = itemList[position].price
        holder.txt_cart_name.text = itemList[position].name
    }

    override fun getItemCount(): Int {
        return  itemList.size
    }

}