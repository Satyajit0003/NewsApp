package com.example.newsapp.data.web

import com.example.newsapp.data.response.NewsResponse
import com.example.newsapp.util.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewApi {
    @GET("search-news")
    suspend fun getNews(
        @Query("country") country: String?,
        @Query("language") language: String,
        @Query("text") text: String?,
        @Query("news-sources") newsSources: String? = "https://www.bbc.co.uk",
        @Query("api-key") apiKey: String = API_KEY,
    ): Response<NewsResponse>
}