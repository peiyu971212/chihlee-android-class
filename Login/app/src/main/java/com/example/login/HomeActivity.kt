package com.example.login

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        val tvHello = findViewById<TextView>(R.id.tv_hello)
//        val data = intent.getStringExtra("email")
//        tvHello.text = "Hello $data !"
        intent?.extras?.let {
            val email = it.getString("email")
            val name = it.getString("name")
            tvHello.text = "Hello $name, $email !"
        }
    }
}