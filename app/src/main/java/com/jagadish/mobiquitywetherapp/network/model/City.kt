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
data class City(

    @Json(name = "country")
    val country: String?,

    @Json(name = "coord")
    val coord: Coord?,

    @Json(name = "name")
    val name: String?,

    @Json(name = "id")
    val id: Int?
) : Parcelable