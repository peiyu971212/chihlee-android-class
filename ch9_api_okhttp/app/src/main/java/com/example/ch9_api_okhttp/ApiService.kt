package com.example.ch9_api_okhttp

interface ApiService {
    // 定義一個方法：獲取特定貼文的留言列表
    // 預期傳入 postId，並在連線成功時回傳 JSON 字串或解析後的結果
    fun getCommentsByPostId(postId: Int, callback: okhttp3.Callback)

    fun createPost(postRequest: PostRequest, callback: okhttp3.Callback)
}

