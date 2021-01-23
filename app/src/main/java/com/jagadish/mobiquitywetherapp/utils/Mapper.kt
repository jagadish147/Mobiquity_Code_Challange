package com.jagadish.mobiquitywetherapp.utils

/**
 * Created by Jagadeesh on 23-01-2021.
 */
interface Mapper<R, D> {
    fun mapFrom(type: R): D
}