package com.teo.recipes.meal.ui

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.teo.recipes.R
import com.teo.recipes.binding.bindImageFromUrl
import com.teo.recipes.data.Result
import com.teo.recipes.databinding.FragmentMealDetailBinding
import com.teo.recipes.di.Injectable
import com.teo.recipes.di.injectViewModel
import com.teo.recipes.meal.data.Meal
import com.teo.recipes.ui.hide
import com.teo.recipes.ui.setTitle
import com.teo.recipes.ui.show
import javax.inject.Inject


/**
 * A fragment representing a single Meal detail screen.
 */
class MealDetailFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: MealDetailViewModel

    private val args: MealDetailFragmentArgs by navArgs()
    private lateinit var meal: Meal

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        viewModel = injectViewModel(viewModelFactory)
//        viewModel.prop = MealDetailFragmentArgs.fromBundle(arguments!!).meal
        viewModel.idMeal = args.idMeal

        val binding = DataBindingUtil.inflate<FragmentMealDetailBinding>(
                inflater, R.layout.fragment_meal_detail, container, false).apply {
            lifecycleOwner = this@MealDetailFragment
          //  fab.setOnClickListener { _ -> meal.idMeal?.let { intentOpenWebsite(activity!!,it) } }
        }

        subscribeUi(binding)

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_share, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    @Suppress("DEPRECATION")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }


private fun subscribeUi(binding: FragmentMealDetailBinding) {
    viewModel.meal.observe(viewLifecycleOwner, Observer { result ->
        when (result.status) {
            Result.Status.SUCCESS -> {
                binding.progressBar.hide()
                result.data?.let { bindView(binding, it) }
            }
            Result.Status.LOADING -> binding.progressBar.show()
            Result.Status.ERROR -> {
                binding.progressBar.hide()
                Snackbar.make(binding.coordinatorLayout, result.message!!, Snackbar.LENGTH_LONG).show()
            }
        }
    })
}

private fun bindView(binding: FragmentMealDetailBinding, meal: Meal) {
    meal.apply {
        setTitle(strMeal)
        bindImageFromUrl(binding.image, strMealThumb)
        binding.name.text = strMeal
        binding.instructions.text = strInstructions
       val list = getIngredientPairs().filter { it.first.isNullOrBlank().not() && it.second.isNullOrBlank().not() }
                .map { "${it.first} ${it.second}" }
        binding.ingredient.text = list.toString()
        this@MealDetailFragment.meal = meal
    }
}
}
