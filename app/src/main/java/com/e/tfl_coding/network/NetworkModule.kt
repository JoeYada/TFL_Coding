package com.e.tfl_coding.network

import com.e.tfl_coding.common.BASE_URL
import com.e.tfl_coding.di.application.ApplicationScope
import com.e.tfl_coding.network.repo.RoadRepoImpl
import com.e.tfl_coding.network.repo.RoadRepository
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NetworkModule {
    @Provides
    @ApplicationScope
    fun providesInterceptor():HttpLoggingInterceptor{
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Provides
    @ApplicationScope
    fun providesOKHttpClient(interceptor: HttpLoggingInterceptor):OkHttpClient{
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    @Provides
    @ApplicationScope
    fun providesRetrofit(okHttpClient: OkHttpClient):Retrofit{
        return Retrofit.Builder().baseUrl(BASE_URL)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @ApplicationScope
    fun providesService(retrofit: Retrofit):ApiService = retrofit.create(ApiService::class.java)

    @Provides
    @ApplicationScope
    fun providesRepository(apiService: ApiService): RoadRepository = RoadRepoImpl(apiService)
}