package com.teo.recipes.meal.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.teo.recipes.databinding.ListItemMealBinding
import com.teo.recipes.meal.data.Meal

/**
 * Adapter for the [RecyclerView] in [MealFragment].
 */
class MealDetailAdapter : ListAdapter<Meal, MealDetailAdapter.ViewHolder>(MealDiffCallback()) {

    private lateinit var recyclerView: RecyclerView

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val meal = getItem(position)
        meal?.let {
            holder.apply {
                createOnClickListener(meal.idMeal)?.let { it2 -> bind(it2, meal, isGridLayoutManager()) }
                itemView.tag = meal
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListItemMealBinding.inflate(
                LayoutInflater.from(parent.context), parent, false))
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        this.recyclerView = recyclerView
    }

    private fun createOnClickListener(id: Int): View.OnClickListener {
        return View.OnClickListener {
            val direction =MealFragmentDirections.actionToMealDetailFragment(id)
            it.findNavController().navigate(direction)
        }
    }

    private fun isGridLayoutManager() = recyclerView.layoutManager is GridLayoutManager

    class ViewHolder(private val binding: ListItemMealBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: Meal,
                 isGridLayoutManager: Boolean) {
            binding.apply {
                clickListener = listener
                meal = item
//                title.visibility = if (isGridLayoutManager) View.GONE else View.VISIBLE
                executePendingBindings()
            }
        }
    }
}

private class MealDiffCallback : DiffUtil.ItemCallback<Meal>() {

    override fun areItemsTheSame(oldItem: Meal, newItem: Meal): Boolean {
        return oldItem.idMeal == newItem.idMeal
    }

    override fun areContentsTheSame(oldItem: Meal, newItem: Meal): Boolean {
        return oldItem == newItem
    }
}