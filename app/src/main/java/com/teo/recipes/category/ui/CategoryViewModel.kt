package com.teo.recipes.category.ui

import androidx.lifecycle.ViewModel
import com.teo.recipes.category.data.CategoryRepository
import javax.inject.Inject

/**
 * The ViewModel for [CategoryFragment].
 */
class CategoryViewModel @Inject constructor(repository: CategoryRepository) : ViewModel() {

    val categories= repository.categories
}
