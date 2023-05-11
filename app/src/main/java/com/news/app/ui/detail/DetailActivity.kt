package com.news.app.ui.detail

import android.os.Bundle
import android.view.Menu
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.news.app.R
import com.news.app.databinding.ActivityDetailBinding
import com.news.app.databinding.CustomToolbarBinding
import com.news.app.model.ArticleModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.ext.android.viewModel


val detailModule = module {
    factory { DetailActivity() }
}

class DetailActivity : AppCompatActivity(){

    private val binding by lazy { ActivityDetailBinding.inflate(layoutInflater) }
    private lateinit var bindingToolbarBinding: CustomToolbarBinding
    private val viewModel: DetailViewModel by viewModel()

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
            viewModel.find(it)
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_bookmark, menu)
        val menuBookmark = menu!!.findItem(R.id.action_bookmark)
        menuBookmark.setOnMenuItemClickListener {
            viewModel.bookmark(detail)
            true
        }
        viewModel.isBookmark.observe(this) {
            if (it == 0) menuBookmark.setIcon(R.drawable.baseline_bookmark_add_24)
            else menuBookmark.setIcon(R.drawable.add_to_bookmark)
        }
        return super.onCreateOptionsMenu(menu)
    }
}