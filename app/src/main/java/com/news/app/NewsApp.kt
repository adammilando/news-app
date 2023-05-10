package com.news.app

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import timber.log.Timber

class NewsApp: Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        Timber.e("Run base application")

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}