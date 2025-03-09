package com.example.newsapp.di

import com.example.newsapp.data.repository.NewsRepositoryImpl
import com.example.newsapp.data.web.NewApi
import com.example.newsapp.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideNewsRepository(api: NewApi): NewsRepository {
        return NewsRepositoryImpl(api)
    }

}