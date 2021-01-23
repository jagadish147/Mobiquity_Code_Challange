package com.jagadish.mobiquitywetherapp.db.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import com.jagadish.mobiquitywetherapp.network.model.Clouds
import kotlinx.android.parcel.Parcelize

/**
 * Created by Jagadeesh on 22-01-2021.
 */
@Parcelize
@Entity(tableName = "Clouds")
data class CloudsEntity(
    @ColumnInfo(name = "all")
    var all: Int
) : Parcelable {
    @Ignore
    constructor(clouds: Clouds?) : this(
        all = clouds?.all ?: 0
    )
}