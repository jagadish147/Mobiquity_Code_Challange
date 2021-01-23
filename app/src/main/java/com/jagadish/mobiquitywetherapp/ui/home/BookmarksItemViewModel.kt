package com.jagadish.mobiquitywetherapp.ui.home

import androidx.databinding.ObservableField
import com.jagadish.mobiquitywetherapp.core.BaseViewModel
import com.jagadish.mobiquitywetherapp.db.entity.CurrentWeatherEntity
import javax.inject.Inject

/**
 * Created by Jagadeesh on 22-01-2021.
 */
class BookmarksItemViewModel @Inject internal constructor() : BaseViewModel() {
    var item = ObservableField<CurrentWeatherEntity>()
}