package com.teo.recipes.api

import com.teo.recipes.category.data.Category
import com.teo.recipes.meal.data.Meal
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *  API access points
 */
interface ApiService {

    companion object {
        const val ENDPOINT = "https://www.themealdb.com/api/json/v1/1/"
        //
    }

    @GET("categories.php")
    suspend fun getCategories():Response<CategoryResponse<Category>>

    @GET("filter.php")
    suspend fun getRecipes(@Query("c") type: String):
            Response<CategoryResponse<Meal>>

    @GET("lookup.php")
    suspend fun getRecipeDetails(@Query("i") type: Int):
            Response<CategoryResponse<Meal>>

}
