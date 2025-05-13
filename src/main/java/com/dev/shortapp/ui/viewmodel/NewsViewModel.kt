package com.dev.shortapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.shortapp.data.ApiConstants
import com.dev.shortapp.data.entity.NewsResponse
import com.dev.shortapp.ui.repository.NewsRepository
import com.dev.utilities.common.DataStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {

    private val _news = MutableStateFlow<DataStatus<NewsResponse>>(DataStatus.Loading)
    val news = _news.asStateFlow()

    init {
        getAllNews(ApiConstants.COUNTRY)
    }

    fun getAllNews(country: String) {
        viewModelScope.launch {
            newsRepository.getAllNews(country).collectLatest { state ->
                _news.value = state
            }
        }
    }


    companion object {
         const val TAG = "NewsViewModel"
     }
}