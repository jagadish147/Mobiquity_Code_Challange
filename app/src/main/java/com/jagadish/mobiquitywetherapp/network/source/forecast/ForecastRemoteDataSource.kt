package com.jagadish.mobiquitywetherapp.network.source.forecast

import com.jagadish.mobiquitywetherapp.network.WeatherAppAPI
import com.jagadish.mobiquitywetherapp.network.model.ForecastResponse
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Jagadeesh on 23-01-2021.
 */
class ForecastRemoteDataSource @Inject constructor(private val api: WeatherAppAPI) {

    fun getForecastByGeoCords(lat: Double, lon: Double, units: String): Single<ForecastResponse> = api.getForecastByGeoCords(lat, lon, units)
}