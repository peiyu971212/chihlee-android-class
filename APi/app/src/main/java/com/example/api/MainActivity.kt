package com.example.api

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.api.data.PostRequest
import com.example.api.data.PostResponse
import com.google.gson.Gson
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import org.w3c.dom.Comment
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvText = findViewById<TextView>(R.id.tv_text)
        val btnGetApi = findViewById<Button>(R.id.btn_get_api)
        val btnPostCallApi = findViewById<TextView>(R.id.btn_post_api)

        //GET
        val getReq = Request.Builder()
            .url("https://jsonplaceholder.typicode.com/comments?postId=1")
            .build()

        OkHttpClient().newCall(getReq).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                val json = response.body?.string()
                Log.d("TAG", "onResponse: $json")
            }

            override fun onFailure(call: Call, e: IOException) {
                Log.d("TAG", "onFailure: ${e.message}")
            }
        })

        //POST
        val type = "application/json; charset=utf-8".toMediaTypeOrNull() // 定義 JSON 媒體類型
        val gson = Gson() // 創建 Gson 實例
        val postRequest = PostRequest(
            userId = 1,
        )
        val jsonString = gson.toJson(postRequest) // 將 PostRequest 對象轉換為 JSON 字串
        val body = jsonString.toRequestBody(type) // 將 JSON 字串轉換為 RequestBody

        val req = Request.Builder()
            .url("https://jsonplaceholder.typicode.com/posts")
            .post(body)
            .build()

        OkHttpClient().newCall(req).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                val json = response.body?.string()
                Log.d("TAG", "onResponse post: $json")
            }

            override fun onFailure(call: Call, e: IOException) {
            }
        })

        // api response display on UI
        btnGetApi.setOnClickListener {
            val apiServer = AppClientManager.client.create(ApiService::class.java)
            apiServer.getPostsResponse().enqueue(object :
                retrofit2.Callback<List<PostResponse>> {
                override fun onResponse(
                    call: retrofit2.Call<List<PostResponse>>,
                    response: retrofit2.Response<List<PostResponse>>
                ) {
                    val list = response.body()
                    if (list != null) {
                        tvText.text = list[0].title
                    }
                }

                override fun onFailure(call: retrofit2.Call<List<PostResponse>>, t: Throwable) {
                    Log.d("TAG", "onFailure: fail")
                }

            })
        }

        btnPostCallApi.setOnClickListener {
            val apiServer = AppClientManager.client.create(ApiService::class.java)
            var body = PostRequest(1)
            apiServer.postPosts(body).enqueue(object : retrofit2.Callback<PostResponse> {
                override fun onResponse(
                    call: retrofit2.Call<PostResponse>,
                    response: retrofit2.Response<PostResponse>
                ) {
                    tvText.text = response.body().toString()
                }

                override fun onFailure(call: retrofit2.Call<PostResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
        }
    }
}