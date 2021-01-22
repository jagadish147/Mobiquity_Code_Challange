package com.jagadish.mobiquitywetherapp.ui.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jagadish.mobiquitywetherapp.R
import com.jagadish.mobiquitywetherapp.core.BaseFragment
import com.jagadish.mobiquitywetherapp.databinding.HomeFragmentBinding
import com.jagadish.mobiquitywetherapp.databinding.SplashFragmentBinding
import com.jagadish.mobiquitywetherapp.di.Injectable
import com.jagadish.mobiquitywetherapp.ui.main.MainActivity
import com.jagadish.mobiquitywetherapp.ui.splash.SplashViewModel
import io.reactivex.disposables.CompositeDisposable

class HomeFragment : BaseFragment<HomeViewModel, HomeFragmentBinding>(R.layout.home_fragment, HomeViewModel::class.java),
    Injectable {

    var disposable = CompositeDisposable()

    override fun init() {
        super.init()

        binding.buttonSearch.setOnClickListener{
            navigate(R.id.action_homeFragment_to_searchFragment)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.clear()
    }

}