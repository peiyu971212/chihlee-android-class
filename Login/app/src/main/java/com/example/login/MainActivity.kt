package com.example.login

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val btnLogin = findViewById<AppCompatButton>(R.id.btn_login)
        val etEmail = findViewById<EditText>(R.id.et_email)

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString()

//            val intent = Intent(this, HomeActivity::class.java)
//            intent.putExtra("email", email)
//            startActivity(intent)

            val bundle = Bundle()
            bundle.putString("email", "hello@gmail.com")
            bundle.putString("name", "Android")
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }

    }
}