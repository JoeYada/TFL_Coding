package com.e.tfl_coding.common

import com.e.tfl_coding.models.Road

sealed class ApiProgress {
    object PROGRESS : ApiProgress()
    class SUCCESS(val roads: List<Road>): ApiProgress()
    class FAILURE(val error:String): ApiProgress()
}