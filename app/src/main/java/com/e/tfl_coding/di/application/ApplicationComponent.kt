package com.e.tfl_coding.di.application

import com.e.tfl_coding.di.activity.ActivityComponent
import com.e.tfl_coding.di.activity.ActivityModule
import dagger.Component

@ApplicationScope
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun newActivityComponent(activityModule: ActivityModule):ActivityComponent
}