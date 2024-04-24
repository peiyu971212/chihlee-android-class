package com.italkutalk.lab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tvText = findViewById<TextView>(R.id.tv_name)
        val btnMora = findViewById<Button>(R.id.btn_mora)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        tvText.text = "你的名字"
        tvText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30f)
        btnMora.setOnTouchListener { view, motionEvent -> false }
        radioGroup.setOnCheckedChangeListener { group, checkId -> }
    }
}



