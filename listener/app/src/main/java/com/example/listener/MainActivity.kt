package com.example.listener

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.MotionEvent
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvText1 = findViewById<TextView>(R.id.tv_text1)
        val tvText2 = findViewById<TextView>(R.id.tv_text2)
        val btn = findViewById<Button>(R.id.btn)

        tvText1.text = getString(R.string.tv_Hello)
        tvText2.text = "你好"
        tvText1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40f)

        btn.setOnClickListener {
            //按鈕點擊監聽
            Log.d("MainActivity", "onCreate: press me!!") //點擊下方Logcat看log
        }
//
//        btn.setOnLongClickListener {
//            Log.d("MainActivity", "onCreate: Long Press!!")
//            false//回傳boolean，false:長按完後，觸發setOnClickListener；true:長按完後，不觸發setOnClickListener
//        }

        btn.setOnTouchListener { view, motionEvent ->
            when (motionEvent.action) {
                MotionEvent.ACTION_DOWN -> {
                    //按下
                    Log.d("MainActivity", "touch ACTION_DOWN")
                }

                MotionEvent.ACTION_MOVE -> {
                    //滑動
                    Log.d("MainActivity", "touch ACTION_MOVE")
                }
            }

            false//回傳boolean，false:長按完後，觸發setOnClickListener；true:長按完後，不觸發setOnClickListener
        }

    }
}