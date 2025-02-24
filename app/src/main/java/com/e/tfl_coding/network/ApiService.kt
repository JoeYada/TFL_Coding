package com.e.tfl_coding.network

import com.e.tfl_coding.common.RELATIVE_URL
import com.e.tfl_coding.models.Road
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET(RELATIVE_URL)
    fun getRoadStatus(@Path("id") id:String,
                      @Query("app_id") app_id: String,
                      @Query("app_key") app_key:String):Single<Response<List<Road>>>
}