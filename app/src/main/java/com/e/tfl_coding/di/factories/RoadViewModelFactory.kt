package com.e.tfl_coding.di.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.e.tfl_coding.network.repo.RoadRepository
import com.e.tfl_coding.ui.RoadViewModel
import javax.inject.Inject

class RoadViewModelFactory @Inject constructor(private val repoImpl: RoadRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(RoadViewModel::class.java)) RoadViewModel(repoImpl) as T
        else throw IllegalArgumentException("RoadViewModel Not Found")
    }
}