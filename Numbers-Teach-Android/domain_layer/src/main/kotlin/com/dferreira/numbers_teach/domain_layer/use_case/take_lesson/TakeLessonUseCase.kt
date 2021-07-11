package com.dferreira.numbers_teach.domain_layer.use_case.take_lesson

import kotlinx.coroutines.flow.StateFlow

interface TakeLessonUseCase: TakeLessonUIEventHandler {

    val state: StateFlow<TakeLessonState>

    suspend fun setAutoPlayNewSlide(autoPlayNewSlide: Boolean)

    suspend fun startLesson()
}