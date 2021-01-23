package com.jagadish.mobiquitywetherapp.core

import com.jagadish.mobiquitywetherapp.utils.network.Status

/**
 * Created by Jagadeesh on 22-01-2021.
 */
open class BaseViewState(val baseStatus: Status, val baseError: String?) {
    fun isLoading() = baseStatus == Status.LOADING
    fun getErrorMessage() = baseError
    fun shouldShowErrorMessage() = baseError != null
}