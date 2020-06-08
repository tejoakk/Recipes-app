package com.teo.recipes.api

import com.google.gson.annotations.SerializedName

data class MealResponse<T>(
    @SerializedName("meals")
    val meals: List<T>
)