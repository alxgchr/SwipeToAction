package com.example.swipetoaction.adapter

import android.view.TextureView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*

class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    var txt_cart_name: TextView
    var txt_cart_pice: TextView
    var txt_cart_img: ImageView
    init {
        txt_cart_img = itemView.cart_image
        txt_cart_name = itemView.cart_item_name
        txt_cart_pice = itemView.cart_item_price
    }
}