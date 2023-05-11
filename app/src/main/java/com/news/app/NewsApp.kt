package com.news.app

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.news.app.network.networkModule
import com.news.app.news.repositoryModule
import com.news.app.persistence.databaseModule
import com.news.app.ui.bookmark.bookmarkModule
import com.news.app.ui.bookmark.bookmarkViewModel
import com.news.app.ui.detail.detailModule
import com.news.app.ui.detail.detailViewModule
import com.news.app.ui.home.homeModule
import com.news.app.ui.home.homeViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class NewsApp: Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        Timber.e("Run base application")

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@NewsApp)
            modules(
                networkModule,
                repositoryModule,
                homeViewModel,
                homeModule,
                bookmarkViewModel,
                bookmarkModule,
                databaseModule,
                detailViewModule,
                detailModule
            )
        }
    }
}