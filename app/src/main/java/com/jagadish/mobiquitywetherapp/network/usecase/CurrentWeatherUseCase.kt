package com.jagadish.mobiquitywetherapp.network.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.jagadish.mobiquitywetherapp.core.Constants
import com.jagadish.mobiquitywetherapp.db.entity.CurrentWeatherEntity
import com.jagadish.mobiquitywetherapp.network.repo.CurrentWeatherRepository
import com.jagadish.mobiquitywetherapp.ui.home.CurrentWeatherViewState
import com.jagadish.mobiquitywetherapp.utils.UseCaseLiveData
import com.jagadish.mobiquitywetherapp.utils.network.Resource
import javax.inject.Inject

/**
 * Created by Jagadeesh on 22-01-2021.
 */
class CurrentWeatherUseCase @Inject internal constructor(private val repository: CurrentWeatherRepository) : UseCaseLiveData<CurrentWeatherViewState, CurrentWeatherUseCase.CurrentWeatherParams, CurrentWeatherRepository>() {

    override fun getRepository(): CurrentWeatherRepository {
        return repository
    }

    override fun buildUseCaseObservable(params: CurrentWeatherParams?): LiveData<CurrentWeatherViewState> {
        return repository.loadCurrentWeatherByGeoCords(
            params?.lat?.toDouble() ?: 0.0,
            params?.lon?.toDouble() ?: 0.0,
            params?.fetchRequired
                ?: false,
            units = params?.units ?: Constants.Coords.METRIC
        ).map {
            onCurrentWeatherResultReady(it)
        }
    }

    private fun onCurrentWeatherResultReady(resource: Resource<List<CurrentWeatherEntity>>): CurrentWeatherViewState {
        return CurrentWeatherViewState(
            status = resource.status,
            error = resource.message,
            data = resource.data
        )
    }

    class CurrentWeatherParams(
        val lat: String = "",
        val lon: String = "",
        val fetchRequired: Boolean,
        val units: String
    ) : Params()
}