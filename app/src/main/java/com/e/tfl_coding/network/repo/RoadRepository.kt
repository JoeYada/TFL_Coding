package com.e.tfl_coding.network.repo

import com.e.tfl_coding.models.Road
import io.reactivex.Single

interface RoadRepository {
    fun getRoadStatus(id:String):Single<List<Road>>
}