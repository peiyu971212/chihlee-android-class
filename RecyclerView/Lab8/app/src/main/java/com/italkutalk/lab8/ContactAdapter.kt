package com.italkutalk.lab8

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(private val data: ArrayList<Contact>) :
    RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    //實作 RecyclerView.ViewHolder 來儲存 View
    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        //連結畫面中的元件
        val tvName = v.findViewById<TextView>(R.id.tv_name)
        val tvPhone = v.findViewById<TextView>(R.id.tv_phone)
        val ivDelete = v.findViewById<ImageView>(R.id.iv_delete)


    }

    //回傳資料數量
    override fun getItemCount(): Int {
        return data.size
    }

    //建立 ViewHolder 與 Layout 並連結彼此
    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int):
            ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_contact, viewGroup, false)
        return ViewHolder(v)
    }

    //將資料指派給元件呈現
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvName.text = data[position].name
        holder.tvPhone.text = data[position].phone
        //設定監聽器，使用 removeAt()刪除指定位置的資料
        holder.ivDelete.setOnClickListener {
            data.removeAt(position)
            notifyDataSetChanged()
        }
        holder.itemView.setOnClickListener{ Log.d("TAG", "onBindViewHolder: ")}
    }
}