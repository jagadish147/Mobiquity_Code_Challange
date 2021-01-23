package com.jagadish.mobiquitywetherapp.network.source.forecast

import com.jagadish.mobiquitywetherapp.db.dao.ForecastDao
import com.jagadish.mobiquitywetherapp.db.entity.ForecastEntity
import com.jagadish.mobiquitywetherapp.network.model.ForecastResponse
import javax.inject.Inject

/**
 * Created by Jagadeesh on 22-01-2021.
 */
class ForecastLocalDataSource @Inject constructor(private val forecastDao: ForecastDao) {

    fun getForecast() = forecastDao.getForecast()

    fun insertForecast(forecast: ForecastResponse) = forecastDao.deleteAndInsert(ForecastEntity(forecast))
}