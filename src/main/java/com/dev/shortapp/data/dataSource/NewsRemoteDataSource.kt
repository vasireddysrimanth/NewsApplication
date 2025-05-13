package com.dev.shortapp.data.dataSource

import com.dev.shortapp.data.entity.NewsResponse
import retrofit2.Response

interface NewsRemoteDataSource {
    suspend fun getALlNews(country: String): Response<NewsResponse>
}