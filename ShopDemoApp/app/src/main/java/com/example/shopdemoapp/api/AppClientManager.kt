package com.example.shopdemoapp.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppClientManager {
    private val retrofit: Retrofit
    private val okHttpClient = OkHttpClient()
    private val local = "http://192.168.1.102:3001/"

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(local)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    companion object {
        private val manager = AppClientManager()
        val client: Retrofit
            get() = manager.retrofit
    }
}