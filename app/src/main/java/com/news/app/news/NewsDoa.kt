package com.news.app.news

import androidx.lifecycle.LiveData
import androidx.room.*
import com.news.app.model.ArticleModel

@Dao
interface NewsDoa {

    @Query("SELECT * FROM article_tb")
    fun findAll(): LiveData<List<ArticleModel>>

    @Query("SELECT COUNT(*) FROM article_tb WHERE publishedAt=:published")
    suspend fun find(published: String): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(articleModel: ArticleModel)

    @Delete
    suspend fun delete(articleModel: ArticleModel)
}
