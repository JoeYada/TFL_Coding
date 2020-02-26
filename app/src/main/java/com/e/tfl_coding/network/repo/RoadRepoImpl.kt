package com.e.tfl_coding.network.repo

import com.e.tfl_coding.models.RoadResponse
import com.e.tfl_coding.network.ApiService
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RoadRepoImpl(private val apiService: ApiService): RoadRepository {
    override fun getRoadStatus(id:String) :Single<RoadResponse>{
        return apiService.getRoadStatus(id).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}