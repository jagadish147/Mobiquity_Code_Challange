package com.jagadish.mobiquitywetherapp.di.module

import android.content.Context
import androidx.room.Room
import com.jagadish.mobiquitywetherapp.db.WeatherDatabase
import com.jagadish.mobiquitywetherapp.db.dao.CurrentWeatherDao
import com.jagadish.mobiquitywetherapp.db.dao.ForecastDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Jagadeesh on 22-01-2021.
 */
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun getDatabase(context: Context): WeatherDatabase {
        return Room.databaseBuilder(
            context,
            WeatherDatabase::class.java, "WeatherApp-DB"
        ).build()
    }

    @Singleton
    @Provides
    fun provideForecastDao(db: WeatherDatabase): ForecastDao {
        return db.forecastDao()
    }

    @Singleton
    @Provides
    fun provideCurrentWeatherDao(db: WeatherDatabase): CurrentWeatherDao {
        return db.currentWeatherDao()
    }

}