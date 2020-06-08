package com.teo.recipes.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.teo.recipes.meal.data.MealRepository
import com.teo.recipes.meal.ui.MealViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.CoreMatchers.nullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito.*

@RunWith(JUnit4::class)
class MealViewModelTest {

    private val category = "test"

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    private val repository = mock(MealRepository::class.java)
    private var viewModel = MealViewModel(repository, coroutineScope)

    @Test
    fun testNull() {
        assertThat(viewModel.strCategory, nullValue())
        // assertThat(viewModel.connectivityAvailable, notNullValue())
        verify(repository, never()).observeMealsByCategory(category)
    }

    @Test
    fun doNotFetchWithoutObservers() {
        viewModel.strCategory = category
        verify(repository, never()).observeMealsByCategory(category)
    }

    @Test
    fun doNotFetchWithoutObserverOnConnectionChange() {
        viewModel.strCategory = category

        verify(repository, never()).observeMealsByCategory(category)

    }
}