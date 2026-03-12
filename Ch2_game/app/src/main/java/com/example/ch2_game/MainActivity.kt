package com.example.ch2_game

import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //將變數與 XML 元件綁定
        val editName = findViewById<EditText>(R.id.edt_name)
        val tvHint = findViewById<TextView>(R.id.tv_hint)
        val btnScissor = findViewById<RadioButton>(R.id.rb_scissor)
        val btnStone = findViewById<RadioButton>(R.id.rb_stone)
        val btnPaper = findViewById<RadioButton>(R.id.rb_paper)
        val tvName = findViewById<TextView>(R.id.tv_name)
        val tvWinner = findViewById<TextView>(R.id.tv_winner)
        val tvMe = findViewById<TextView>(R.id.tv_me)
        val tvComputer = findViewById<TextView>(R.id.tv_computer)
        val btnStart = findViewById<Button>(R.id.btn_start)

//        tvName.text = "你的名字"
//        tvName.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30f)
        btnStart.setOnClickListener {
            // 當按下按鈕會執行的區塊
//            tvName.text = "你的名字"
            tvName.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30f)

        }
    }
}