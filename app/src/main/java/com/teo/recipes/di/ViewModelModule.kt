package com.teo.recipes.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.teo.recipes.category.ui.CategoryViewModel
import com.teo.recipes.meal.ui.MealDetailViewModel
import com.teo.recipes.meal.ui.MealViewModel

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(CategoryViewModel::class)
    abstract fun bindThemeViewModel(viewModel: CategoryViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MealViewModel::class)
    abstract fun bindMealViewModel(viewModel: MealViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MealDetailViewModel::class)
    abstract fun bindMealDetailViewModel(viewModel: MealDetailViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
