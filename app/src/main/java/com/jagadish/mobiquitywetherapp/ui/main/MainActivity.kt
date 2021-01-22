package com.jagadish.mobiquitywetherapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.jagadish.mobiquitywetherapp.R
import com.jagadish.mobiquitywetherapp.core.BaseActivity
import com.jagadish.mobiquitywetherapp.databinding.MainActivityBinding
import com.jagadish.mobiquitywetherapp.utils.extensions.hide
import com.jagadish.mobiquitywetherapp.utils.extensions.show
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MainActivity : BaseActivity<MainActivityViewModel, MainActivityBinding>(MainActivityViewModel::class.java), HasAndroidInjector{

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector

    override fun initViewModel(viewModel: MainActivityViewModel) {
        binding.viewModel = viewModel
    }

    override fun getLayoutRes() = R.layout.main_activity

    private lateinit var  navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        binding.toolbar.hide()

        setUpNavigation()



    }

    private fun setUpNavigation(){
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.container_fragment) as NavHostFragment
        navController = navHostFragment.navController
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.splashFragment -> {
                    binding.toolbar.hide()
                }
                R.id.homeFragment -> {
                    binding.toolbar.show()
                    binding.toolbar.setNavigationIcon(null)
                    binding.viewModel!!.toolbarTitle.set("Home")
                }
                R.id.searchFragment -> {
                    binding.viewModel!!.toolbarTitle.set("Search")
                    binding.toolbar.setNavigationIcon(R.drawable.ic_back)
                    binding.toolbar.show()
                }
                else -> {
                    binding.toolbar.hide()
                }
            }
        }

        binding.toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    override fun onBackPressed() {
        if(navController.currentDestination?.id == R.id.searchFragment){
            navController.navigate(R.id.action_searchFragment_to_homeFragment)
        }else {
            super.onBackPressed()
        }
    }
}