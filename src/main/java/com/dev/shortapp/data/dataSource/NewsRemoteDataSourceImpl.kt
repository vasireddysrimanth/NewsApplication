package com.dev.shortapp.data.dataSource

import com.dev.shortapp.data.api.NewsApi
import com.dev.shortapp.data.entity.NewsResponse
import retrofit2.Response
import javax.inject.Inject

class NewsRemoteDataSourceImpl @Inject constructor(
    private val newsApi: NewsApi
) :NewsRemoteDataSource{
    override suspend fun getALlNews(country: String): Response<NewsResponse> {
        return newsApi.getALlNews(country)
    }
}