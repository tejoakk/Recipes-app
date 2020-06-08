package com.teo.recipes.category.data


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

//class CategoryList {
//        @SerializedName("categories")
//        private val categories: List<Category>? = null // ...
//}

@Entity(tableName = "category")
data class Category(
        @PrimaryKey
        @field:SerializedName("idCategory")
        val idCategory: Int,
        @field:SerializedName("strCategory")
        val strCategory: String,
        @field:SerializedName("strCategoryThumb")
        val strCategoryThumb: String? = null,
        @field:SerializedName("strCategoryDescription")
        val strCategoryDescription: String? = null

) {
    override fun toString() = strCategory
}