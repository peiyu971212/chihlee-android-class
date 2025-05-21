package com.example.api

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.gson.Gson
import okhttp3.Call
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import retrofit2.Callback
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val tvText = findViewById<TextView>(R.id.tv_text)
        val btnCallApi = findViewById<Button>(R.id.btn_call_api)
        val btnPostCallApi = findViewById<TextView>(R.id.btn_post_api)

        //序列化
//        val myObject = MyObject()
//        myObject.num = 123
//        myObject.str = "abc"
//        val json = Gson().toJson(myObject)
//
//        Log.d("TAG", "onCreate: $json")

        //反序列化
//        val json = "{\"num\":456,\"str\":\"efg\"}"
//        val myObject = Gson().fromJson(json,MyObject::class.java)
//        Log.d("TAG", "onCreate num: ${myObject.num}")
//        Log.d("TAG", "onCreate str: ${myObject.str}")

        //GET
//        val getReq = Request.Builder()
//            .url("https://jsonplaceholder.typicode.com/comments?postId=1")
//            .build()
//
//        OkHttpClient().newCall(getReq).enqueue(object : Callback {
//            override fun onResponse(call: Call, response: Response) {
//                val json = response.body?.string()
//                Log.d("TAG", "onResponse: $json")
//            }
//
//            override fun onFailure(call: Call, e: IOException) {
//                Log.d("TAG", "onFailure: ")
//            }
//        })
//
//        //POST
//        val type = "application/json; charset=utf-8".toMediaTypeOrNull()
//        val params = "{\"title\":\"123\",\"body\":\"abc\",\"userId\":1}"
//        val body = params.toRequestBody(type)
//
//        val req = Request.Builder()
//            .url("https://jsonplaceholder.typicode.com/posts")
//            .post(body)
//            .build()
//
//        OkHttpClient().newCall(req).enqueue(object : Callback {
//            override fun onResponse(call: Call, response: Response) {
//                val json = response.body?.string()
//                Log.d("TAG", "onResponse: $json")
//            }
//
//            override fun onFailure(call: Call, e: IOException) {
//            }
//        })

        btnCallApi.setOnClickListener {
            val apiServer = AppClientManager.client.create(PostsApi::class.java)
            apiServer.getPosts().enqueue(object : Callback<List<Posts>> {
                override fun onResponse(
                    call: retrofit2.Call<List<Posts>>,
                    response: retrofit2.Response<List<Posts>>
                ) {
                    val list = response.body()
                    if (list != null) {
                        tvText.text = list[0].title
                    }
                }

                override fun onFailure(call: retrofit2.Call<List<Posts>>, t: Throwable) {
                    TODO("Not yet implemented")
                    Log.d("TAG", "onResponse onFailure: ")
                }
            })
        }

        btnPostCallApi.setOnClickListener {
            val apiServer = AppClientManager.client.create(PostsApi::class.java)
            var body = PostsBody("123", "abc", 1, 101)
            apiServer.postPosts(body).enqueue(object : Callback<Posts> {
                override fun onResponse(
                    call: retrofit2.Call<Posts>,
                    response: retrofit2.Response<Posts>
                ) {
                    tvText.text = response.body().toString()
                }
                override fun onFailure(call: retrofit2.Call<Posts>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
        }
    }
}