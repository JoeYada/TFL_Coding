package com.e.tfl_coding.models

import com.google.gson.annotations.SerializedName

data class Road(@SerializedName("statusSeverityDescription")val statusSeverityDescription: String,
                @SerializedName("displayName")val displayName:String,
                @SerializedName("statusSeverity") val statusSeverity:String)