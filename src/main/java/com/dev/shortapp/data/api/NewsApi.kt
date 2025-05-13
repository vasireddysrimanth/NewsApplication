package com.dev.shortapp.data.api

import com.dev.shortapp.data.ApiConstants
import com.dev.shortapp.data.entity.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("v2/top-headlines")
    suspend fun getALlNews(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String =ApiConstants.YOUR_APY_KEY,
    ): Response<NewsResponse>
}