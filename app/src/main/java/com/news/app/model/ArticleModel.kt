package com.news.app.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "article_tb")
data class ArticleModel(
    val source: Source?,
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    @PrimaryKey(autoGenerate = false)
    val publishedAt: String,
    val content: String?
) : Serializable
