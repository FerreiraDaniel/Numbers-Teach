package com.dferreira.numbers_teach.domain_layer.use_case.take_lesson

import com.dferreira.numbers_teach.domain_layer.entity.SupportedLanguageEnum
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TakeLessonUseCaseImpl(
    initialLanguageSelected: SupportedLanguageEnum,
    initialAutoPlayNewSlide: Boolean
) :
    TakeLessonUseCase {

    private val stateFactory = TakeLessonStateFactory()

    private var _state: MutableStateFlow<TakeLessonState> = MutableStateFlow(
        stateFactory.createNotStarted(
            initialLanguageSelected,
            initialAutoPlayNewSlide
        )
    )

    override val state: StateFlow<TakeLessonState>
        get() = _state



    override suspend fun setAutoPlayNewSlide(autoPlayNewSlide: Boolean) {
        val latestState = currentState()
        val newState = latestState.copyState(autoPlayNewSlide)
        emitState(newState)
    }

    override suspend fun startLesson() {
        val latestState = currentState()
        val newState = stateFactory.createLoadingSlideList(
            latestState.languageSelected,
            latestState.autoPlayNewSlide
        )
        emitState(newState)
    }

    private fun currentState() = _state.value

    private fun emitState(newState: TakeLessonState) {
        this._state.value = newState
    }
}