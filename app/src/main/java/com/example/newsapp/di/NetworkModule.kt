package com.example.newsapp.di

import android.content.Context
import com.example.newsapp.NewsApp
import com.example.newsapp.data.web.NewApi
import com.example.newsapp.util.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext context: Context) : NewsApp {
        return context as NewsApp
    }

    @Singleton
    @Provides
    fun provideApplicationContext(@ApplicationContext context: Context): Context {
        return context
    }

    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient) : Retrofit {
        return Retrofit.Builder()
            .client(client)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesOkHttpClient() : OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(30L, java.util.concurrent.TimeUnit.SECONDS)
            .writeTimeout(30L, java.util.concurrent.TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun providesNewsApi(retrofit: Retrofit) : NewApi {
        return retrofit.create(NewApi::class.java)
    }

}