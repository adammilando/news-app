package com.news.app.ui.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.news.app.databinding.AdapterHeadlineBinding
import com.news.app.model.ArticleModel
import com.news.app.databinding.AdapterNewsBinding
import com.news.app.utils.DateFormatter

private const val HEADLINES = 1
private const val NEWS = 2

class NewsAdapter(
    val articles: ArrayList<ArticleModel>,
    val listener: OnAdapterListener
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        var VIEW_TYPES = HEADLINES
    }

    class ViewHolderNews(val binding: AdapterNewsBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(article: ArticleModel){
            binding.article = article
            binding.dateFormat = DateFormatter()
        }
    }

    class ViewHolderHeadlines(val binding: AdapterHeadlineBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(article: ArticleModel){
            binding.article = article
            binding.dateFormat = DateFormatter()
        }
    }

    interface OnAdapterListener{
        fun onClick(articleModel: ArticleModel)
    }

    override fun getItemViewType(position: Int) = VIEW_TYPES

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : RecyclerView.ViewHolder {
        return if (viewType == HEADLINES){
            ViewHolderHeadlines(
                AdapterHeadlineBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false

                )
            )
        } else ViewHolderNews (
            AdapterNewsBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount() = articles.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val article = articles[position]
        if (VIEW_TYPES == HEADLINES) (holder as ViewHolderHeadlines).bind(article)
        else (holder as ViewHolderNews).bind(article)
        holder.itemView.setOnClickListener{
            listener.onClick( article )
        }
    }

    fun add(data: List<ArticleModel>){
        articles.addAll(data)
        notifyItemRangeInserted( (articles.size - data.size), data.size)
    }

    fun clear(){
        articles.clear()
        notifyDataSetChanged()
    }
}