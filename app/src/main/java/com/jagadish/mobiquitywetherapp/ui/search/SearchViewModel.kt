package com.jagadish.mobiquitywetherapp.ui.search

import android.content.SharedPreferences
import com.google.android.gms.maps.model.LatLng
import com.jagadish.mobiquitywetherapp.core.BaseViewModel
import com.jagadish.mobiquitywetherapp.core.Constants
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Jagadeesh on 22-01-2021.
 */
class SearchViewModel @Inject constructor(var sharedPreferences: SharedPreferences) : BaseViewModel() {

    fun saveCoordsToSharedPref(latLng: LatLng): Single<String>? {
        return Single.create<String> {
            sharedPreferences.edit().putString(Constants.Coords.LAT, latLng.latitude.toString()).apply()
            sharedPreferences.edit().putString(Constants.Coords.LON, latLng.longitude.toString()).apply()
            it.onSuccess("")
        }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }
}