package com.news.app.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.news.app.Model.CategoryModel
import com.news.app.Model.NewsModel
import com.news.app.news.NewsRepository
import kotlinx.coroutines.launch
import org.koin.dsl.module

val homeViewModel = module {
    factory { HomeViewModel(get()) }
}

class HomeViewModel(
    val repository: NewsRepository
) : ViewModel() {
    val title = "Head Lines"
    val category by lazy { MutableLiveData<String>() }
    val message by lazy { MutableLiveData<String>() }
    val loading by lazy { MutableLiveData<Boolean>() }
    val news by lazy { MutableLiveData<NewsModel>() }

    init {
        category.value = ""
        message.value = null
    }
    fun fetch(){
        viewModelScope.launch {
            loading.value = true
            try {
               val response =  repository.fetch(
                    category.value!!,
                    "",
                    1
                )
                news.value = response
                loading.value = false
            }catch (e: Exception){
                message.value = "Error Happen"
            }
        }
    }
    val categories = listOf<CategoryModel>(
        CategoryModel("","All Category"),
        CategoryModel("business","Business"),
        CategoryModel("entertaiment","Entertainment"),
        CategoryModel("general","General"),
        CategoryModel("health","Health"),
        CategoryModel("science","Science"),
        CategoryModel("sports","Sports"),
        CategoryModel("technology","Technology"),
    )
}