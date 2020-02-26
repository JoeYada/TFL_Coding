package com.e.tfl_coding.di.activity

import com.e.tfl_coding.MainActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {
    fun injectRoadActivity(mainActivity: MainActivity)
}