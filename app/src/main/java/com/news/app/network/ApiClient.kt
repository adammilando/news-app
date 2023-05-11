package com.news.app.network

import com.news.app.model.NewsModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {
    @GET("top-headlines")
    suspend fun fetchNew(
        @Query("apiKey") apiKey:String,
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("q") query: String,
        @Query("page") page: Int
    ) :NewsModel
}