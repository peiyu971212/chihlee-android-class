package com.example.shopdemoapp.ui.product

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shopdemoapp.R
import com.example.shopdemoapp.data.Product

interface OnItemClickListener {
    fun onClickProduct(position: Int) {}
}


class ProductAdapter(
    private val data: ArrayList<Product>,
    private val context: Context
) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val clProduct = v.findViewById<ConstraintLayout>(R.id.cl_product)
        val ivProduct = v.findViewById<ImageView>(R.id.iv_product)
        val tvProductName = v.findViewById<TextView>(R.id.tv_product_name)
        val tvProductPrice = v.findViewById<TextView>(R.id.tv_product_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.clProduct.setOnClickListener {
            val intent = Intent(
                context,
                ProductDetailActivity::class.java
            )
            intent.putExtra("position", position)
            context.startActivity(intent)
        }
        holder.tvProductName.text = item.productName
        holder.tvProductPrice.text = "$" + item.price.toString()
        Glide.with(holder.ivProduct)
            .load(item.image)
            .into(holder.ivProduct)
    }
}