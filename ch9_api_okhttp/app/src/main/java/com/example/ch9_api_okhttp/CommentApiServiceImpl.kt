package com.example.ch9_api_okhttp

import com.google.gson.Gson
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody

class CommentApiServiceImpl: ApiService {
    private val client = OkHttpClient()
    private val gson = Gson()

    override fun getCommentsByPostId(postId: Int, callback: Callback) {
        // 動態組裝網址，帶入學生的參數 postId
        val url = "https://jsonplaceholder.typicode.com/comments?postId=$postId"
        val getReq = Request.Builder()
            .url(url)
            .build()
        client.newCall(getReq).enqueue(callback)
    }

    override fun createPost(
        postRequest: PostRequest,
        callback: Callback
    ) {
        val url = "https://jsonplaceholder.typicode.com/posts"
        val type = "application/json; charset=utf-8".toMediaTypeOrNull()
        val jsonString = gson.toJson(postRequest)
        val body = jsonString.toRequestBody(type)

        val request = Request.Builder()
            .url(url)
            .post(body)
            .build()

        client.newCall(request).enqueue(callback)
    }
}