package com.example.qiita2020

import android.util.Log
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class GetArticle {

    //Moshiをビルド
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val baseApiUrl = "https://qiita.com/api/v2/"

    private val httpClient = OkHttpClient.Builder().build()
    private val retrofit = Retrofit.Builder()
        .baseUrl(baseApiUrl)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .client(httpClient)
        .build()

    //記事を取得する際の条件の指定
    var articleItemService = retrofit.create(ArticleItemService::class.java)


    fun getQiitaArticle(callback: (List<Article>) -> Unit) {
        articleItemService.items(page = 1, perPage = 2).enqueue(object : Callback<List<Article>> {

            // レスポンスが帰ってきた場合
            override fun onResponse(call: Call<List<Article>>, response: Response<List<Article>>) {
                response.let {

                    //レスポンスが正しく帰ってきた場合
                    if (response.isSuccessful) {
                        Log.d("getArticleList", "success")

                        response.body()?.let {
                            callback(it)
                        }
                    }
                }
            }

            // レスポンスが帰ってこなかった場合
            override fun onFailure(call: Call<List<Article>>, t: Throwable) {
                Log.d("getQiitaArticle", "failed: $t")
            }
        })

    }

}