//package com.teo.recipes.meal.data
//
//import androidx.paging.PageKeyedDataSource
//import com.teo.recipes.api.BaseDataSource
//import com.teo.recipes.data.Result
//import kotlinx.coroutines.CoroutineExceptionHandler
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.launch
//import timber.log.Timber
//import javax.inject.Inject
//
///**
// * Data source for meals
// */
//class MealDataSource @Inject constructor(
//        private val strCategory: String? = null,
//        private val dataSource: MealRemoteDataSource,
//        private val dao: MealDao,
//        private val scope: CoroutineScope) : BaseDataSource() {
//
//
////
////
////    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Meal>) {
////        fetchData(1, params.requestedLoadSize) {
////            callback.onResult(it, null, 2)
////        }
////    }
////
////    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Meal>) {
////        val page = params.key
////        fetchData(page, params.requestedLoadSize) {
////            callback.onResult(it, page + 1)
////        }
////    }
////
////    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Meal>) {
////        val page = params.key
////        fetchData(page, params.requestedLoadSize) {
////            callback.onResult(it, page - 1)
////        }
////    }
//
//    suspend fun fetchData() {
//        scope.launch(getJobErrorHandler()) {
//            val response = strCategory?.let { dataSource.fetchMeals(it) }
//            if (response != null) {
//                if (response.status == Result.Status.SUCCESS) {
//                    val results = response.data!!
//                    dao.insertAll(results.meals)
//                } else if (response.status == Result.Status.ERROR) {
//                    postError(response.message!!)
//                }
//            }
//        }
//    }
//
//    private fun getJobErrorHandler() = CoroutineExceptionHandler { _, e ->
//        postError(e.message ?: e.toString())
//    }
//
//    private fun postError(message: String) {
//        Timber.e("An error happened: $message")
//        // TODO network error handling
//        //networkState.postValue(NetworkState.FAILED)
//    }
//
//}