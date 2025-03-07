package com.example.newsapp.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.data.model.News
import com.example.newsapp.domain.usecase.GetNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    val getNewsUseCase: GetNewsUseCase
): ViewModel() {

    init {
        viewModelScope.launch {
            val result = getNews()
            result.forEach {
                Log.d("News", it.title)
            }
        }
    }

    suspend fun getNews() : List<News> {
        return getNewsUseCase.invoke("en", null, null).news
    }
}