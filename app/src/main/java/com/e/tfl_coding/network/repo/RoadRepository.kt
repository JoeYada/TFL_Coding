package com.e.tfl_coding.network.repo

import io.reactivex.Single

interface RoadRepository {
    fun getRoadStatus()
}