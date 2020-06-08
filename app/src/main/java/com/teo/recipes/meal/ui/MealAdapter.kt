package com.teo.recipes.meal.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.teo.recipes.databinding.ListItemMealBinding
import com.teo.recipes.meal.data.Meal

/**
 * Adapter for the [RecyclerView] in [CategoryFragment].
 */
class MealAdapter : ListAdapter<Meal, MealAdapter.ViewHolder>(com.teo.recipes.meal.ui.DiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val meal = getItem(position)
        holder.apply {
            bind(createOnClickListener( meal.idMeal), meal)
            itemView.tag = meal
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListItemMealBinding.inflate(
                LayoutInflater.from(parent.context), parent, false))
    }

    private fun createOnClickListener( id: Int): View.OnClickListener {
        return View.OnClickListener {
            val direction = MealFragmentDirections.actionToMealDetailFragment(id)
            it.findNavController().navigate(direction)
        }
    }

    class ViewHolder(
        private val binding: ListItemMealBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: Meal) {
            binding.apply {
                clickListener = listener
                meal = item
                executePendingBindings()
            }
        }
    }
}

private class DiffCallback : DiffUtil.ItemCallback<Meal>() {

    override fun areItemsTheSame(oldItem: Meal, newItem: Meal): Boolean {
        return oldItem.idMeal == newItem.idMeal
    }

    override fun areContentsTheSame(oldItem: Meal, newItem: Meal): Boolean {
        return oldItem == newItem
    }
}