package com.dferreira.numbers_teach.domain_layer.use_case.take_lesson

import com.dferreira.numbers_teach.domain_layer.entity.SupportedLanguageEnum

class TakeLessonUseCaseFactory {

    fun createTakeLessonUseCase(
        languageSelected: SupportedLanguageEnum,
        autoPlayNewSlide: Boolean
    ): TakeLessonUseCase {
        return TakeLessonUseCaseImpl(
            languageSelected,
            autoPlayNewSlide
        )
    }
}