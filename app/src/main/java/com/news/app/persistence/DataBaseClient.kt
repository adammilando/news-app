package com.news.app.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.news.app.model.ArticleModel
import com.news.app.news.NewsDoa
import com.news.app.utils.TypeConverter

@Database(
    entities = [ArticleModel::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(TypeConverter::class)
abstract class DataBaseClient: RoomDatabase() {
    abstract val newsDoa: NewsDoa
}