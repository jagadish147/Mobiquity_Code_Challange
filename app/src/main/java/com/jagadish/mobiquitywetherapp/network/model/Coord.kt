package com.jagadish.mobiquitywetherapp.network.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

/**
 * Created by Jagadeesh on 22-01-2021.
 */
@Parcelize
@JsonClass(generateAdapter = true)
data class Coord(

    @Json(name = "lon")
    val lon: Double?,

    @Json(name = "lat")
    val lat: Double?
) : Parcelable
