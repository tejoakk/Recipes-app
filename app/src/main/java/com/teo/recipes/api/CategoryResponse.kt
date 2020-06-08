package com.teo.recipes.api

import com.google.gson.annotations.SerializedName
import com.teo.recipes.category.data.Category
import com.teo.recipes.meal.data.Meal

data class CategoryResponse<T>(

        @SerializedName("categories")
    val categories: List<Category>? = null,
        @SerializedName("meals")
    val meals: List<Meal>? = null
)