package com.haa.diagnosabullying.data.repository

import android.content.Context
import com.google.gson.Gson
import com.haa.diagnosabullying.R
import com.haa.diagnosabullying.data.resource.local.model.DiagnosisModel
import com.haa.diagnosabullying.data.resource.local.room.entity.DiagnosisEntity
import com.haa.diagnosabullying.data.resource.local.room.AppDatabase
import com.haa.diagnosabullying.helper.readJsonFromRaw
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class QuestionRepository @Inject constructor(
    private val appDatabase: AppDatabase,
    @ApplicationContext private val context: Context,
) {
    private val diagnosisEntityLists: List<DiagnosisModel> = Gson().fromJson(
        readJsonFromRaw(context, R.raw.stress_level),
        Array<DiagnosisModel>::class.java
    ).toList()

    suspend fun getAllQuestion() = appDatabase.questionDao().getAllQuestion()

    suspend fun saveDiagnosis(diagnosisEntity: DiagnosisEntity) =
        appDatabase.diagnosisDao().insert(diagnosisEntity)

    suspend fun getAllDiagnosis() = appDatabase.diagnosisDao().getAll()

    suspend fun getDiagnosisById(id: Int) =
        appDatabase.diagnosisDao().getById(id)

    fun calculateDiagnosis(diagnosisIdList: List<String>) = when {
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
        ) -> diagnosisEntityLists.find { it.id == "T04" }

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
        ) -> diagnosisEntityLists.find { it.id == "T03" }

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
        ) -> diagnosisEntityLists.find { it.id == "T02" }

        // Stress ringan
        diagnosisIdList.containsAll(
            listOf(
                "G06",
                "G32"
            )
        ) -> diagnosisEntityLists.find { it.id == "T01" }

        // Stress ringan
        diagnosisIdList.size <= 10 -> diagnosisEntityLists.find { it.id == "T01" }

        // Stress sedang
        diagnosisIdList.size <= 20 -> diagnosisEntityLists.find { it.id == "T02" }

        // Stress berat
        diagnosisIdList.size <= 30 -> diagnosisEntityLists.find { it.id == "T03" }

        // Stress sangat berat
        diagnosisIdList.size > 30 -> diagnosisEntityLists.find { it.id == "T04" }

        else -> null
    }
}