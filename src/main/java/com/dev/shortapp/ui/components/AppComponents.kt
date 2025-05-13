package com.dev.shortapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.dev.shortapp.R
import com.dev.shortapp.data.entity.Article
import com.dev.shortapp.data.entity.NewsResponse
import com.dev.shortapp.ui.theme.Purple40

@Composable
fun Loader(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(6.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(
            modifier = modifier
                .size(50.dp)
                .padding(10.dp),
            color = Purple40
        )
    }
}


@Composable
fun NewsList(modifier: Modifier = Modifier,response :NewsResponse) {
    LazyColumn {
        items(response.articles){article->
                NormalTextComponent(textValue = article.title ?: "No Title  ")
        }
    }
}

@Composable
fun NormalTextComponent(modifier: Modifier = Modifier,textValue:String) {
    Text(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp),
        text = textValue,
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.Monospace,
            color = Purple40
        )
    )
    
}

@Composable
fun HeadingText(modifier: Modifier = Modifier,textValue: String) {
    Text(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp),
        text = textValue,
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium,
        )
    )
}

@Composable
fun NewsRowComponent(page :Int,article: Article,modifier: Modifier = Modifier) {
   Column(modifier
       .fillMaxSize()
       .padding(8.dp)
       .background(Color.White)) {
       AsyncImage(
           modifier = modifier
               .fillMaxWidth()
               .height(240.dp)
               .padding(start = 10.dp),
              model = article.urlToImage,
                contentDescription = null,
                placeholder = painterResource(R.drawable.ic_launcher_foreground),
                contentScale = ContentScale.Fit
       )
       Spacer(modifier = modifier.size(20.dp))
       HeadingText(textValue = article.title ?: "No Title")
       Spacer(modifier = modifier.size(10.dp))
         NormalTextComponent(textValue = article.description ?: "No Description")
         Spacer(modifier = modifier.padding(end = 36.dp).weight(1f))
         AuthorDetails(
              authoName = article.author ?: "No Author",
              authorSource = article.source.name ?: "No Source"
         )
   }
}

@Composable
fun AuthorDetails(modifier: Modifier = Modifier,authoName :String = " ",authorSource :String = " ") {
    Row(modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp)
        ){
        Text(text = authoName)
        Spacer(modifier = modifier.weight(1f))
        Text(text = authorSource)

    }
}