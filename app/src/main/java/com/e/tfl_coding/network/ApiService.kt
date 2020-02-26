package com.e.tfl_coding.network

import com.e.tfl_coding.common.RELATIVE_URL
import com.e.tfl_coding.models.RoadResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(RELATIVE_URL)
    fun getRoadStatus(
        @Query("id")id:String
    ):Single<RoadResponse>
}