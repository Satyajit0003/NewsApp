package com.example.newsapp.presentation.home

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen() {
     val viewModel: HomeViewModel = hiltViewModel()
}