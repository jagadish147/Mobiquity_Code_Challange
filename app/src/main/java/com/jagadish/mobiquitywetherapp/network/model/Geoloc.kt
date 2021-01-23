package com.jagadish.mobiquitywetherapp.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Created by Jagadeesh on 22-01-2021.
 */
@JsonClass(generateAdapter = true)
data class Geoloc(

    @Json(name = "lng")
    val lng: Double? = null,

    @Json(name = "lat")
    val lat: Double? = null
)