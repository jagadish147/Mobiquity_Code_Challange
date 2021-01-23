package com.jagadish.mobiquitywetherapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jagadish.mobiquitywetherapp.db.dao.CurrentWeatherDao
import com.jagadish.mobiquitywetherapp.db.dao.ForecastDao
import com.jagadish.mobiquitywetherapp.db.entity.CurrentWeatherEntity
import com.jagadish.mobiquitywetherapp.db.entity.ForecastEntity
import com.jagadish.mobiquitywetherapp.utils.typeconverters.DataConverter

/**
 * Created by Jagadeesh on 22-01-2021.
 */
@Database(
    entities = [
        ForecastEntity::class,
        CurrentWeatherEntity::class
               ],
    version = 1
)
@TypeConverters(DataConverter::class)
abstract class WeatherDatabase : RoomDatabase() {

    abstract fun forecastDao(): ForecastDao

    abstract fun currentWeatherDao(): CurrentWeatherDao

}