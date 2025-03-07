package com.example.newsapp.domain.repository

import com.example.newsapp.data.response.NewsResponse

interface NewsRepository {

    suspend fun getNews(
        language: String,
        text: String?,
        country: String?,
    ): NewsResponse
}