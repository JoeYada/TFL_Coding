package com.e.tfl_coding.network.repo

import com.e.tfl_coding.models.ApiError
import com.e.tfl_coding.models.Road
import com.e.tfl_coding.network.ApiService
import com.google.gson.Gson
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RoadRepoImpl(private val apiService: ApiService): RoadRepository {
    override fun getRoadStatus(id:String):Single<List<Road>> {
        return apiService.getRoadStatus(id).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap {
            if (it.isSuccessful) {
                Single.just(it.body())
            } else {
                val errorResponse =
                    Gson().fromJson<ApiError>(it.errorBody()?.string(), ApiError::class.java)
                if (errorResponse != null) {
                    Single.error<List<Road>>(RuntimeException(errorResponse.message))
                } else {
                    Single.error<List<Road>>(RuntimeException("Unknown Error"))
                }
            }
        }
    }
}