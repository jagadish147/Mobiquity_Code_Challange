package com.jagadish.mobiquitywetherapp.core

/**
 * Created by Jagadeesh on 22-01-2021.
 */
object Constants {

    object NetworkService {
        const val BASE_URL = "http://api.openweathermap.org/data/2.5/"
        const val API_KEY_VALUE = "fae7190d7e6433ec3a45285ffcf55c86"
        const val RATE_LIMITER_TYPE = "data"
        const val API_KEY_QUERY = "appid"
    }


    object Coords {
        const val LAT = "lat"
        const val LON = "lon"
        const val METRIC = "metric"
    }
}