package com.jagadish.mobiquitywetherapp.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jagadish.mobiquitywetherapp.di.ViewModelFactory
import com.jagadish.mobiquitywetherapp.di.key.ViewModelKey
import com.jagadish.mobiquitywetherapp.ui.home.HomeViewModel
import com.jagadish.mobiquitywetherapp.ui.main.MainActivityViewModel
import com.jagadish.mobiquitywetherapp.ui.search.SearchViewModel
import com.jagadish.mobiquitywetherapp.ui.splash.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Jagadeesh on 21-01-2021.
 */
@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @IntoMap
    @Binds
    @ViewModelKey(SplashViewModel::class)
    abstract fun provideSplashFragmentViewModel(splashViewModel: SplashViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun provideMainViewModel(mainActivityViewModel: MainActivityViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(HomeViewModel::class)
    abstract fun provideHomeFragmentViewModel(homeViewModel: HomeViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(SearchViewModel::class)
    abstract fun provideSearchFragmentViewModel(searchViewModel: SearchViewModel): ViewModel


}