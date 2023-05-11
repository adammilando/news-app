package com.news.app.persistence

import android.app.Application
import androidx.room.Room
import com.news.app.news.NewsDoa
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    single { provideDatabse(androidApplication()) }
    single { provideArticle(get()) }
}

fun provideDatabse(application: Application): DataBaseClient{
    return Room.databaseBuilder(
        application,
        DataBaseClient::class.java,
        "NewsApp.db"
    ).fallbackToDestructiveMigration()
        .build()
}

fun provideArticle(dataBaseClient: DataBaseClient): NewsDoa{
    return dataBaseClient.newsDoa
}