package com.example.ch9_api_okhttp

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView // 加上 lateinit，意思是：等一下再初始化
    private lateinit var commentAdapter: CommentAdapter

    // 宣告介面，並實體化剛剛寫好的 Impl 類別
    private val apiService: ApiService = CommentApiServiceImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // 初始化 RecyclerView 與 Adapter
        recyclerView = findViewById(R.id.recyclerView)
        val btnPostCallApi = findViewById<TextView>(R.id.btn_post)

        recyclerView.layoutManager = LinearLayoutManager(this)
        commentAdapter = CommentAdapter(emptyList())
        recyclerView.adapter = commentAdapter

        val url = "https://jsonplaceholder.typicode.com/comments?postId=1"
        val getReq = Request.Builder()
            .url(url)
            .build()

        // GET
        apiService.getCommentsByPostId(1, object : Callback {
            override fun onFailure(call: Call, e: IOException) {
            }

            override fun onResponse(call: Call, response: Response) {
                response.use {
                    if (!response.isSuccessful) return

                    val jsonResult = response.body?.string() ?: ""

                    // 用 Gson 解析 JSON 陣列
                    val gson = Gson()
                    val itemType = object : TypeToken<List<Comment>>() {}.type
                    val comments: List<Comment> = gson.fromJson(jsonResult, itemType)

                    // 切換回主執行緒更新 RecyclerView
                    runOnUiThread {
                        commentAdapter.updateData(comments)
                    }
                }
            }
        })
//        OkHttpClient().newCall(getReq).enqueue(object : Callback {
//
//            // 狀況 A：網路斷線或伺服器根本連不上
//            override fun onFailure(call: Call, e: IOException) {
//                e.printStackTrace()
//                Log.d("TAG", "onFailure: "+e.message)
//                // 這裡可以跳出 Toast 提示使用者「檢查網路連線」
//            }
//
//            // 狀況 B：伺服器有回應了（不論是成功還是找不到網頁）
//            override fun onResponse(call: Call, response: Response) {
//                response.use {
//                    if (!response.isSuccessful) {
//                        // 伺服器回報錯誤（例如：404 找不到網頁、500 伺服器壞了）
//                        return
//                    }
//
//                    // 成功拿到 JSON 資料！
//                    val jsonResult = response.body?.string()
//                    // 1. jsonResult 拿出來後，下一步就是用 Gson 轉成第三步定義的 Comment 類別。
//                    // 2. 目前是在背景執行緒，如果要用 textView.text = jsonResult 更新畫面，
//                    //    一定要包在 runOnUiThread { ... } 裡面喔！
//                    Log.d("TAG", "onResponse: $jsonResult")
//                    val gson = Gson()
//                    val itemType = object : TypeToken<List<Comment>>() {}.type
//                    val comments: List<Comment> = gson.fromJson(jsonResult, itemType)
//
//                    // 切換回主執行緒更新 RecyclerView
//                    runOnUiThread {
//                        commentAdapter.updateData(comments)
//                    }
//                }
//            }
//        })

        // POST
        btnPostCallApi.setOnClickListener {
            val myPost = PostRequest(userId = 1)
            apiService.createPost(myPost,object : Callback{
                override fun onFailure(call: Call, e: IOException) {
                }

                override fun onResponse(call: Call, response: Response) {
                }

            })
            //POST
//            val type = "application/json; charset=utf-8".toMediaTypeOrNull() // 定義 JSON 媒體類型
//            val gson = Gson() // 創建 Gson 實例
//            val postRequest = PostRequest(
//                userId = 1,
//            )
//            val jsonString = gson.toJson(postRequest) // 將 PostRequest 對象轉換為 JSON 字串
//            val body = jsonString.toRequestBody(type) // 將 JSON 字串轉換為 RequestBody
//
//            val req = Request.Builder()
//                .url("https://jsonplaceholder.typicode.com/posts")
//                .post(body)
//                .build()
//
//            OkHttpClient().newCall(req).enqueue(object : Callback {
//                override fun onResponse(call: Call, response: Response) {
//                    val json = response.body?.string()
//                    Log.d("TAG", "onResponse post: $json")
//                }
//
//                override fun onFailure(call: Call, e: IOException) {
//                    Log.d("TAG", "onFailure: ${e.message}")
//                }
//            })
        }

    }
}