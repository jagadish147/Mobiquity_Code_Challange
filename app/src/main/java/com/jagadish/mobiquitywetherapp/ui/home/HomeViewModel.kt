package com.jagadish.mobiquitywetherapp.ui.home

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import com.jagadish.mobiquitywetherapp.core.BaseViewModel
import javax.inject.Inject

class HomeViewModel @Inject constructor(var sharedPreferences: SharedPreferences) : BaseViewModel() {
}