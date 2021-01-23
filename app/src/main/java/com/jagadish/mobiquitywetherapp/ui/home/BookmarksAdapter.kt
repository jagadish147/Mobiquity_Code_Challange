package com.jagadish.mobiquitywetherapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.jagadish.mobiquitywetherapp.core.BaseAdapter
import com.jagadish.mobiquitywetherapp.databinding.LayoutDashboardForecastBinding
import com.jagadish.mobiquitywetherapp.db.entity.CurrentWeatherEntity

/**
 * Created by Jagadeesh on 22-01-2021.
 */
class BookmarksAdapter (private val callBack: (CurrentWeatherEntity) -> Unit) : BaseAdapter<CurrentWeatherEntity>(diffCallback) {

    override fun createBinding(parent: ViewGroup, viewType: Int): ViewDataBinding {
        val mBinding = LayoutDashboardForecastBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        val viewModel = BookmarksItemViewModel()
        mBinding.viewModel = viewModel

        mBinding.rootView.setOnClickListener {
            mBinding.viewModel?.item?.get()?.let {
                callBack.invoke(it)
            }
        }
        return mBinding
    }

    override fun bind(binding: ViewDataBinding, position: Int) {
        (binding as LayoutDashboardForecastBinding).viewModel?.item?.set(getItem(position))
        binding.executePendingBindings()
    }
}

val diffCallback = object : DiffUtil.ItemCallback<CurrentWeatherEntity>() {
    override fun areContentsTheSame(oldItem: CurrentWeatherEntity, newItem: CurrentWeatherEntity): Boolean =
        oldItem == newItem

    override fun areItemsTheSame(oldItem: CurrentWeatherEntity, newItem: CurrentWeatherEntity): Boolean =
        oldItem.name == newItem.name
}