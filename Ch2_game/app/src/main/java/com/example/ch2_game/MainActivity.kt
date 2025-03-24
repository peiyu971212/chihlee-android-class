package com.example.ch2_game

import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //將變數與 XML 元件綁定
        val editName = findViewById<EditText>(R.id.editName)
        val tvHint = findViewById<TextView>(R.id.tvHint)
        val btnScissor = findViewById<RadioButton>(R.id.btnScissor)
        val btnStone = findViewById<RadioButton>(R.id.btnStone)
        val btnPaper = findViewById<RadioButton>(R.id.btnPaper)
        val tvName = findViewById<TextView>(R.id.tvName)
        val tvWinner = findViewById<TextView>(R.id.tvWinner)
        val tvMe = findViewById<TextView>(R.id.tvMe)
        val tvComputer = findViewById<TextView>(R.id.tvComputer)
        val btnStart = findViewById<Button>(R.id.btnStart)

//        tvName.text = "你的名字"
//        tvName.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30f)
        btnStart.setOnClickListener {
            // 當按下按鈕會執行的區塊
//            tvName.text = "你的名字"
            tvName.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30f)

        }
    }
}