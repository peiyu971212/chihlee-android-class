package com.example.listview

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView


class FruitAdapter(context: Context, private val layout: Int, data: ArrayList<FruitItem>) :
    ArrayAdapter<FruitItem>(context, layout, data) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //依據傳入的 Layout 建立畫面
        val view = View.inflate(parent.context, layout, null)
        //綁定元件
        val ivPhoto = view.findViewById<ImageView>(R.id.iv_photo)
        val tvName = view.findViewById<TextView>(R.id.tv_name)

        //依據 position 取得對應的資料內容
        val item = getItem(position) ?: return view
        //將圖片指派給 ImageView 呈現
        ivPhoto.setImageResource(item.photo)
        //將名稱指派給 TextView 呈現
        tvName.text = item.name
        return view
    }
}