package com.jagadish.mobiquitywetherapp.network.source.currentWeather

import com.jagadish.mobiquitywetherapp.network.WeatherAppAPI
import com.jagadish.mobiquitywetherapp.network.model.CurrentWeatherResponse
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Jagadeesh on 22-01-2021.
 */
class CurrentWeatherRemoteDataSource @Inject constructor(private val api: WeatherAppAPI) {

    fun getCurrentWeatherByGeoCords(lat: Double, lon: Double, units: String): Single<CurrentWeatherResponse> = api.getCurrentByGeoCords(lat, lon, units)
}