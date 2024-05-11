package com.italkutalk.lab7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //將變數與 XML 元件綁定
        val spinner = findViewById<Spinner>(R.id.spinner)
        val gridView = findViewById<GridView>(R.id.gridView)
        val listView = findViewById<ListView>(R.id.listView)
        val data = ArrayList<FruitItem>() //儲存水果資訊
        val dataName = ArrayList<String>()
        val array =
            resources.obtainTypedArray(R.array.image_list) //從 R 類別讀取圖檔
        for (i in 0 until array.length()) {
            val photo = array.getResourceId(i, 0) //水果圖片 Id
            val name = "水果${i + 1}" //水果名稱
            dataName.add(name)
            data.add(FruitItem(photo, name)) //新增水果資訊
        }
        array.recycle() //釋放圖檔資源
        //建立 ArrayAdapter 物件，並傳入字串與 simple_list_item_1.xml
        spinner.adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,dataName
        )
        //設定橫向顯示列數
        gridView.numColumns = 3
        //建立 MyAdapter 物件，並傳入 adapter_vertical 作為畫面
        gridView.adapter = FruitAdapter(this, R.layout.item_fruit_vertical, data)
        //建立 MyAdapter 物件，並傳入 adapter_horizontal 作為畫面
        listView.adapter = FruitAdapter(
            this,
            R.layout.item_fruit_horizontal, data
        )
    }
}

