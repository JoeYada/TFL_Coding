package com.e.tfl_coding.di.application

import android.app.Application
import android.content.Context
import com.e.tfl_coding.network.ApiService
import com.e.tfl_coding.network.NetworkModule
import com.e.tfl_coding.network.repo.RoadRepoImpl
import com.e.tfl_coding.network.repo.RoadRepository
import dagger.Module
import dagger.Provides

@Module(includes = [NetworkModule::class])
class ApplicationModule(private val application: Application) {
    @Provides
    @ApplicationScope
    fun providesContext(): Context = application

    @Provides
    @ApplicationScope
    fun providesNetwork(apiService: ApiService): RoadRepository = RoadRepoImpl(apiService)
}