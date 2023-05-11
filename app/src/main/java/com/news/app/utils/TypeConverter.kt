package com.news.app.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.news.app.model.Source

object TypeConverter {
    @TypeConverter
    @JvmStatic
    fun toSource(value: String?):Source{
        val modelType = object : TypeToken<Source>() {}.type
        return Gson().fromJson(value, modelType)
    }

    @TypeConverter
    @JvmStatic
    fun fromSource(source: Source):String{
        val gson = Gson()
        return gson.toJson(source)
    }
}