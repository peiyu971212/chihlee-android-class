package com.example.listview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)
        val rvFruit = findViewById<RecyclerView>(R.id.rv_fruit)

        val array =
            resources.obtainTypedArray(R.array.image_list) //從 R 類別讀取圖檔
        val item = ArrayList<FruitItem>()
        for (i in 0 until 10) {
            val photo = array.getResourceId(i, 0) //水果圖片 Id
            val name = "水果${i + 1}" //水果名稱
            item.add(FruitItem(photo, name)) //新增水果資訊
        }

        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        rvFruit.layoutManager = linearLayoutManager
        rvFruit.adapter = RvFruitAdapter(R.layout.item_fruit, item)

    }
}