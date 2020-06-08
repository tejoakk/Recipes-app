package com.teo.recipes.meal.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "meal")
data class Meal(
        @PrimaryKey
        @field:SerializedName("idMeal")
        var idMeal: Int,

        @field:SerializedName("strMeal")
        var strMeal: String? = null,

        @field:SerializedName("strMealThumb")
        var strMealThumb: String? = null,

        @field:SerializedName("strCategory")
        var strCategory: String? = null,

        @field:SerializedName("strDrinkAlternate")
        var strDrinkAlternate: String? = null,

        @field:SerializedName("strArea")
        var strArea: String? = null,

        @field:SerializedName("strInstructions")
        var strInstructions: String? = null,



        @field:SerializedName("strTags")
        var strTags: String? = null,

        @field:SerializedName("strYoutube")
        var strYoutube: String? = null,

        @field:SerializedName("strIngredient1")
        var strIngredient1: String? = null,

        @field:SerializedName("strIngredient2")
        var strIngredient2: String? = null,

        @field:SerializedName("strIngredient3")
        var strIngredient3: String? = null,

        @field:SerializedName("strIngredient4")
        var strIngredient4: String? = null,

        @field:SerializedName("strIngredient5")
        var strIngredient5: String? = null,

        @field:SerializedName("strIngredient6")
        var strIngredient6: String? = null,

        @field:SerializedName("strIngredient7")
        var strIngredient7: String? = null,

        @field:SerializedName("strIngredient8")
        var strIngredient8: String? = null,

        @field:SerializedName("strIngredient9")
        var strIngredient9: String? = null,

        @field:SerializedName("strIngredient10")
        var strIngredient10: String? = null,

        @field:SerializedName("strIngredient11")
        var strIngredient11: String? = null,

        @field:SerializedName("strIngredient12")
        var strIngredient12: String? = null,

        @field:SerializedName("strIngredient13")
        var strIngredient13: String? = null,

        @field:SerializedName("strIngredient14")
        var strIngredient14: String? = null,

        @field:SerializedName("strIngredient15")
        var strIngredient15: String? = null,

        @field:SerializedName("strIngredient16")
        var strIngredient16: String? = null,

        @field:SerializedName("strIngredient17")
        var strIngredient17: String? = null,

        @field:SerializedName("strIngredient18")
        var strIngredient18: String? = null,

        @field:SerializedName("strIngredient19")
        var strIngredient19: String? = null,

        @field:SerializedName("strIngredient20")
        var strIngredient20: String? = null,

        @field:SerializedName("strMeasure1")
        var strMeasure1: String? = null,

        @field:SerializedName("strMeasure2")
        var strMeasure2: String? = null,

        @field:SerializedName("strMeasure3")
        var strMeasure3: String? = null,

        @field:SerializedName("strMeasure4")
        var strMeasure4: String? = null,

        @field:SerializedName("strMeasure5")
        var strMeasure5: String? = null,

        @field:SerializedName("strMeasure6")
        var strMeasure6: String? = null,

        @field:SerializedName("strMeasure7")
        var strMeasure7: String? = null,

        @field:SerializedName("strMeasure8")
        var strMeasure8: String? = null,

        @field:SerializedName("strMeasure9")
        var strMeasure9: String? = null,

        @field:SerializedName("strMeasure10")
        var strMeasure10: String? = null,

        @field:SerializedName("strMeasure11")
        var strMeasure11: String? = null,

        @field:SerializedName("strMeasure12")
        var strMeasure12: String? = null,

        @field:SerializedName("strMeasure13")
        var strMeasure13: String? = null,

        @field:SerializedName("strMeasure14")
        var strMeasure14: String? = null,

        @field:SerializedName("strMeasure15")
        var strMeasure15: String? = null,

        @field:SerializedName("strMeasure16")
        var strMeasure16: String? = null,

        @field:SerializedName("strMeasure17")
        var strMeasure17: String? = null,

        @field:SerializedName("strMeasure18")
        var strMeasure18: String? = null,

        @field:SerializedName("strMeasure19")
        var strMeasure19: String? = null,

        @field:SerializedName("strMeasure20")
        var strMeasure20: String? = null,

        @field:SerializedName("strSource")
        var strSource: String? = null,

        @field:SerializedName("dateModified")
        var dateModified: String? = null

//var ingredients: String? = null

) {
        public fun getIngredientPairs() =
                listOf(
                        strMeasure1 to strIngredient1,
                        strMeasure2 to strIngredient2,
                        strMeasure3 to strIngredient3,
                        strMeasure4 to strIngredient4,
                        strMeasure5 to strIngredient5,
                        strMeasure6 to strIngredient6,
                        strMeasure7 to strIngredient7,
                        strMeasure8 to strIngredient8,
                        strMeasure9 to strIngredient9,
                        strMeasure10 to strIngredient10,
                        strMeasure11 to strIngredient11,
                        strMeasure12 to strIngredient12,
                        strMeasure13 to strIngredient13,
                        strMeasure14 to strIngredient14,
                        strMeasure15 to strIngredient15,
                        strMeasure16 to strIngredient16,
                        strMeasure17 to strIngredient17,
                        strMeasure18 to strIngredient18,
                        strMeasure19 to strIngredient19,
                        strMeasure20 to strIngredient20
                )

//        public fun getIngredients() {
//                if (!strIngredient1?.isEmpty()) {
//                        ingredients.append("\n \u2022 " + meal.getStrIngredient1());
//                }
//                if (!meal.getStrIngredient2().isEmpty()) {
//                        ingredients.append("\n \u2022 " + meal.getStrIngredient2());
//                }
//                if (!meal.getStrIngredient3().isEmpty()) {
//                        ingredients.append("\n \u2022 " + meal.getStrIngredient3());
//                }
//                if (!meal.getStrIngredient4().isEmpty()) {
//                        ingredients.append("\n \u2022 " + meal.getStrIngredient4());
//                }
//                if (!meal.getStrIngredient5().isEmpty()) {
//                        ingredients.append("\n \u2022 " + meal.getStrIngredient5());
//                }
//                if (!meal.getStrIngredient6().isEmpty()) {
//                        ingredients.append("\n \u2022 " + meal.getStrIngredient6());
//                }
//                if (!meal.getStrIngredient7().isEmpty()) {
//                        ingredients.append("\n \u2022 " + meal.getStrIngredient7());
//                }
//                if (!meal.getStrIngredient8().isEmpty()) {
//                        ingredients.append("\n \u2022 " + meal.getStrIngredient8());
//                }
//                if (!meal.getStrIngredient9().isEmpty()) {
//                        ingredients.append("\n \u2022 " + meal.getStrIngredient9());
//                }
//                if (!meal.getStrIngredient10().isEmpty()) {
//                        ingredients.append("\n \u2022 " + meal.getStrIngredient10());
//                }
//                if (!meal.getStrIngredient11().isEmpty()) {
//                        ingredients.append("\n \u2022 " + meal.getStrIngredient11());
//                }
//                if (!meal.getStrIngredient12().isEmpty()) {
//                        ingredients.append("\n \u2022 " + meal.getStrIngredient12());
//                }
//                if (!meal.getStrIngredient13().isEmpty()) {
//                        ingredients.append("\n \u2022 " + meal.getStrIngredient13());
//                }
//                if (!meal.getStrIngredient14().isEmpty()) {
//                        ingredients.append("\n \u2022 " + meal.getStrIngredient14());
//                }
//                if (!meal.getStrIngredient15().isEmpty()) {
//                        ingredients.append("\n \u2022 " + meal.getStrIngredient15());
//                }
//                if (!meal.getStrIngredient16().isEmpty()) {
//                        ingredients.append("\n \u2022 " + meal.getStrIngredient16());
//                }
//                if (!meal.getStrIngredient17().isEmpty()) {
//                        ingredients.append("\n \u2022 " + meal.getStrIngredient17());
//                }
//                if (!meal.getStrIngredient18().isEmpty()) {
//                        ingredients.append("\n \u2022 " + meal.getStrIngredient18());
//                }
//                if (!meal.getStrIngredient19().isEmpty()) {
//                        ingredients.append("\n \u2022 " + meal.getStrIngredient19());
//                }
//                if (!meal.getStrIngredient20().isEmpty()) {
//                        ingredients.append("\n \u2022 " + meal.getStrIngredient20());
//                }
//        }
//
//        public fun getMeasurements() {
//                if (!meal.getStrMeasure1().isEmpty() && !Character.isWhitespace(meal.getStrMeasure1().charAt(0))) {
//                        measures.append("\n : " + meal.getStrMeasure1());
//                }
//                if (!meal.getStrMeasure2().isEmpty() && !Character.isWhitespace(meal.getStrMeasure2().charAt(0))) {
//                        measures.append("\n : " + meal.getStrMeasure2());
//                }
//                if (!meal.getStrMeasure3().isEmpty() && !Character.isWhitespace(meal.getStrMeasure3().charAt(0))) {
//                        measures.append("\n : " + meal.getStrMeasure3());
//                }
//                if (!meal.getStrMeasure4().isEmpty() && !Character.isWhitespace(meal.getStrMeasure4().charAt(0))) {
//                        measures.append("\n : " + meal.getStrMeasure4());
//                }
//                if (!meal.getStrMeasure5().isEmpty() && !Character.isWhitespace(meal.getStrMeasure5().charAt(0))) {
//                        measures.append("\n : " + meal.getStrMeasure5());
//                }
//                if (!meal.getStrMeasure6().isEmpty() && !Character.isWhitespace(meal.getStrMeasure6().charAt(0))) {
//                        measures.append("\n : " + meal.getStrMeasure6());
//                }
//                if (!meal.getStrMeasure7().isEmpty() && !Character.isWhitespace(meal.getStrMeasure7().charAt(0))) {
//                        measures.append("\n : " + meal.getStrMeasure7());
//                }
//                if (!meal.getStrMeasure8().isEmpty() && !Character.isWhitespace(meal.getStrMeasure8().charAt(0))) {
//                        measures.append("\n : " + meal.getStrMeasure8());
//                }
//                if (!meal.getStrMeasure9().isEmpty() && !Character.isWhitespace(meal.getStrMeasure9().charAt(0))) {
//                        measures.append("\n : " + meal.getStrMeasure9());
//                }
//                if (!meal.getStrMeasure10().isEmpty() && !Character.isWhitespace(meal.getStrMeasure10().charAt(0))) {
//                        measures.append("\n : " + meal.getStrMeasure10());
//                }
//                if (!meal.getStrMeasure11().isEmpty() && !Character.isWhitespace(meal.getStrMeasure11().charAt(0))) {
//                        measures.append("\n : " + meal.getStrMeasure11());
//                }
//                if (!meal.getStrMeasure12().isEmpty() && !Character.isWhitespace(meal.getStrMeasure12().charAt(0))) {
//                        measures.append("\n : " + meal.getStrMeasure12());
//                }
//                if (!meal.getStrMeasure13().isEmpty() && !Character.isWhitespace(meal.getStrMeasure13().charAt(0))) {
//                        measures.append("\n : " + meal.getStrMeasure13());
//                }
//                if (!meal.getStrMeasure14().isEmpty() && !Character.isWhitespace(meal.getStrMeasure14().charAt(0))) {
//                        measures.append("\n : " + meal.getStrMeasure14());
//                }
//                if (!meal.getStrMeasure15().isEmpty() && !Character.isWhitespace(meal.getStrMeasure15().charAt(0))) {
//                        measures.append("\n : " + meal.getStrMeasure15());
//                }
//                if (!meal.getStrMeasure16().isEmpty() && !Character.isWhitespace(meal.getStrMeasure16().charAt(0))) {
//                        measures.append("\n : " + meal.getStrMeasure16());
//                }
//                if (!meal.getStrMeasure17().isEmpty() && !Character.isWhitespace(meal.getStrMeasure17().charAt(0))) {
//                        measures.append("\n : " + meal.getStrMeasure17());
//                }
//                if (!meal.getStrMeasure18().isEmpty() && !Character.isWhitespace(meal.getStrMeasure18().charAt(0))) {
//                        measures.append("\n : " + meal.getStrMeasure18());
//                }
//                if (!meal.getStrMeasure19().isEmpty() && !Character.isWhitespace(meal.getStrMeasure19().charAt(0))) {
//                        measures.append("\n : " + meal.getStrMeasure19());
//                }
//                if (!meal.getStrMeasure20().isEmpty() && !Character.isWhitespace(meal.getStrMeasure20().charAt(0))) {
//                        measures.append("\n : " + meal.getStrMeasure20());
//                }
//        }

}
