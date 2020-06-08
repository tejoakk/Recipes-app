package com.teo.recipes.meal.data

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 * The Data Access Object for the Meal class.
 */
@Dao
interface MealDao {

    @Query("SELECT * FROM meal WHERE strCategory = :strCategory")
    fun getMealsByCategory(strCategory: String): LiveData<List<Meal>>

//    @Query("SELECT * FROM meal WHERE strCategory = :strCategory")
//    fun getMealsByCategory(strCategory: String): DataSource.Factory<Int, Meal>

    @Query("SELECT * FROM meal WHERE idMeal = :idMeal")
    fun getMeal(idMeal: Int): LiveData<Meal>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(meals: List<Meal>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(meal: Meal)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(meal: Meal)

    @Query("Update meal SET strCategory = :strCategory WHERE strCategory is NULL")
    suspend fun updateAll(strCategory:String)
}
