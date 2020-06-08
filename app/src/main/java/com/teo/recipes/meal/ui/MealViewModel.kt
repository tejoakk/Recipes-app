package com.teo.recipes.meal.ui

import androidx.lifecycle.ViewModel
import com.teo.recipes.di.CoroutineScropeIO
import com.teo.recipes.meal.data.Meal
import com.teo.recipes.meal.data.MealRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import javax.inject.Inject

/**
 * The ViewModel for [MealFragment].
 */
class MealViewModel @Inject constructor(private val repository: MealRepository,
                                        @CoroutineScropeIO private val ioCoroutineScope: CoroutineScope)
    : ViewModel() {

//    var connectivityAvailable: Boolean = false
    var strCategory: String? = null
//    var prop : Meal? = null
    val meals by lazy {
        strCategory?.let { repository.observeMealsByCategory(it) }
//        observeMeals(
//                connectivityAvailable, strCategory, ioCoroutineScope)

    }

    /**
     * Cancel all coroutines when the ViewModel is cleared.
     */
    override fun onCleared() {
        super.onCleared()
        ioCoroutineScope.cancel()
    }
}
