package com.jagadish.mobiquitywetherapp.network.repo

import androidx.lifecycle.LiveData
import com.jagadish.mobiquitywetherapp.core.Constants.NetworkService.RATE_LIMITER_TYPE
import com.jagadish.mobiquitywetherapp.db.entity.CurrentWeatherEntity
import com.jagadish.mobiquitywetherapp.network.model.CurrentWeatherResponse
import com.jagadish.mobiquitywetherapp.network.source.currentWeather.CurrentWeatherLocalDataSource
import com.jagadish.mobiquitywetherapp.network.source.currentWeather.CurrentWeatherRemoteDataSource
import com.jagadish.mobiquitywetherapp.repo.NetworkBoundResource
import com.jagadish.mobiquitywetherapp.utils.network.RateLimiter
import com.jagadish.mobiquitywetherapp.utils.network.Resource
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by Jagadeesh on 22-01-2021.
 */
class CurrentWeatherRepository @Inject constructor(
    private val currentWeatherRemoteDataSource: CurrentWeatherRemoteDataSource,
    private val currentWeatherLocalDataSource: CurrentWeatherLocalDataSource
) {

    private val currentWeatherRateLimit = RateLimiter<String>(30, TimeUnit.SECONDS)

    fun loadCurrentWeatherByGeoCords(lat: Double, lon: Double, fetchRequired: Boolean, units: String): LiveData<Resource<List<CurrentWeatherEntity>>> {
        return object : NetworkBoundResource<List<CurrentWeatherEntity>, CurrentWeatherResponse>() {
            override fun saveCallResult(item: CurrentWeatherResponse) = currentWeatherLocalDataSource.insertCurrentWeather(item)

            override fun shouldFetch(data: List<CurrentWeatherEntity>?): Boolean = fetchRequired

            override fun loadFromDb(): LiveData<List<CurrentWeatherEntity>> = currentWeatherLocalDataSource.getCurrentWeather()

            override fun createCall(): Single<CurrentWeatherResponse> = currentWeatherRemoteDataSource.getCurrentWeatherByGeoCords(lat, lon, units)

            override fun onFetchFailed() = currentWeatherRateLimit.reset(RATE_LIMITER_TYPE)
        }.asLiveData
    }
}