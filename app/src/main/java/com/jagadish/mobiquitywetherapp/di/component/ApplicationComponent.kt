package com.jagadish.mobiquitywetherapp.di.component

import android.app.Application
import com.jagadish.mobiquitywetherapp.MobiquityApp
import com.jagadish.mobiquitywetherapp.di.module.ActivityModule
import com.jagadish.mobiquitywetherapp.di.module.ApplicationModule
import com.jagadish.mobiquitywetherapp.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        ActivityModule::class,
        ViewModelModule::class
    ]
)

interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(weatherApp: MobiquityApp)
}
