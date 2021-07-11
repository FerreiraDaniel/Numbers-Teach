package com.dferreira.numbers_teach.domain_layer.use_case.take_lesson

import com.dferreira.numbers_teach.domain_layer.entity.Slide
import com.dferreira.numbers_teach.domain_layer.entity.SlideData
import com.dferreira.numbers_teach.domain_layer.entity.SupportedLanguageEnum

sealed class TakeLessonState(
    val languageSelected: SupportedLanguageEnum,
    val autoPlayNewSlide: Boolean
) : ITakeLessonState

data class NotStarted(
    private val privateLanguageSelected: SupportedLanguageEnum,
    private val privateAutoPlayNewSlide: Boolean
) :
    TakeLessonState(privateLanguageSelected, privateAutoPlayNewSlide) {

    override fun copyState(autoPlayNewSlide: Boolean): TakeLessonState {
        return copy(privateAutoPlayNewSlide = autoPlayNewSlide)
    }
}

data class LoadingSlideList(
    private val privateLanguageSelected: SupportedLanguageEnum,
    private val privateAutoPlayNewSlide: Boolean
) : TakeLessonState(
    privateLanguageSelected,
    privateAutoPlayNewSlide
) {

    override fun copyState(autoPlayNewSlide: Boolean): TakeLessonState {
        return copy(privateAutoPlayNewSlide = autoPlayNewSlide)
    }
}

sealed class SealedSlideListLoaded(
    privateLanguageSelected: SupportedLanguageEnum,
    privateAutoPlayNewSlide: Boolean,
    val slideList: List<Slide>,
    val currentSlide: Slide
) : TakeLessonState(
    privateLanguageSelected,
    privateAutoPlayNewSlide
)

data class SlideListLoaded(
    private val privateLanguageSelected: SupportedLanguageEnum,
    private val privateAutoPlayNewSlide: Boolean,
    private val privateSlideList: List<Slide>,
    private val privateCurrentSlide: Slide
) : SealedSlideListLoaded(
    privateLanguageSelected,
    privateAutoPlayNewSlide,
    privateSlideList,
    privateCurrentSlide
) {

    override fun copyState(autoPlayNewSlide: Boolean): TakeLessonState {
        return copy(privateAutoPlayNewSlide = autoPlayNewSlide)
    }
}

data class LoadingSlideData(
    private val privateLanguageSelected: SupportedLanguageEnum,
    private val privateAutoPlayNewSlide: Boolean,
    private val privateSlideList: List<Slide>,
    private val privateCurrentSlide: Slide
) : SealedSlideListLoaded(
    privateLanguageSelected,
    privateAutoPlayNewSlide,
    slideList = privateSlideList,
    currentSlide = privateCurrentSlide
) {

    override fun copyState(autoPlayNewSlide: Boolean): TakeLessonState {
        return copy(privateAutoPlayNewSlide = autoPlayNewSlide)
    }
}

sealed class SealedSlideDataLoaded(
    private val privateLanguageSelected: SupportedLanguageEnum,
    private val privateAutoPlayNewSlide: Boolean,
    private val privateSlideList: List<Slide>,
    private val privateCurrentSlide: Slide,
    val slideData: SlideData
) : SealedSlideListLoaded(
    privateLanguageSelected,
    privateAutoPlayNewSlide,
    privateSlideList,
    privateCurrentSlide
)

data class SlideDataLoaded(
    private val privateLanguageSelected: SupportedLanguageEnum,
    private val privateAutoPlayNewSlide: Boolean,
    private val privateSlideList: List<Slide>,
    private val privateCurrentSlide: Slide,
    private val privateSlideData: SlideData
) : SealedSlideDataLoaded(
    privateLanguageSelected,
    privateAutoPlayNewSlide,
    privateSlideList,
    privateCurrentSlide,
    privateSlideData
) {

    override fun copyState(autoPlayNewSlide: Boolean): TakeLessonState {
        return copy(privateAutoPlayNewSlide = autoPlayNewSlide)
    }
}

data class PlayingSlide(
    private val privateLanguageSelected: SupportedLanguageEnum,
    private val privateAutoPlayNewSlide: Boolean,
    private val privateSlideList: List<Slide>,
    private val privateCurrentSlide: Slide,
    private val privateSlideData: SlideData
) : SealedSlideDataLoaded(
    privateLanguageSelected,
    privateAutoPlayNewSlide,
    privateSlideList,
    privateCurrentSlide,
    privateSlideData
) {

    override fun copyState(autoPlayNewSlide: Boolean): TakeLessonState {
        return copy(privateAutoPlayNewSlide = autoPlayNewSlide)
    }
}

data class SlidePlayed(
    private val privateLanguageSelected: SupportedLanguageEnum,
    private val privateAutoPlayNewSlide: Boolean,
    private val privateSlideList: List<Slide>,
    private val privateCurrentSlide: Slide,
    private val privateSlideData: SlideData
) : SealedSlideDataLoaded(
    privateLanguageSelected,
    privateAutoPlayNewSlide,
    privateSlideList,
    privateCurrentSlide,
    privateSlideData
) {

    override fun copyState(autoPlayNewSlide: Boolean): TakeLessonState {
        return copy(privateAutoPlayNewSlide = autoPlayNewSlide)
    }
}

data class Completed(
    private val privateLanguageSelected: SupportedLanguageEnum,
    private val privateAutoPlayNewSlide: Boolean
) :
    TakeLessonState(privateLanguageSelected, privateAutoPlayNewSlide) {

    override fun copyState(autoPlayNewSlide: Boolean): TakeLessonState {
        return copy(privateAutoPlayNewSlide = autoPlayNewSlide)
    }
}