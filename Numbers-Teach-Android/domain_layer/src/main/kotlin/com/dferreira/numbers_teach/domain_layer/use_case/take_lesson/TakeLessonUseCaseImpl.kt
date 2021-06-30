package com.dferreira.numbers_teach.domain_layer.use_case.take_lesson

import com.dferreira.numbers_teach.domain_layer.entity.SupportedLanguageEnum
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TakeLessonUseCaseImpl(
    private val languageSelected: SupportedLanguageEnum,
    private val autoPlayNewSlide: Boolean
    ) :
    TakeLessonUseCase {

    private val stateFactory = TakeLessonStateFactory()

    private var _state: MutableStateFlow<TakeLessonState> = MutableStateFlow(
        stateFactory.createNotStarted(
            languageSelected,
            autoPlayNewSlide
            )
    )

    override val state: StateFlow<TakeLessonState>
        get() = _state

    private fun currentState() = _state.value

    override suspend fun startLesson(language: SupportedLanguageEnum) {
        var latestState = currentState()
        val newState = stateFactory.createLoadingSlideList(
            languageSelected,
            autoPlayNewSlide
        )
        this._state.value = newState
    }
}