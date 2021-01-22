package com.jagadish.mobiquitywetherapp.di.module

import com.jagadish.mobiquitywetherapp.ui.home.HomeFragment
import com.jagadish.mobiquitywetherapp.ui.search.SearchFragment
import com.jagadish.mobiquitywetherapp.ui.splash.SplashFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Jagadeesh on 21-01-2021.
 */

@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeSplashFragment(): SplashFragment

    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): HomeFragment
//
//    @ContributesAndroidInjector
//    abstract fun contributeWeatherDetailFragment(): WeatherDetailFragment

    @ContributesAndroidInjector
    abstract fun contributeSearchFragment(): SearchFragment
}