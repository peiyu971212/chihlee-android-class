package com.example.a20240315_game_advanced

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //將變數與 XML 元件綁定
        val ed_name = findViewById<EditText>(R.id.ed_name)
        val tv_text = findViewById<TextView>(R.id.tv_text)
//        快捷鍵ctrl+/ -> 註解
//        請綁定元件！！
//        val btn_scissor =
//        val btn_stone =
//        val btn_paper =
//        val btn_mora =
//        val tv_name =
//        val tv_winner =
//        val tv_mmora =
//        val tv_cmora =

//        建立btn_mora setOnClickListener

    }
}