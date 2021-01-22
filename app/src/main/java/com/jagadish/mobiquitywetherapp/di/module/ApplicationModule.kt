package com.jagadish.mobiquitywetherapp.di.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Jagadeesh on 21-01-2021.
 */
@Module
class ApplicationModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context = application.applicationContext

    @Provides
    @Singleton
    fun provideSharedPreferences(application: Application): SharedPreferences = PreferenceManager.getDefaultSharedPreferences(application)
}