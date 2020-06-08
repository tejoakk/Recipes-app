package com.teo.recipes.category.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.teo.recipes.category.data.Category
import com.teo.recipes.databinding.ListItemCategoryBinding

/**
 * Adapter for the [RecyclerView] in [CategoryFragment].
 */
class CategoryAdapter : ListAdapter<Category, CategoryAdapter.ViewHolder>(com.teo.recipes.category.ui.DiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = getItem(position)
        holder.apply {
            bind(createOnClickListener( category.strCategory), category)
            itemView.tag = category
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListItemCategoryBinding.inflate(
                LayoutInflater.from(parent.context), parent, false))
    }

    private fun createOnClickListener( name: String): View.OnClickListener {
        return View.OnClickListener {
            val direction = CategoryFragmentDirections.actionCategoryFragmentToMealsFragment( name)
            it.findNavController().navigate(direction)
        }
    }

    class ViewHolder(
        private val binding: ListItemCategoryBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: Category) {
            binding.apply {
                clickListener = listener
                category = item
                executePendingBindings()
            }
        }
    }
}

private class DiffCallback : DiffUtil.ItemCallback<Category>() {

    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.idCategory == newItem.idCategory
    }

    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem == newItem
    }
}