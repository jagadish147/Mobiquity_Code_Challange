package com.jagadish.mobiquitywetherapp.ui.home

import com.jagadish.mobiquitywetherapp.core.BaseViewState
import com.jagadish.mobiquitywetherapp.db.entity.CurrentWeatherEntity
import com.jagadish.mobiquitywetherapp.utils.network.Status

/**
 * Created by Jagadeesh on 22-01-2021.
 */
class CurrentWeatherViewState(
    val status: Status,
    val error: String? = null,
    val data: List<CurrentWeatherEntity>? = null
) : BaseViewState(status, error) {
    fun getForecast() = data
}