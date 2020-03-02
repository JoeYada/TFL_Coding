package com.e.tfl_coding.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.e.tfl_coding.common.ApiProgress
import com.e.tfl_coding.network.repo.RoadRepository
import io.reactivex.disposables.CompositeDisposable

class RoadViewModel constructor(private val repository: RoadRepository) : ViewModel() {
    val status = MutableLiveData<ApiProgress>()
    private val compositeDisposable = CompositeDisposable()
    fun getRoadResponse(id: String) {
        status.value = ApiProgress.PROGRESS
        compositeDisposable.add(
            repository.getRoadStatus(id).subscribe({
                if (it.isEmpty()){
                    status.value = ApiProgress.FAILURE("No Results Found")
                }else{
                    status.value = ApiProgress.SUCCESS(it)
                }
            }, {
                status.value = ApiProgress.FAILURE(it.localizedMessage)
            })
        )
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}