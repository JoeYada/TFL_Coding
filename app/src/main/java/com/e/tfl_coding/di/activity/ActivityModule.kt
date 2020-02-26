package com.e.tfl_coding.di.activity

import com.e.tfl_coding.di.factories.RoadViewModelFactory
import com.e.tfl_coding.network.repo.RoadRepository
import dagger.Module
import dagger.Provides

@Module
class ActivityModule {
    @Provides
    @ActivityScope
    fun providesRoadFactory(repository: RoadRepository) = RoadViewModelFactory(repository)
}