package com.jagadish.mobiquitywetherapp.ui.splash

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import com.jagadish.mobiquitywetherapp.core.BaseViewModel
import javax.inject.Inject

class SplashViewModel @Inject constructor(var sharedPreferences: SharedPreferences) : BaseViewModel() {
}