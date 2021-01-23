package com.jagadish.mobiquitywetherapp.ui.dashboard.forecast

import androidx.databinding.ObservableField
import com.jagadish.mobiquitywetherapp.core.BaseViewModel
import com.jagadish.mobiquitywetherapp.network.model.ListItem
import javax.inject.Inject

/**
 * Created by Jagadeesh on 23-01-2021.
 */
class ForecastItemViewModel @Inject internal constructor() : BaseViewModel() {
    var item = ObservableField<ListItem>()
}