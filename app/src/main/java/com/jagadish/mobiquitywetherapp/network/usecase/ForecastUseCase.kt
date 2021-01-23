package com.jagadish.mobiquitywetherapp.network.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.jagadish.mobiquitywetherapp.core.Constants
import com.jagadish.mobiquitywetherapp.db.entity.ForecastEntity
import com.jagadish.mobiquitywetherapp.network.repo.ForecastRepository
import com.jagadish.mobiquitywetherapp.ui.dashboard.ForecastMapper
import com.jagadish.mobiquitywetherapp.ui.dashboard.ForecastViewState
import com.jagadish.mobiquitywetherapp.utils.UseCaseLiveData
import com.jagadish.mobiquitywetherapp.utils.network.Resource
import javax.inject.Inject

/**
 * Created by Jagadeesh on 23-01-2021.
 */
class ForecastUseCase @Inject internal constructor(private val repository: ForecastRepository) : UseCaseLiveData<ForecastViewState, ForecastUseCase.ForecastParams, ForecastRepository>() {

    override fun getRepository(): ForecastRepository {
        return repository
    }

    override fun buildUseCaseObservable(params: ForecastParams?): LiveData<ForecastViewState> {
        return repository.loadForecastByCoord(
            params?.lat?.toDouble() ?: 0.0,
            params?.lon?.toDouble() ?: 0.0,
            params?.fetchRequired
                ?: false,
            units = params?.units ?: Constants.Coords.METRIC
        ).map {
            onForecastResultReady(it)
        }
    }

    private fun onForecastResultReady(resource: Resource<ForecastEntity>): ForecastViewState {
        val mappedList = resource.data?.list?.let { ForecastMapper().mapFrom(it) }
        resource.data?.list = mappedList

        return ForecastViewState(
            status = resource.status,
            error = resource.message,
            data = resource.data
        )
    }

    class ForecastParams(
        val lat: String = "",
        val lon: String = "",
        val fetchRequired: Boolean,
        val units: String
    ) : Params()
}