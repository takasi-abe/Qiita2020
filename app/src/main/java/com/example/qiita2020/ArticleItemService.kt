package com.example.qiita2020

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticleItemService {
    // 特に RxJava 等は使わず Retrofit 標準のコールバックで結果を受け取る
    @GET("items")
    fun items(
        @Query("page") page: Int,
        @Query("par_page") perPage: Int
    ): Call<List<Article>>
}