package com.haa.diagnosabullying.data.resource.local.model

import android.util.Log
import com.google.gson.annotations.SerializedName
import com.haa.diagnosabullying.data.resource.local.room.entity.DiagnosisEntity

data class DiagnosisModel(
    @SerializedName("id")
    val id: String,
    @SerializedName("stress_level")
    val stressLevel: String,
    @SerializedName("impacts")
    val impacts: List<String>,
    @SerializedName("solutions")
    val solutions: List<String>,
) {
    fun mapToDiagnosisEntity() = DiagnosisEntity(
        stressLevel = stressLevel,
        impacts = impacts.joinToString { it },
        solutions = solutions.joinToString { it }
    )
}