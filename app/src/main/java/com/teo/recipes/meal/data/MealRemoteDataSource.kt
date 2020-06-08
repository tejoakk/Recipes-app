package com.teo.recipes.meal.data

import com.teo.recipes.api.BaseDataSource
import com.teo.recipes.testing.OpenForTesting
import com.teo.recipes.api.ApiService
import javax.inject.Inject

/**
 * Works with the API to get data.
 */
@OpenForTesting
class MealRemoteDataSource @Inject constructor(private val service: ApiService) : BaseDataSource() {

    suspend fun fetchMeals(strCategory: String)
            = getResult { service.getRecipes(strCategory) }

    suspend fun fetchMeal(idMeal: Int)= getResult { service.getRecipeDetails(idMeal) }
}
