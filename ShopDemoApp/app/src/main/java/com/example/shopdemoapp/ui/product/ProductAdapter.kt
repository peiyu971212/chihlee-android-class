package com.example.shopdemoapp.ui.product

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.shopdemoapp.data.Product

class ProductAdapter(private val data: ArrayList<Product>) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {}
}