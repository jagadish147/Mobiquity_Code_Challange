package com.jagadish.mobiquitywetherapp.ui.weather_detail.weatherHourOfDay

import androidx.databinding.ObservableField
import com.jagadish.mobiquitywetherapp.core.BaseViewModel
import com.jagadish.mobiquitywetherapp.network.model.ListItem
import javax.inject.Inject

/**
 * Created by Jagadeesh on 22-01-2021.
 */
class WeatherHourOfDayItemViewModel @Inject internal constructor() : BaseViewModel() {
    var item = ObservableField<ListItem>()
}