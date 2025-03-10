package com.example.newsapp.data.response

import com.example.newsapp.data.model.News

data class NewsResponse(
    val available: Int,
    val news: List<News>,
    val number: Int,
    val offset: Int
)