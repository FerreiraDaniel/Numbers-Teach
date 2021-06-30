package com.dferreira.numbers_teach.domain_layer.use_case.take_lesson

import com.dferreira.numbers_teach.domain_layer.entity.SupportedLanguageEnum
import kotlinx.coroutines.flow.StateFlow

interface TakeLessonUseCase: TakeLessonUIEventHandler {

    val state: StateFlow<TakeLessonState>
    suspend fun startLesson(language: SupportedLanguageEnum)
}