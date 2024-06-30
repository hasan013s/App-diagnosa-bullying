package com.haa.diagnosabullying.data.resource.local.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "stress_level_entity")
data class DiagnosisEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @SerializedName("id")
    val id: Int = 0,
    @ColumnInfo(name = "stress_level")
    @SerializedName("stress_level")
    val stressLevel: String,
    @ColumnInfo(name = "impact")
    @SerializedName("impacts")
    val impacts: String,
    @ColumnInfo(name = "solution")
    @SerializedName("solutions")
    val solutions: String,
    @ColumnInfo("created_at")
    @SerializedName("createdAt")
    val createdAt: Long = System.currentTimeMillis(),
)
