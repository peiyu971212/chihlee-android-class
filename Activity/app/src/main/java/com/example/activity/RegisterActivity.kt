package com.example.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class RegisterActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "RegisterActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        Log.d(TAG, "onCreate:")
        val tvSignIn = findViewById<TextView>(R.id.tv_sign_in)
        val btnLogin = findViewById<Button>(R.id.btn_login)
        tvSignIn.setOnClickListener {
            //傳遞單筆資料
            val intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("Register", "Intent to Register")
            startActivity(intent)

            //傳遞多筆資料
            //宣告Bundle
            val bundle = Bundle()
            //把hello@example.com放入Bundle
            bundle.putString("email", "hello@example.com")
            //把123456789放入Bundle
            bundle.putString("password", "123456789")
            //宣告Intent
            val loginIntent = Intent(this, LoginActivity::class.java)
            //夾帶Bundle
            loginIntent.putExtras(bundle)
            //發送Intnet
            startActivity(intent)

            //  返回資料至上一個畫面
            val intent2 = Intent(this, LoginActivity::class.java)
            startActivityForResult(intent, 1)

        }

        btnLogin.setOnClickListener {
            //產生Builder物件
            val builder = AlertDialog.Builder(this)
            //呼叫setMessage方法設定顯示文字
            builder.setMessage("Hello")
            //顯示對話框
            builder.show()
        }
    }

    override fun onStart() {
        Log.d(TAG, "onStart: ")
        super.onStart()
    }

    override fun onResume() {
        Log.d(TAG, "onResume: ")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG, "onPause: ")
        super.onPause()
    }

    override fun onStop() {
        Log.d(TAG, "onStop: ")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy: ")
        super.onDestroy()
    }
}