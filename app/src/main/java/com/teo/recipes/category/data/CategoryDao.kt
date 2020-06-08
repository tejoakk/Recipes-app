package com.teo.recipes.category.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.teo.recipes.category.data.Category

/**
 * The Data Access Object for the Category class.
 */
@Dao
interface CategoryDao {

    @Query("SELECT * FROM category ORDER BY idCategory DESC")
    fun getCategories(): LiveData<List<Category>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(plants: List<Category>)
}
