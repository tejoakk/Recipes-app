package com.teo.recipes.category.data

import com.teo.recipes.data.resultLiveData
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Repository module for handling data operations.
 */
@Singleton
class CategoryRepository @Inject constructor(private val dao: CategoryDao,
                                             private val remoteSource: CategoryRemoteDataSource) {

    val categories = resultLiveData(
            databaseQuery = { dao.getCategories() },
            networkCall = { remoteSource.fetchData() },
            saveCallResult = { it.categories?.let { it1 -> dao.insertAll(it1) } })

}
