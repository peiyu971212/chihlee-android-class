package com.example.api

import com.example.api.data.PostRequest
import com.example.api.data.PostResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("/posts")
    fun getPostsResponse(): Call<List<PostResponse>>

    @POST("/posts")
    fun postPosts(@Body body: PostRequest): Call<PostResponse>
}