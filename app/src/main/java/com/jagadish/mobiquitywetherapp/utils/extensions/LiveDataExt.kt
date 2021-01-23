package com.jagadish.mobiquitywetherapp.utils.extensions

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

/**
 * Created by Jagadeesh on 22-01-2021.
 */
inline fun <T : Any> LiveData<T>.observeWith(
    lifecycleOwner: LifecycleOwner,
    crossinline onChanged: (T) -> Unit
) {
    observe(
        lifecycleOwner,
        Observer {
            it ?: return@Observer
            onChanged.invoke(it)
        }
    )
}