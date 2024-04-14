package com.example.shopapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class CartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cart)
        val tvProductName = findViewById<TextView>(R.id.tv_product_name)
        val tvPrice = findViewById<TextView>(R.id.tv_price)
        val tvQty = findViewById<TextView>(R.id.tv_qty)
        val tvTotalPrice = findViewById<TextView>(R.id.tv_total_price)


        intent.extras?.let { //判斷Intnet不為空，並檢查是否夾帶資料
            val productText = it.getString("productName") //以key取得對應資料
            val productPriceText = it.getInt("price")
            val qtyText = it.getInt("qty")
            tvProductName.text = productText
            tvPrice.text = "$${productPriceText}"
            tvQty.text = qtyText.toString()
            tvTotalPrice.text = "$${(productPriceText * qtyText)}"
        }
    }
}