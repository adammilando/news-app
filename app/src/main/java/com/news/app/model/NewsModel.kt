package com.news.app.model

data class NewsModel(
    val status: String?,
    val totalResults: Int?,
    val articles: List<ArticleModel>
)
