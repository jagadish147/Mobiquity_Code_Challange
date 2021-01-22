package com.jagadish.mobiquitywetherapp

import android.app.Application
import com.jagadish.mobiquitywetherapp.di.AppInjector
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

/**
 * Created by Jagadeesh on 21-01-2021.
 */
class MobiquityApp :  Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    override fun onCreate() {
        super.onCreate()

        AppInjector.init(this)
    }
}