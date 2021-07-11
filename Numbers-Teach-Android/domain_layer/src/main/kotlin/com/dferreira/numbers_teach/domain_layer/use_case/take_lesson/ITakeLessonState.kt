package com.dferreira.numbers_teach.domain_layer.use_case.take_lesson

interface ITakeLessonState {
    fun copyState(autoPlayNewSlide: Boolean): TakeLessonState
}