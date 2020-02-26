package com.e.tfl_coding.models

import com.google.gson.annotations.SerializedName

data class Road(@SerializedName("statusSeverityDescription")val statusSeverityDescription: String,
                @SerializedName("envelope")val envelope: String,
                @SerializedName("displayName")val displayName:String,
                @SerializedName("statusSeverity") val statusSeverity:String,
                @SerializedName("bounds")val bounds:String,
                @SerializedName("id") val id: String,
                @SerializedName("url")val url:String,
                @SerializedName("type")val type: String)