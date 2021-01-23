package com.jagadish.mobiquitywetherapp.network.repo

import androidx.lifecycle.LiveData
import com.jagadish.mobiquitywetherapp.core.Constants.NetworkService.RATE_LIMITER_TYPE
import com.jagadish.mobiquitywetherapp.db.entity.ForecastEntity
import com.jagadish.mobiquitywetherapp.network.model.ForecastResponse
import com.jagadish.mobiquitywetherapp.network.source.forecast.ForecastLocalDataSource
import com.jagadish.mobiquitywetherapp.network.source.forecast.ForecastRemoteDataSource
import com.jagadish.mobiquitywetherapp.repo.NetworkBoundResource
import com.jagadish.mobiquitywetherapp.utils.network.RateLimiter
import com.jagadish.mobiquitywetherapp.utils.network.Resource
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by Jagadeesh on 23-01-2021.
 */
class ForecastRepository @Inject constructor(
    private val forecastRemoteDataSource: ForecastRemoteDataSource,
    private val forecastLocalDataSource: ForecastLocalDataSource
) {

    private val forecastListRateLimit = RateLimiter<String>(30, TimeUnit.SECONDS)

    fun loadForecastByCoord(lat: Double, lon: Double, fetchRequired: Boolean, units: String): LiveData<Resource<ForecastEntity>> {
        return object : NetworkBoundResource<ForecastEntity, ForecastResponse>() {
            override fun saveCallResult(item: ForecastResponse) = forecastLocalDataSource.insertForecast(item)

            override fun shouldFetch(data: ForecastEntity?): Boolean = fetchRequired

            override fun loadFromDb(): LiveData<ForecastEntity> = forecastLocalDataSource.getForecast()

            override fun createCall(): Single<ForecastResponse> = forecastRemoteDataSource.getForecastByGeoCords(lat, lon, units)

            override fun onFetchFailed() = forecastListRateLimit.reset(RATE_LIMITER_TYPE)
        }.asLiveData
    }
}