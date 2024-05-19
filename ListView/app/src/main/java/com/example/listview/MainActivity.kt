package com.example.listview

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val list = findViewById<ListView>(R.id.list_view)
//        val item = arrayListOf("水果1", "水果2", "水果3", "水果4","水果5","水果6")
//        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, item)
//        list.adapter = adapter

        val array =
            resources.obtainTypedArray(R.array.image_list) //從 R 類別讀取圖檔
        val item = ArrayList<FruitItem>()
        for (i in 0 until 10) {
            val photo = array.getResourceId(i, 0) //水果圖片 Id
            val name = "水果${i + 1}" //水果名稱
            item.add(FruitItem(photo, name)) //新增水果資訊
        }
        Log.d("TAG", "onCreate: $item")
        val adapter = FruitAdapter(this, R.layout.item_fruit, item)
        list.adapter = adapter
    }

}