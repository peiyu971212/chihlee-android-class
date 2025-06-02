package com.example.shopdemoapp.ui.product

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.shopdemoapp.R
import com.example.shopdemoapp.api.AppClientManager
import com.example.shopdemoapp.api.ProductApi
import com.example.shopdemoapp.data.ProductDetailResponse
import com.example.shopdemoapp.data.ProductsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        val ivProduct = findViewById<ImageView>(R.id.iv_product)
        val tvProductName = findViewById<TextView>(R.id.tv_product_name)
        val tvProductPrice = findViewById<TextView>(R.id.tv_product_price)
        val tvProductDes = findViewById<TextView>(R.id.tv_product_des)
        val tvQty = findViewById<TextView>(R.id.tv_buy_qty)
        val tvAdd = findViewById<TextView>(R.id.tv_add)
        val tvReduce = findViewById<TextView>(R.id.tv_reduce)
        val btnAddToCart = findViewById<Button>(R.id.btn_add_cart)

        val position = intent.getIntExtra("position", 0)
        val apiServer = AppClientManager.client.create(ProductApi::class.java)
        apiServer.getProductDetail(position).enqueue(object :
            Callback<ProductDetailResponse> {
            override fun onResponse(
                call: Call<ProductDetailResponse>,
                response: Response<ProductDetailResponse>
            ) {
                val productDetail = response.body()?.data
                response.body()?.data?.let {
                    Glide.with(ivProduct)
                        .load(productDetail?.image)
                        .into(ivProduct)
                    tvProductName.text = productDetail?.title
                    tvProductPrice.text =
                        productDetail?.price.toString()
                    tvProductDes.text = productDetail?.description
                }
            }

            override fun onFailure(call: Call<ProductDetailResponse>, t: Throwable) {
                Log.d("TAG", "onFailure: fail${t.message}")
            }
        })

    }
}