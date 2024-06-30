package com.haa.diagnosabullying.ui.history

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.haa.diagnosabullying.data.repository.QuestionRepository
import com.haa.diagnosabullying.data.resource.local.room.entity.DiagnosisEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryDiagnosisViewModel @Inject constructor(
    private val questionRepository: QuestionRepository
): ViewModel() {

    init {
        getAllDiagnosis()
    }

    private val _diagnosisListState: MutableStateFlow<List<DiagnosisEntity>> =
        MutableStateFlow(emptyList())
    val diagnosisListState
        get() = _diagnosisListState.asStateFlow()

    private fun getAllDiagnosis() = viewModelScope.launch {
        val diagnosisList = questionRepository.getAllDiagnosis()
        Log.e("allDiagnosis", diagnosisList.size.toString())
        _diagnosisListState.tryEmit(diagnosisList)
    }
}