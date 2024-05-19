package com.italkutalk.lab8

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: ContactAdapter
    private val contacts = ArrayList<Contact>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //將變數與 XML 元件綁定
        val rvContact = findViewById<RecyclerView>(R.id.rv_contact)
        val btnSend = findViewById<Button>(R.id.btn_send)
        val edName = findViewById<EditText>(R.id.ed_name)
        val edPhone = findViewById<EditText>(R.id.ed_phone)

        //創建 LinearLayoutManager 物件，設定垂直排列
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        rvContact.layoutManager = linearLayoutManager
        //創建 MyAdapter 並連結 recyclerView
        adapter = ContactAdapter(contacts)
        rvContact.adapter = adapter
        //設定按鈕監聽器
        btnSend.setOnClickListener {
            //判斷是否輸入資料
            when {
                edName.length() < 1 -> showToast("請輸入姓名")
                edPhone.length() < 1 -> showToast("請輸入電話")
                else -> {
                    //新增聯絡人資料
                    contacts.add(Contact(edName.text.toString(), edPhone.text.toString()))
                    //更新列表
                    adapter.notifyDataSetChanged()

                }
            }
        }
    }

    //建立 showToast 方法顯示 Toast 訊息
    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}

