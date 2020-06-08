package com.teo.recipes.meal.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.teo.recipes.R
import com.teo.recipes.data.Result
import com.teo.recipes.databinding.FragmentMealBinding
import com.teo.recipes.di.Injectable
import com.teo.recipes.di.injectViewModel
import com.teo.recipes.ui.VerticalItemDecoration
import com.teo.recipes.ui.hide
import com.teo.recipes.ui.setTitle
import com.teo.recipes.ui.show
import javax.inject.Inject

/**
 * A fragment representing a single Meal list screen.
 */
class MealFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: MealViewModel

    private val args: MealFragmentArgs by navArgs()
    private val adapter: MealAdapter by lazy { MealAdapter() }
    private lateinit var binding: FragmentMealBinding
    private lateinit var linearLayoutManager: LinearLayoutManager

    private val linearDecoration: RecyclerView.ItemDecoration by lazy {
        VerticalItemDecoration(
                resources.getDimension(R.dimen.margin_normal).toInt())
    }
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        viewModel = injectViewModel(viewModelFactory)
        viewModel.strCategory = args.strCategory

//        viewModel.strCategory = MealFragmentArgs.fromBundle(arguments!!).meal

//        val binding = FragmentMealBinding.inflate(inflater, container, false)
//        context ?: return binding.root
//        val binding = DataBindingUtil.inflate<FragmentMealBinding>(
//                inflater, R.layout.fragment_meal, container, false).apply {
//            lifecycleOwner = this@MealFragment
//           // fab.setOnClickListener { _ -> category.strCategory?.let { } }
//        }

        binding = FragmentMealBinding.inflate(inflater, container, false)
        context ?: return binding.root

        linearLayoutManager = LinearLayoutManager(activity)
//        binding.mealRecyclerView.addItemDecoration(
//                VerticalItemDecoration(resources.getDimension(R.dimen.margin_normal).toInt(), true) )
        binding.mealRecyclerView.adapter = adapter
        binding.setLifecycleOwner(this)

        args.strCategory?.let { setTitle(it) }
        setLayoutManager()
        subscribeUi(adapter)

        setHasOptionsMenu(true)
        return binding.root
    }

    private fun subscribeUi(adapter: MealAdapter) {
        viewModel.meals?.observe(viewLifecycleOwner, Observer { result ->
            when (result.status) {
                Result.Status.SUCCESS -> {
                    binding.progressBar.hide()
                    result.data?.let { adapter.submitList(it) }
                }
                Result.Status.LOADING -> binding.progressBar.show()
                Result.Status.ERROR -> {
                    binding.progressBar.hide()
                    Snackbar.make(binding.root, result.message!!, Snackbar.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun setLayoutManager() {
        val recyclerView = binding.mealRecyclerView

        var scrollPosition = 0
        // If a layout manager has already been set, get current scroll position.
        if (recyclerView.layoutManager != null) {
            scrollPosition = (recyclerView.layoutManager as LinearLayoutManager)
                    .findFirstCompletelyVisibleItemPosition()
        }

            recyclerView.addItemDecoration(linearDecoration)
            recyclerView.layoutManager = linearLayoutManager

        recyclerView.scrollToPosition(scrollPosition)
    }

}
