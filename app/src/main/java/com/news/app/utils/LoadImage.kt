package com.news.app.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.news.app.R

@BindingAdapter("loadImage")
fun loadImage(imageView: ImageView, urlString: String?){
    urlString?.let {
        Glide.with(imageView)
            .load(urlString)
            .placeholder(R.drawable.image_placeholder)
            .error(R.drawable.image_placeholder)
            .into(imageView)
    }
}