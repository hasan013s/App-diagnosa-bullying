package com.haa.diagnosabullying.ui.screen.result

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.haa.diagnosabullying.data.repository.QuestionRepository
import com.haa.diagnosabullying.data.resource.local.room.entity.QuestionEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResultViewModel @Inject constructor(
    private val questionRepository: QuestionRepository,
) : ViewModel() {
    fun getDiagnosis(diagnosisList: List<String>) =
        questionRepository.getDiagnosis(diagnosisList)
}