package com.jagadish.mobiquitywetherapp.network

import com.jagadish.mobiquitywetherapp.network.model.CurrentWeatherResponse
import com.jagadish.mobiquitywetherapp.network.model.ForecastResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Jagadeesh on 22-01-2021.
 */
interface WeatherAppAPI {

    @GET("weather")
    fun getCurrentByGeoCords(
        @Query("lat")
        lat: Double,
        @Query("lon")
        lon: Double,
        @Query("units")
        units: String
    ): Single<CurrentWeatherResponse>

    @GET("forecast")
    fun getForecastByGeoCords(
        @Query("lat")
        lat: Double,
        @Query("lon")
        lon: Double,
        @Query("units")
        units: String
    ): Single<ForecastResponse>
}