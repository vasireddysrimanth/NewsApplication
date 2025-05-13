package com.dev.shortapp.ui.repository

import com.dev.shortapp.data.dataSource.NewsRemoteDataSource
import com.dev.shortapp.data.entity.NewsResponse
import com.dev.utilities.common.DataStatus
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsRemoteDataSource: NewsRemoteDataSource
){

    //create  a flow for get All News
    suspend fun getAllNews(country: String): Flow<DataStatus<NewsResponse>> = flow {
        emit(DataStatus.Loading)

        val response = newsRemoteDataSource.getALlNews(country)
        if (response.isSuccessful) {
            val body = response.body()
            if (body != null && body.articles.isNotEmpty()) {
                emit(DataStatus.Success(body))
            } else {
                emit(DataStatus.Empty)
            }
        } else {
            emit(DataStatus.Error("HTTP Error: ${response.code()} ${response.message()}"))
        }
    }.catch { e ->
        emit(DataStatus.Error("Exception: ${e.localizedMessage ?: "Unknown error"}"))
    }

}

