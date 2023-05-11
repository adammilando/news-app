package com.news.app.ui.bookmark

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.news.app.databinding.CustomToolbarBinding
import com.news.app.databinding.FragmentBookmarkBinding
import com.news.app.model.ArticleModel
import com.news.app.ui.detail.DetailActivity
import com.news.app.ui.news.NewsAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.dsl.module

val bookmarkModule = module {
    factory { BookmarkFragment() }
}

class BookmarkFragment : Fragment() {

    private lateinit var binding: FragmentBookmarkBinding
    private lateinit var bindingToolbarBinding: CustomToolbarBinding
    private val viewModel: BookmarkViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBookmarkBinding.inflate(inflater, container, false)
        bindingToolbarBinding = binding.toolbar
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindingToolbarBinding.title =  viewModel.title
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        NewsAdapter.VIEW_TYPES = 2
        binding.listBookmark.adapter =newsAdapter

        viewModel.articles.observe( viewLifecycleOwner ){
            newsAdapter.clear()
             newsAdapter.add(it)
        }
    }

    private val newsAdapter by lazy {
        NewsAdapter(arrayListOf(), object : NewsAdapter.OnAdapterListener{
            override fun onClick(articleModel: ArticleModel) {
                startActivity(
                    Intent(requireActivity(), DetailActivity::class.java)
                        .putExtra("intent_detail",articleModel)
                )
            }
        })
    }
}