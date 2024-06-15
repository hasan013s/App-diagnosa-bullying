package com.haa.diagnosabullying.data.resource.local.model

import com.google.gson.annotations.SerializedName

data class StressLevel(
    @SerializedName("id")
    val id: String,
    @SerializedName("stress_level")
    val stressLevel: String
)
