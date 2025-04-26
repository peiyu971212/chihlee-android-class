package com.example.login

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        val tvSingIn = findViewById<TextView>(R.id.tv_sign_in)
        tvSingIn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("test","test value")
            startActivity(intent)
        }
    }
}