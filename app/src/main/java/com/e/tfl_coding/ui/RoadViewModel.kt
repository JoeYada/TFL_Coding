package com.e.tfl_coding.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.e.tfl_coding.models.RoadResponse
import com.e.tfl_coding.network.repo.RoadRepository

class RoadViewModel constructor(private val repository: RoadRepository): ViewModel() {
    val roadResponse = MutableLiveData<RoadResponse>()
    fun getRoadResponse(id: String){
        repository.getRoadStatus(id).subscribe({
            roadResponse.value = it
        },{
            it.printStackTrace()
        })
    }
}