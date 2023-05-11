package com.news.app.ui.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.news.app.model.ArticleModel
import com.news.app.databinding.AdapterNewsBinding
import com.news.app.utils.DateFormatter

class NewsAdapter(
    val articles: ArrayList<ArticleModel>,
    val listener: OnAdapterListener
): RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    class ViewHolder(val binding: AdapterNewsBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(article: ArticleModel){
            binding.article = article
            binding.dateFormat = DateFormatter()
        }
    }

    interface OnAdapterListener{
        fun onClick(articleModel: ArticleModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        AdapterNewsBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun getItemCount() = articles.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = articles[position]
        holder.bind(article)
        holder.itemView.setOnClickListener{
            listener.onClick( article )
        }
    }

    fun add(data: List<ArticleModel>){
        articles.clear()
        articles.addAll(data)
        notifyDataSetChanged()
    }
}