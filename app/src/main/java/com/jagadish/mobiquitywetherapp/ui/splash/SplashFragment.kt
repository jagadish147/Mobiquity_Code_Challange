package com.jagadish.mobiquitywetherapp.ui.splash

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jagadish.mobiquitywetherapp.R
import com.jagadish.mobiquitywetherapp.core.BaseFragment
import com.jagadish.mobiquitywetherapp.databinding.SplashFragmentBinding
import com.jagadish.mobiquitywetherapp.di.Injectable
import com.jagadish.mobiquitywetherapp.ui.main.MainActivity
import com.jagadish.mobiquitywetherapp.utils.extensions.show
import io.reactivex.disposables.CompositeDisposable

class SplashFragment : BaseFragment<SplashViewModel, SplashFragmentBinding>(R.layout.splash_fragment, SplashViewModel::class.java),
    Injectable {

    var disposable = CompositeDisposable()
    private val SPLASH_TIME_OUT:Long=3000 // 3 sec
    override fun init() {
        super.init()

        Handler().postDelayed({
            navigate(R.id.action_splashFragment_to_homeFragment)
        }, SPLASH_TIME_OUT)
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.clear()
    }






}