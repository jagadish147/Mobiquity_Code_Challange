package com.jagadish.mobiquitywetherapp.ui.dashboard

import com.jagadish.mobiquitywetherapp.core.BaseViewState
import com.jagadish.mobiquitywetherapp.db.entity.ForecastEntity
import com.jagadish.mobiquitywetherapp.utils.network.Status

/**
 * Created by Jagadeesh on 23-01-2021.
 */
class ForecastViewState(
    val status: Status,
    val error: String? = null,
    val data: ForecastEntity? = null
) : BaseViewState(status, error) {
    fun getForecast() = data
}