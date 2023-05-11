package com.news.app.news

import com.news.app.BuildConfig
import com.news.app.model.NewsModel
import com.news.app.network.ApiClient
import org.koin.dsl.module

val repositoryModule = module {
    factory { NewsRepository(get()) }
}

class NewsRepository(
    private val api: ApiClient
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
}