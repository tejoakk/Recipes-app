package com.teo.recipes.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.teo.recipes.util.getValue
import com.teo.recipes.meal.data.MealDao
import com.teo.recipes.util.*
import kotlinx.coroutines.runBlocking
import org.hamcrest.Matchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MealDaoTest : DbTest() {
    private lateinit var mealDao: MealDao
    private val meal1 = testMeal1.copy()
    private val meal2 = testMeal2.copy()
    private val category = "Seafood"

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before fun createDb() {
        mealDao = db.mealDao()

        runBlocking {
            mealDao.insertAll(listOf(testMeal1, testMeal2))
        }
    }

    @Test fun testGetMeals() {
        val list = getValue(mealDao.getMealsByCategory(category))
        assertThat(list.size, equalTo(2))

        assertThat(list[0], equalTo(meal1))
        assertThat(list[1], equalTo(meal2))
    }

    @Test fun testGetMeal() {
        assertThat(getValue(meal1.idMeal?.let { mealDao.getMeal(it) }), equalTo(meal1))
    }
}