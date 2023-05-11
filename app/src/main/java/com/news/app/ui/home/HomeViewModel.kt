package com.news.app.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.news.app.model.CategoryModel
import com.news.app.model.NewsModel
import com.news.app.news.NewsRepository
import kotlinx.coroutines.launch
import org.koin.dsl.module
import kotlin.math.ceil

val homeViewModel = module {
    factory { HomeViewModel(get()) }
}

class HomeViewModel(
    val repository: NewsRepository
) : ViewModel() {
    val title = "Top News"
    val category by lazy { MutableLiveData<String>() }
    val message by lazy { MutableLiveData<String>() }
    val loading by lazy { MutableLiveData<Boolean>() }
    val loadMore by lazy { MutableLiveData<Boolean>() }
    val news by lazy { MutableLiveData<NewsModel>() }

    init {
        category.value = ""
        message.value = null
    }

    var query = ""
    var page = 1
    var pageSize = 1

    fun fetch(){
        viewModelScope.launch {
            if (page > 1 ) loadMore.value = true
            else loading.value = true
            try {
               val response =  repository.fetch(
                    category.value!!,
                    query,
                    page
                )
                news.value = response
                val totalResults: Double = response.totalResults / 20.0
                pageSize = ceil(totalResults).toInt()
                page++
                loading.value = false
                loadMore.value = false
            }catch (e: Exception){
                message.value = "Error Happend"
            }
        }
    }
    val categories = listOf<CategoryModel>(
        CategoryModel("","Headlines"),
        CategoryModel("business","Business"),
        CategoryModel("entertainment","Entertainment"),
        CategoryModel("general","General"),
        CategoryModel("health","Health"),
        CategoryModel("science","Science"),
        CategoryModel("sports","Sports"),
        CategoryModel("technology","Technology"),
    )
}