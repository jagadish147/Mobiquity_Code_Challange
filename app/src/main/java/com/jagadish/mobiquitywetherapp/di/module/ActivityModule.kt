package com.jagadish.mobiquitywetherapp.di.module

import com.jagadish.mobiquitywetherapp.ui.main.MainActivity
import com.jagadish.mobiquitywetherapp.di.scope.PerActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Jagadeesh on 21-01-2021.
 */

@Module
abstract class ActivityModule {

    /**
     * Injects [MainActivity]
     *
     * @return an instance of [MainActivity]
     */

    @PerActivity
    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    internal abstract fun mainActivity(): MainActivity
}