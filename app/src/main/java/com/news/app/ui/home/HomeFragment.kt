package com.news.app.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.news.app.model.ArticleModel
import com.news.app.model.CategoryModel
import com.news.app.databinding.CustomToolbarBinding
import com.news.app.databinding.FragmentHomeBinding
import com.news.app.ui.detail.DetailActivity
import com.news.app.ui.news.CategoryAdapter
import com.news.app.ui.news.NewsAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.dsl.module
import timber.log.Timber

val homeModule = module {
    factory { HomeFragment() }
}
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var bindingToolbarBinding: CustomToolbarBinding
    private val viewModel: HomeViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentHomeBinding.inflate(inflater, container, false)
        bindingToolbarBinding = binding.toolbar
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        bindingToolbarBinding.title = viewModel.title

        binding.listCategory.adapter = categoryAdapter

        viewModel.category.observe(viewLifecycleOwner) {
            Timber.e(it)
            viewModel.fetch()
        }

        binding.listNews.adapter = newsAdapter

        viewModel.news.observe(viewLifecycleOwner) {
            Timber.e(it.articles.toString())
            newsAdapter.add(it.articles)
        }

        viewModel.message.observe(viewLifecycleOwner) {
            it?.let {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            }
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

    private val categoryAdapter by lazy {
        CategoryAdapter(viewModel.categories, object : CategoryAdapter.OnAdapterListener{
            override fun onClick(category: CategoryModel) {
                viewModel.category.postValue( category.id )
            }
        })
    }
}