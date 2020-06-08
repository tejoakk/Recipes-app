package com.teo.recipes.util

import com.teo.recipes.meal.data.Meal

object DomainObjectFactory {

    fun createMeal() = Meal(52959, "Baked salmon with fennel & tomatoes",
            "https://www.themealdb.com/images/media/meals/1548772327.jpg", category)

    fun createMeal(count: Int): List<Meal> {
        return (0 until count).map {
            createMeal()
        }
    }

}
