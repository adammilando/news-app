package com.news.app.ui.bookmark

import androidx.lifecycle.ViewModel
import com.news.app.news.NewsRepository
import org.koin.dsl.module

val bookmarkViewModel = module {
    factory { BookmarkViewModel(get()) }
}

class BookmarkViewModel (
    val repository: NewsRepository
        ): ViewModel(){
    val title = "Bookmarked News"
}