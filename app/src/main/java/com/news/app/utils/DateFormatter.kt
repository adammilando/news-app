package com.news.app.utils

import java.text.SimpleDateFormat
import java.util.Locale

class DateFormatter {
    fun dateFormat(date: String?) : String{
        return if (date.isNullOrEmpty()) ""
        else{
            val currentFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
            val dateParse = currentFormat.parse(date)
            val toDateFormat = SimpleDateFormat("MM-dd-yyyy", Locale.getDefault())
            toDateFormat.format(dateParse)

        }
    }
}