package com.example.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegisterActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "RegisterActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        Log.d(TAG, "onCreate: Activity 已創建")

        val tvSingIn = findViewById<TextView>(R.id.tv_sign_in)
        tvSingIn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("test", "test value")
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: Activity 即將可見")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: Activity 已可見，並開始與使用者互動")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: Activity 即將暫停，但仍然可見（部分）")
        // 通常在這裡儲存持久化的資料或釋放不需要的資源
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: Activity 已不可見")
        // 通常在這裡釋放不再需要的資源
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: Activity 即將銷毀")
    }
}