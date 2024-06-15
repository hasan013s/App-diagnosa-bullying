package com.haa.diagnosabullying.data.repository

import android.content.Context
import com.google.gson.Gson
import com.haa.diagnosabullying.R
import com.haa.diagnosabullying.data.resource.local.model.StressLevel
import com.haa.diagnosabullying.data.resource.local.room.AppDatabase
import com.haa.diagnosabullying.helper.readJsonFromRaw
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class QuestionRepository @Inject constructor(
    private val appDatabase: AppDatabase,
    @ApplicationContext private val context: Context,
) {
    private val stressLevelList: List<StressLevel> = Gson().fromJson(
        readJsonFromRaw(context, R.raw.stress_level),
        Array<StressLevel>::class.java
    ).toList()

    suspend fun getAllQuestion() = appDatabase.questionDao().getAllQuestion()

    fun getDiagnosis(diagnosisIdList: List<String>): String {
        return when {
            // Stress sangat berat
            diagnosisIdList.containsAll(
                listOf(
                    "G09",
                    "G11",
                    "G13",
                    "G14",
                    "G17",
                    "G19",
                    "G21",
                    "G26",
                    "G31",
                    "G33",
                    "G34",
                    "G35",
                    "G39",
                    "G40",
                )
            ) -> stressLevelList.find { it.id == "T04" }?.stressLevel ?: ""

            // Stress berat
            diagnosisIdList.containsAll(
                listOf(
                    "G01",
                    "G03",
                    "G05",
                    "G08",
                    "G12",
                    "G18",
                    "G20",
                    "G22",
                    "G24",
                    "G25",
                    "G28",
                    "G29",
                    "G30",
                    "G36",
                    "G38",
                    )
            ) -> stressLevelList.find { it.id == "T03" }?.stressLevel ?: ""

            // Stress sedang
            diagnosisIdList.containsAll(
                listOf(
                    "G02",
                    "G04",
                    "G07",
                    "G10",
                    "G15",
                    "G16",
                    "G23",
                    "G37",
                )
            ) -> stressLevelList.find { it.id == "T02" }?.stressLevel ?: ""

            // Stress ringan
            diagnosisIdList.containsAll(
                listOf(
                    "G06",
                    "G32"
                )
            ) -> stressLevelList.find { it.id == "T01" }?.stressLevel ?: ""

            // Stress ringan
            diagnosisIdList.size <= 10 -> stressLevelList.find { it.id == "T01" }?.stressLevel ?: ""

            // Stress sedang
            diagnosisIdList.size <= 20 -> stressLevelList.find { it.id == "T02" }?.stressLevel ?: ""

            // Stress berat
            diagnosisIdList.size <= 30 -> stressLevelList.find { it.id == "T03" }?.stressLevel ?: ""

            // Stress sangat berat
            diagnosisIdList.size > 30 -> stressLevelList.find { it.id == "T04" }?.stressLevel ?: ""

            else -> "Terjadi kesalahan"
        }
    }

}