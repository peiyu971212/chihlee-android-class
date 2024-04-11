package com.example.activity2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSwitch = findViewById<Button>(R.id.btn_switch)

        btnSwitch.setOnTouchListener() {
            val intent=Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }

    }
}