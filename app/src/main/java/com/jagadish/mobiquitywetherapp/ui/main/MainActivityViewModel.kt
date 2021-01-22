package com.jagadish.mobiquitywetherapp.ui.main

import androidx.databinding.ObservableField
import com.jagadish.mobiquitywetherapp.core.BaseViewModel
import javax.inject.Inject

/**
 * Created by Jagadeesh on 21-01-2021.
 */
class MainActivityViewModel @Inject internal constructor() : BaseViewModel() {
    var toolbarTitle: ObservableField<String> = ObservableField()
}