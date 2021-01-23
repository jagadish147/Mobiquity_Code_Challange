package com.jagadish.mobiquitywetherapp.ui.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.jagadish.mobiquitywetherapp.R
import com.jagadish.mobiquitywetherapp.core.BaseFragment
import com.jagadish.mobiquitywetherapp.core.Constants
import com.jagadish.mobiquitywetherapp.databinding.HomeFragmentBinding
import com.jagadish.mobiquitywetherapp.databinding.SplashFragmentBinding
import com.jagadish.mobiquitywetherapp.db.entity.CurrentWeatherEntity
import com.jagadish.mobiquitywetherapp.di.Injectable
import com.jagadish.mobiquitywetherapp.network.usecase.CurrentWeatherUseCase
import com.jagadish.mobiquitywetherapp.ui.main.MainActivity
import com.jagadish.mobiquitywetherapp.ui.splash.SplashViewModel
import com.jagadish.mobiquitywetherapp.utils.extensions.isNetworkAvailable
import com.jagadish.mobiquitywetherapp.utils.extensions.observeWith
import io.reactivex.disposables.CompositeDisposable

class HomeFragment : BaseFragment<HomeViewModel, HomeFragmentBinding>(R.layout.home_fragment, HomeViewModel::class.java),
    Injectable {

    var disposable = CompositeDisposable()

    override fun init() {
        super.init()
        initBookmarksAdapter()
        binding.buttonSearch.setOnClickListener{
            navigate(R.id.action_homeFragment_to_searchFragment)
        }

        sharedElementReturnTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)

        val lat: String? = binding.viewModel?.sharedPreferences?.getString(Constants.Coords.LAT, "")
        val lon: String? = binding.viewModel?.sharedPreferences?.getString(Constants.Coords.LON, "")

        if (lat?.isNotEmpty() == true && lon?.isNotEmpty() == true) {
            binding.viewModel?.setCurrentWeatherParams(CurrentWeatherUseCase.CurrentWeatherParams(lat, lon, isNetworkAvailable(requireContext()), Constants.Coords.METRIC))
        }

        binding.viewModel?.getCurrentWeatherViewState()?.observeWith(
            viewLifecycleOwner
        ) {
            with(binding) {
                binding.viewState = it
                it.data?.let { results -> initSearchResultsRecyclerView(results) }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.clear()
    }


    private fun initBookmarksAdapter() {
        val adapter = BookmarksAdapter { item ->
            findNavController().navigate(R.id.action_homeFragment_to_dashboardFragment)
        }

        binding.recyclerViewBookmarks.adapter = adapter
        binding.recyclerViewBookmarks.layoutManager = GridLayoutManager(context,2)
    }

    private fun initSearchResultsRecyclerView(list: List<CurrentWeatherEntity>) {
        (binding.recyclerViewBookmarks.adapter as BookmarksAdapter).submitList(list)
    }
}