package com.example.shopdemoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shopdemoapp.data.ProductDetail

class CartAdapter(private val data: ArrayList<ProductDetail>) :
    RecyclerView.Adapter<CartAdapter.ViewHolder>() {
    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val ivProduct = v.findViewById<ImageView>(R.id.iv_product)
        val tvProductName = v.findViewById<TextView>(R.id.tv_product_name)
        val tvProductPrice = v.findViewById<TextView>(R.id.tv_product_price)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.tvProductName.text = item.productName
        holder.tvProductPrice.text = "$" + item.productPrice.toString()
        Glide.with(holder.ivProduct)
            .load(item.imageUrl)
            .into(holder.ivProduct)
    }
}