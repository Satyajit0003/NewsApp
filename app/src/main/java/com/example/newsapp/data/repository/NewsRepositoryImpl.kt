package com.example.newsapp.data.repository

import com.example.newsapp.data.response.NewsResponse
import com.example.newsapp.data.web.NewApi
import com.example.newsapp.domain.repository.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    val api: NewApi
): NewsRepository {

    override suspend fun getNews(language: String, text: String?, country: String?): NewsResponse {
        val response = api.getNews(country,language,text)
        return response.body()!!
    }
}