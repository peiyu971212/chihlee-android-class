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
//        btnStart.setOnClickListener {
//            // 當按下按鈕會執行的區塊
//            tvName.text = "你的名字"
//            tvName.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30f)
//        }

        btnStart.setOnClickListener {
            //取出 EditText 文字作為玩家姓名並用變數儲存
            val playerName = editName.text

            //亂數產生介於 0~1 之間不含 1 的小數，乘 3 變成 0~2 作為電腦的出拳
            val computerRandom = (Math.random() * 3).toInt()

            val playerResult = when {
                btnScissor.isChecked -> "剪刀"
                btnStone.isChecked -> "石頭"
                else -> "布"
            }

            //將電腦出拳結果對應成字串並用變數儲存
            val computerResult = when (computerRandom) {
                0 -> "剪刀"
                1 -> "石頭"
                else -> "布"
            }

            val playerResult2 = if (btnScissor.isChecked) {
                "剪刀"
            } else if (btnStone.isChecked) {
                "石頭"
            } else {
                "布"
            }

            //顯示玩家姓名與雙方出拳結果
            tvName.text = "名字\n$playerName"
            tvMe.text = "我方出拳\n$playerResult"
            tvComputer.text = "電腦出拳\n$computerResult"

            //用三個判斷式決定勝負並顯示猜拳結果
            when {
                btnScissor.isChecked && computerRandom == 2 || btnStone.isChecked && computerRandom == 0 ||
                        btnPaper.isChecked && computerRandom == 1 -> {
                    tvWinner.text = "勝利者\n$playerName"
                    tvHint.text = "恭喜你獲勝了！！！"
                }

                btnScissor.isChecked && computerRandom == 1 ||
                        btnStone.isChecked && computerRandom == 2 ||
                        btnPaper.isChecked && computerRandom == 0 -> {
                    tvWinner.text = "勝利者\n 電腦"
                    tvHint.text = "可惜，電腦獲勝了！"
                }

                else -> {
                    tvWinner.text = "勝利者\n 平手"
                    tvHint.text = "平局，請再試一次！"
                }
            }
        }

    }
}