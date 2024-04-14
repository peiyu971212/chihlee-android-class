package com.example.shopapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class ShopActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_shop)
        val tvProduct = findViewById<TextView>(R.id.tv_product)
        val tvProductPrice = findViewById<TextView>(R.id.tv_price)
        val btnAddCart = findViewById<Button>(R.id.btn_add_cart)
        val tvPlus = findViewById<TextView>(R.id.tv_plus)
        val tvMinus = findViewById<TextView>(R.id.tv_minus)
        val tvQty = findViewById<TextView>(R.id.tv_qty)
        var qty = 0
        var price = 2366
        tvProductPrice.text = "$$price" //顯示$2366

        btnAddCart.setOnClickListener {
            //宣告Bundle
            val bundle = Bundle()
            bundle.putString("productName", tvProduct.text.toString()) //把tvProduct.text.toString()放入bundle
            bundle.putInt("price", price)
            bundle.putInt("qty", qty)
            val intent = Intent(this, CartActivity::class.java) //宣告Intent
            intent.putExtras(bundle)//夾帶Bundle
            startActivity(intent)//發送Intent
        }

        tvPlus.setOnClickListener {
            qty += 1
            tvQty.text = qty.toString()
        }

        tvMinus.setOnClickListener {
            if (qty <= 0) {
                qty = 0
            } else {
                qty -= 1
            }
            tvQty.text = qty.toString()
        }
    }
}