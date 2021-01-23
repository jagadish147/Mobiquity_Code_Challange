package com.jagadish.mobiquitywetherapp.network.source.currentWeather

import com.jagadish.mobiquitywetherapp.db.dao.CurrentWeatherDao
import com.jagadish.mobiquitywetherapp.db.entity.CurrentWeatherEntity
import com.jagadish.mobiquitywetherapp.network.model.CurrentWeatherResponse
import javax.inject.Inject

/**
 * Created by Jagadeesh on 22-01-2021.
 */
class CurrentWeatherLocalDataSource @Inject constructor(private val currentWeatherDao: CurrentWeatherDao) {

    fun getCurrentWeather() = currentWeatherDao.getCurrentWeather()

    fun insertCurrentWeather(currentWeather: CurrentWeatherResponse) = currentWeatherDao.deleteAndInsert(
        CurrentWeatherEntity(currentWeather)
    )

    fun deleteBookMark(currentWeather: CurrentWeatherResponse) = currentWeatherDao.deleteCurrentWeather(
        CurrentWeatherEntity(currentWeather)
    )
}