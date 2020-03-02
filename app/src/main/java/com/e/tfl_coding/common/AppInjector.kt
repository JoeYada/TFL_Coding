package com.e.tfl_coding.common

import android.app.Application
import com.e.tfl_coding.di.application.ApplicationComponent
import com.e.tfl_coding.di.application.ApplicationModule
import com.e.tfl_coding.di.application.DaggerApplicationComponent

class AppInjector: Application() {
    val applicationComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }
}