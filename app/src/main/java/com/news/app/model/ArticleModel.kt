package com.news.app.model

import java.io.Serializable


data class ArticleModel(
    val source: Source?,
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String,
    val content: String?
) : Serializable
