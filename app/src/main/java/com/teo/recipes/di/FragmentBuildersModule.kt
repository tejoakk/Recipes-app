package com.teo.recipes.di


import com.teo.recipes.category.ui.CategoryFragment
import com.teo.recipes.meal.ui.MealDetailFragment
import com.teo.recipes.meal.ui.MealFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeCategoryFragment(): CategoryFragment

    @ContributesAndroidInjector
    abstract fun contributeMealFragment(): MealFragment

    @ContributesAndroidInjector
    abstract fun contributeMealDetailFragment(): MealDetailFragment
}
