package com.haa.diagnosabullying.ui.screen.question

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
class QuestionViewModel @Inject constructor(
    private val questionRepository: QuestionRepository,
) : ViewModel() {

    private val _questionState: MutableStateFlow<List<QuestionEntity>> =
        MutableStateFlow(emptyList())
    val questionState = _questionState.asStateFlow()
    private val _questionSelectedState: MutableStateFlow<Map<String, Boolean>> = MutableStateFlow(
        emptyMap()
    )
    val questionSelectedState = _questionSelectedState.asStateFlow()


    init {
        getAllQuestion()
    }

    fun onQuestionSelectedChange(
        id: String,
        newValue: Boolean,
    ) {
        val currentQuestionSelectedState = questionSelectedState.value.toMutableMap()
        currentQuestionSelectedState[id] = newValue
        _questionSelectedState.tryEmit(currentQuestionSelectedState)
    }

    fun getAllQuestion() = viewModelScope.launch {
        try {
            val question = questionRepository.getAllQuestion()
            _questionState.tryEmit(question)
        } catch (e: Exception) {
            Log.e("error", e.message.toString())
        }
    }
}