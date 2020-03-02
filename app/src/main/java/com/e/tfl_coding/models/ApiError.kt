package com.e.tfl_coding.models

import com.google.gson.annotations.SerializedName

data class ApiError(
    @SerializedName("exceptionType") val exceptionType: String,
    @SerializedName("httpStatusCode") val httpStatusCode: Int,
    @SerializedName("httpStatus") val httpStatus: String,
    @SerializedName("message") val message: String
)