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
data class Rain(

    @Json(name = "3h")
    val jsonMember3h: Double?
) : Parcelable