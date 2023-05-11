package com.news.app.Model

data class NewsModel(
    val status: String?,
    val totalResults: Int?,
    val articles: List<ArticleModel>
)
