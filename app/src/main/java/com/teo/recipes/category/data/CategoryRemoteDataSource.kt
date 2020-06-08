package com.teo.recipes.category.data

import com.teo.recipes.api.ApiService
import com.teo.recipes.api.BaseDataSource
import javax.inject.Inject

/**
 * Works with the API to get data.
 */
class CategoryRemoteDataSource @Inject constructor(private val service: ApiService) : BaseDataSource() {

    suspend fun fetchData() = getResult { service.getCategories() }

}
