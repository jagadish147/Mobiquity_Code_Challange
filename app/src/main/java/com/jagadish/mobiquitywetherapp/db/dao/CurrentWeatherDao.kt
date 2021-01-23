package com.jagadish.mobiquitywetherapp.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.jagadish.mobiquitywetherapp.db.entity.CurrentWeatherEntity

/**
 * Created by Jagadeesh on 22-01-2021.
 */
@Dao
interface CurrentWeatherDao {

    @Query("SELECT * FROM CurrentWeather")
    fun getCurrentWeather(): LiveData<List<CurrentWeatherEntity>>

    @Insert
    fun insertCurrentWeather(currentWeatherEntity: CurrentWeatherEntity)

    @Transaction
    fun deleteAndInsert(currentWeatherEntity: CurrentWeatherEntity) {
//        deleteCurrentWeather()
        insertCurrentWeather(currentWeatherEntity)
    }

    @Delete
    fun deleteCurrentWeather(currentWeatherEntity: CurrentWeatherEntity)

    @Query("Select count(*) from CurrentWeather")
    fun getCount(): Int
}
