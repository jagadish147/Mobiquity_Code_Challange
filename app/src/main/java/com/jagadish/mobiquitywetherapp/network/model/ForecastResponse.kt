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
data class ForecastResponse(

    @Json(name = "city")
    val city: City?,

    @Json(name = "cnt")
    val cnt: Int?,

    @Json(name = "cod")
    val cod: String?,

    @Json(name = "message")
    val message: Double?,

    @Json(name = "list")
    val list: List<ListItem>?
) : Parcelable