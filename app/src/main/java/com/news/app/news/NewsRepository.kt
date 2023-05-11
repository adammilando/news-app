package com.news.app.news

import com.news.app.BuildConfig
import com.news.app.model.ArticleModel
import com.news.app.model.NewsModel
import com.news.app.network.ApiClient
import org.koin.dsl.module

val repositoryModule = module {
    factory { NewsRepository(get(), get()) }
}

class NewsRepository(
    private val api: ApiClient,
    val db: NewsDoa
) {
    suspend fun fetch(
        category: String,
        query: String,
        page: Int
    ): NewsModel{
        return api.fetchNew(
            BuildConfig.API_KEY,
            "us",
            category,
            query,
            page
        )
    }

    suspend fun find(articleModel: ArticleModel) = db.find(articleModel.publishedAt)

    suspend fun save(articleModel: ArticleModel) {
        db.save(articleModel)
    }

    suspend fun delete(articleModel: ArticleModel){
        db.delete(articleModel)
    }
}