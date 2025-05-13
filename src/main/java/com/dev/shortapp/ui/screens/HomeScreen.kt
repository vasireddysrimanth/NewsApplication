package com.dev.shortapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dev.shortapp.ui.components.Loader
import com.dev.shortapp.ui.components.NewsRowComponent
import com.dev.shortapp.ui.components.NewsList
import com.dev.shortapp.ui.viewmodel.NewsViewModel
import com.dev.utilities.common.DataStatus

@Composable
fun HomeScreen(modifier: Modifier = Modifier,
               newsViewModel: NewsViewModel = hiltViewModel()
) {

    val newsState by newsViewModel.news.collectAsState()

    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        // Total pages, this will be dynamic once data is loaded
        val news = (newsState as? DataStatus.Success)?.data
        news?.articles?.size ?: 0
    }

    VerticalPager(
        state = pagerState,
        modifier = modifier.fillMaxSize(),
        pageSize = PageSize.Fill,
        pageSpacing = 8.dp,
    ) { page: Int ->
        when (newsState) {
            is DataStatus.Loading -> {
                Loader()
            }

            is DataStatus.Success -> {
                val news = (newsState as DataStatus.Success).data
                if (news.articles.isNotEmpty()) {
                    NewsRowComponent(page, news.articles[page])
                }
            }

            is DataStatus.Error -> {
                // Handle error case here, maybe show error message
            }

            is DataStatus.Empty -> {
                // Handle empty case
            }
        }
    }
}


    @Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    )
}