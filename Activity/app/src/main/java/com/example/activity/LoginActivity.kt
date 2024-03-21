package com.example.activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class LoginActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "LoginActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        Log.d(TAG, "onCreate: ")
        //綁定元件
        val tvLogin = findViewById<TextView>(R.id.tv_login)
        val edEmail = findViewById<EditText>(R.id.ed_email)
        val edPassword = findViewById<EditText>(R.id.ed_password)
        //取得intent傳過來的值，name是前一頁的name
        val data = intent.getStringExtra("Register")
        //將取得的資料顯示在TextView
        tvLogin.text = data
        //改變TextView顏色
        tvLogin.setTextColor(Color.parseColor("#ff0000"))

        intent.extras?.let {
            val email = it.getString("email")
            val password = it.getString("password")
            edEmail.setText(email)
            edPassword.setText(password)
        }
    }
}