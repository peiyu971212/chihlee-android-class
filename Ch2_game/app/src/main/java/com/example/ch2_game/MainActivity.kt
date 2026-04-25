package com.example.ch2_game

import android.os.Bundle
import android.util.TypedValue
import android.view.View
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
//        btnStart.setOnClickListener {
//            // 當按下按鈕會執行的區塊
//            val playerName = editName.text
//            tvName.text = "名字\n$playerName"
//            val playerResult = when {
//                btnScissor.isChecked -> "剪刀"
//                btnStone.isChecked -> "石頭"
//                else -> "布"
//            }
//
//            val computerRandom = (Math.random() * 3).toInt()
//            val computerResult = when (computerRandom) {
//                0 -> "剪刀"
//                1 -> "石頭"
//                else -> "石"
//            }
//
//            tvMe.text = "我方出拳\n$playerResult"
//            tvName.text = "名字\n$playerName"
//            tvComputer.text = "電腦出拳\n$computerResult"
//
//            when {
//                btnScissor.isChecked && computerRandom == 2 || btnStone.isChecked && computerRandom == 0 || btnPaper.isChecked && computerRandom == 1 -> {
//                    tvWinner.text = "勝利者\n$playerName"
//                    tvHint.text = "恭喜你獲勝了！！"
//                }
//
//                btnScissor.isChecked && computerRandom == 1 || btnStone.isChecked && computerRandom == 2 || btnPaper.isChecked && computerRandom == 0 -> {
//                    tvWinner.text = "勝利者\n 電腦"
//                    tvHint.text = "恭喜你獲勝了！！"
//                }
//
//                else -> {
//                    tvWinner.text = "勝利者\n 平手"
//                    tvHint.text = "平手，請再試一次"
//                }
//            }
//        }

        val gameResult= View.OnClickListener {
            val playerName = editName.text
            tvName.text = "名字\n$playerName"
            val playerResult = when {
                btnScissor.isChecked -> "剪刀"
                btnStone.isChecked -> "石頭"
                else -> "布"
            }

            val computerRandom = (Math.random() * 3).toInt()
            val computerResult = when (computerRandom) {
                0 -> "剪刀"
                1 -> "石頭"
                else -> "布"
            }

            tvMe.text = "我方出拳\n$playerResult"
            tvName.text = "名字\n$playerName"
            tvComputer.text = "電腦出拳\n$computerResult"

            when {
                btnScissor.isChecked && computerRandom == 2 || btnStone.isChecked && computerRandom == 0 || btnPaper.isChecked && computerRandom == 1 -> {
                    tvWinner.text = "勝利者\n$playerName"
                    tvHint.text = "恭喜你獲勝了！！"
                }

                btnScissor.isChecked && computerRandom == 1 || btnStone.isChecked && computerRandom == 2 || btnPaper.isChecked && computerRandom == 0 -> {
                    tvWinner.text = "勝利者\n 電腦"
                    tvHint.text = "恭喜你獲勝了！！"
                }

                else -> {
                    tvWinner.text = "勝利者\n 平手"
                    tvHint.text = "平手，請再試一次"
                }
            }
        }
        btnStart.setOnClickListener(gameResult)
    }
}