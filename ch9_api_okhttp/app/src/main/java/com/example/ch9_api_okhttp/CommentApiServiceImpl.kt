package com.example.ch9_api_okhttp

import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request

class CommentApiServiceImpl: ApiService {
    private val client = OkHttpClient()

    override fun getCommentsByPostId(postId: Int, callback: Callback) {
        // 動態組裝網址，帶入學生的參數 postId
        val url = "https://jsonplaceholder.typicode.com/comments?postId=$postId"
        val getReq = Request.Builder()
            .url(url)
            .build()
        client.newCall(getReq).enqueue(callback)
    }
}