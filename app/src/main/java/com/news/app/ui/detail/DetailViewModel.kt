package com.news.app.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.news.app.model.ArticleModel
import com.news.app.news.NewsRepository
import kotlinx.coroutines.launch
import org.koin.dsl.module

val detailViewModule = module{
    factory{DetailViewModel(get())}
}

class DetailViewModel(
    private val repository: NewsRepository
) : ViewModel(){
    val isBookmark by lazy { MutableLiveData<Int>(0) }

    fun find(articleModel: ArticleModel){
        viewModelScope.launch {
            isBookmark.value = repository.find(articleModel)
        }
    }

    fun bookmark(articleModel: ArticleModel){
        viewModelScope.launch {
            if (isBookmark.value == 0) repository.save(articleModel)
            else repository.delete(articleModel)
            find(articleModel)
        }
    }
}