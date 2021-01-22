package com.jagadish.mobiquitywetherapp.di.key

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

/**
 * Created by Jagadeesh on 21-01-2021.
 */
@MapKey
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)