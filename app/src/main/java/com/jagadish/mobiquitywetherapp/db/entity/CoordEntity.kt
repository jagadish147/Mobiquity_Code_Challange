package com.jagadish.mobiquitywetherapp.db.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import com.jagadish.mobiquitywetherapp.network.model.Coord
import com.jagadish.mobiquitywetherapp.network.model.Geoloc
import kotlinx.android.parcel.Parcelize

/**
 * Created by Jagadeesh on 22-01-2021.
 */
@Parcelize
@Entity(tableName = "Coord")
data class CoordEntity(
    @ColumnInfo(name = "lon")
    val lon: Double?,
    @ColumnInfo(name = "lat")
    val lat: Double?
) : Parcelable {
    @Ignore
    constructor(coord: Coord) : this(
        lon = coord.lon,
        lat = coord.lat
    )

    @Ignore
    constructor(geoloc: Geoloc?) : this(
        lon = geoloc?.lng,
        lat = geoloc?.lat
    )
}