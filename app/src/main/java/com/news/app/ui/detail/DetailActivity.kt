package com.news.app.ui.detail

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.news.app.databinding.ActivityDetailBinding
import com.news.app.databinding.CustomToolbarBinding
import com.news.app.model.ArticleModel

class DetailActivity : AppCompatActivity(){

    private val binding by lazy { ActivityDetailBinding.inflate(layoutInflater) }
    private lateinit var bindingToolbarBinding: CustomToolbarBinding
    private val detail by lazy {
        intent.getSerializableExtra("intent_detail") as ArticleModel
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingToolbarBinding = binding.toolbar
        setContentView(binding.root)

        setSupportActionBar( bindingToolbarBinding.container )
        supportActionBar!!.apply {
            title = "Web View"
            setDisplayHomeAsUpEnabled(true)
        }
        detail.let {
            val web = binding.webView
            web.loadUrl(it.url!!)
            web.webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    binding.progressTop.visibility = View.GONE
                }
            }
            val setting = binding.webView.settings
            setting.javaScriptCanOpenWindowsAutomatically = false
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}