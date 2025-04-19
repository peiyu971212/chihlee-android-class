package com.example.toast

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //將變數與 XML 元件綁定
        val btnToast = findViewById<Button>(R.id.btn_toast)
        val btnCustom = findViewById<Button>(R.id.btn_custom)
        val btnSnackBar = findViewById<Button>(R.id.btn_snackbar)
        val btnDialog1 = findViewById<Button>(R.id.btn_dialog1)
        val btnDialog2 = findViewById<Button>(R.id.btn_dialog2)
        val btnDialog3 = findViewById<Button>(R.id.btn_dialog3)

        // Button 點擊事件
        btnToast.setOnClickListener {
            Toast.makeText(this, "預設 Toast", Toast.LENGTH_LONG).show()
        }

        btnCustom.setOnClickListener {
            //宣告 Toast
            val toast = Toast(this)
            //Toast 在畫面中顯示位置
            toast.setGravity(Gravity.BOTTOM, 0, 50)

            //Toast 在畫面中顯示的持續時間
            toast.duration = Toast.LENGTH_SHORT
            //放入自定義的畫面 custom_toast.xml
            toast.view =
                layoutInflater.inflate(R.layout.custom_toast, null)
            //顯示於螢幕
            toast.show()
        }

        // snackbar
        btnSnackBar.setOnClickListener {
            //建立 Snackbar 物件
            Snackbar.make(it, "按鈕式 Snackbar", Snackbar.LENGTH_SHORT)
                .setAction("按鈕") {
                    Toast.makeText(this, "已回應", Toast.LENGTH_LONG).show()
                }.show()
        }

        // dialog1
        btnDialog1.setOnClickListener {
            //建立 AlertDialog 物件
            AlertDialog.Builder(this)
                .setTitle("按鈕式 AlertDialog")
                .setMessage("AlertDialog 內容")
                .setNeutralButton("左按鈕") { dialog, which ->
                    Toast.makeText(this, "左按鈕", Toast.LENGTH_LONG).show() //執行 showToast 方法
                }
                .setNegativeButton("中按鈕") { dialog, which ->
                    Toast.makeText(this, "中按鈕", Toast.LENGTH_LONG).show() //執行 showToast 方法
                }
                .setPositiveButton("右按鈕") { dialog, which ->
                    Toast.makeText(this, "右按鈕", Toast.LENGTH_LONG).show() //執行 showToast 方法
                }.show()
        }


        //建立要顯示在的列表上的字串
        val item = arrayOf("選項 1", "選項 2", "選項 3", "選項 4", "選項 5")
        btnDialog2.setOnClickListener {
            //建立 AlertDialog 物件
            AlertDialog.Builder(this)
                .setTitle("列表式 AlertDialog")
                .setItems(item) { dialogInterface, i ->
                    Toast.makeText(this, "你選的是${item[i]}", Toast.LENGTH_LONG).show() //執行 showToast 方法
                }.show()
        }

        btnDialog3.setOnClickListener {
            var position = 0
            //建立 AlertDialog 物件
            AlertDialog.Builder(this)
                .setTitle("單選式 AlertDialog")
                .setSingleChoiceItems(item, 0) { dialogInterface, i ->
                    position = i
                }
                .setPositiveButton("確定") { dialog, which ->
                    Toast.makeText(this, "你選的是${item[position]}", Toast.LENGTH_LONG).show() //執行 showToast 方法
                }.show()
        }
    }
}