package com.teo.recipes.util

import android.app.Activity
import android.content.Intent
import androidx.appcompat.widget.Toolbar
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra
import com.teo.recipes.meal.data.Meal
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import java.util.*

const val category = "Seafood"

val testMeal1 = Meal(52959, "Baked salmon with fennel & tomatoes",
 "https://www.themealdb.com/images/media/meals/1548772327.jpg", category)

val testMeal2 = Meal(52819, "Cajun spiced fish tacos",
        "https://www.themealdb.com/images/media/meals/uvuyxu1503067369.jpg", category)

/**
 * Returns the content description for the navigation button view in the toolbar.
 */
fun getToolbarNavigationContentDescription(activity: Activity, toolbarId: Int) =
    activity.findViewById<Toolbar>(toolbarId).navigationContentDescription as String

/**
 * Simplify testing Intents with Chooser
 *
 * @param matcher the actual intent before wrapped by Chooser Intent
 */
fun chooser(matcher: Matcher<Intent>): Matcher<Intent> = allOf(
    hasAction(Intent.ACTION_CHOOSER),
    hasExtra(`is`(Intent.EXTRA_INTENT), matcher)
)