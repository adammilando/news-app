package com.news.app.ui.news

import android.location.GnssAntennaInfo.Listener
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
import com.news.app.Model.CategoryModel
import com.news.app.R
import com.news.app.databinding.AdapterCategoryBinding

class CategoryAdapter(
    val categories: List<CategoryModel>,
    val listener: OnAdapterListener
): RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    private val items = arrayListOf<TextView>()
    class ViewHolder(val binding: AdapterCategoryBinding): RecyclerView.ViewHolder(binding.root)

    interface OnAdapterListener{
        fun onClick(category: CategoryModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        AdapterCategoryBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun getItemCount() = categories.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = categories[position]
        holder.binding.category.text = category.name
        items.add(holder.binding.category)
        holder.itemView.setOnClickListener{
            listener.onClick( category )
            setColor(holder.binding.category)
        }
        setColor(items[0])
    }

    private fun setColor(textView: TextView){
        items.forEach{ it.setBackgroundResource(R.color.white)}
        textView.setBackgroundResource(android.R.color.darker_gray)
    }
}