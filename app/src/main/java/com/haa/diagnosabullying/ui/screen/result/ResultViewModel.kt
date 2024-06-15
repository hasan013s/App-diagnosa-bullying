package com.haa.diagnosabullying.ui.screen.result

import androidx.lifecycle.ViewModel
import com.haa.diagnosabullying.data.repository.QuestionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ResultViewModel @Inject constructor(
    private val questionRepository: QuestionRepository,
) : ViewModel() {
    fun getDiagnosis(diagnosisList: List<String>) =
        questionRepository.getDiagnosis(diagnosisList)
}