package com.example.a20240308_game_listener_1

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
        val btn_scissor = findViewById<RadioButton>(R.id.btn_scissor)
        val btn_stone = findViewById<RadioButton>(R.id.btn_stone)
        val btn_paper = findViewById<RadioButton>(R.id.btn_paper)
        val btn_mora = findViewById<Button>(R.id.btn_mora)
        val tv_name = findViewById<TextView>(R.id.tv_name)
        val tv_winner = findViewById<TextView>(R.id.tv_winner)
        val tv_mmora = findViewById<TextView>(R.id.tv_mmora)
        val tv_cmora = findViewById<TextView>(R.id.tv_cmora)

        btn_mora.setOnClickListener {
            //判斷 EditText 的字數是否小於一，若成立則無法進行猜拳
            if (ed_name.length() < 1) {
                tv_text.text = "請輸入玩家姓名"
                return@setOnClickListener
            }

            //取出 EditText 文字作為玩家姓名並用變數儲存
            val playerName = ed_name.text
            //顯示玩家姓名
            tv_name.text = "名字\n$playerName"  // \n 換行，在字串中使用變數用$

            //將玩家出拳結果對應成字串並用變數儲存
            val playerMoraText = when {
                btn_scissor.isChecked -> "剪刀"
                btn_stone.isChecked -> "石頭"
                else -> "布"
            }

            //顯示出拳結果
            tv_mmora.text = "我方出拳\n$playerMoraText"
        }


    }
}