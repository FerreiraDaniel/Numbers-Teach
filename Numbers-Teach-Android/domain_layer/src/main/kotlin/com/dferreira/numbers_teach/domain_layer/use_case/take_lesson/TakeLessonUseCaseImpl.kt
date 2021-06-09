package com.dferreira.numbers_teach.domain_layer.use_case.take_lesson

import kotlinx.coroutines.cancel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.coroutines.coroutineContext

class TakeLessonUseCaseImpl:
    TakeLessonUseCase {

    private val _state = MutableStateFlow("")


    override val state: StateFlow<String>
        get() = _state


    override suspend fun startLesson() {
        repeat (4) {
            _state.emit("daniel")
            delay(100)
            _state.emit("test")
            delay(100)
        }
        coroutineContext.cancel()
    }
}