package com.teo.recipes.meal.ui

import androidx.lifecycle.ViewModel
import com.teo.recipes.meal.data.Meal
import com.teo.recipes.meal.data.MealRepository
import javax.inject.Inject
import kotlin.properties.Delegates

/**
 * The ViewModel used in [MealFragment].
 */
class MealDetailViewModel @Inject constructor(repository: MealRepository) : ViewModel() {

    var idMeal by Delegates.notNull<Int>()
    //var prop:  Meal? = null

    val meal by lazy { repository.observeMeal(idMeal) }

}
