package com.jagadish.mobiquitywetherapp.di.key

import android.app.Activity
import dagger.MapKey
import kotlin.reflect.KClass

/**
 * Created by Jagadeesh on 21-01-2021.
 */
@MapKey
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
annotation class ActivityKey(val value: KClass<out Activity>)