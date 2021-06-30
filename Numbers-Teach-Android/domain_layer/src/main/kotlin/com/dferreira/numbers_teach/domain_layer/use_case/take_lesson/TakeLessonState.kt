package com.dferreira.numbers_teach.domain_layer.use_case.take_lesson

import com.dferreira.numbers_teach.domain_layer.entity.Slide
import com.dferreira.numbers_teach.domain_layer.entity.SlideData
import com.dferreira.numbers_teach.domain_layer.entity.SupportedLanguageEnum

sealed class TakeLessonState(
    val languageSelected: SupportedLanguageEnum,
    val autoPlayNewSlide: Boolean
)

data class NotStarted(
    private val privateLanguageSelected: SupportedLanguageEnum,
    private val privateAutoPlayNewSlide: Boolean
) :
    TakeLessonState(privateLanguageSelected, privateAutoPlayNewSlide)

data class LoadingSlideList(
    private val privateLanguageSelected: SupportedLanguageEnum,
    private val privateAutoPlayNewSlide: Boolean
) : TakeLessonState(
    privateLanguageSelected,
    privateAutoPlayNewSlide
)

sealed class SealedSlideListLoaded(
    val slideList: List<Slide>,
    val currentSlide: Slide,
    privateLanguageSelected: SupportedLanguageEnum,
    privateAutoPlayNewSlide: Boolean
) : TakeLessonState(
    privateLanguageSelected,
    privateAutoPlayNewSlide
)

data class SlideListLoaded(
    private val privateSlideList: List<Slide>,
    private val privateCurrentSlide: Slide,
    private val privateLanguageSelected: SupportedLanguageEnum,
    private val privateAutoPlayNewSlide: Boolean
) : SealedSlideListLoaded(
    privateSlideList,
    privateCurrentSlide,
    privateLanguageSelected,
    privateAutoPlayNewSlide
)

data class LoadingSlideData(
    private val privateSlideList: List<Slide>,
    private val privateCurrentSlide: Slide,
    private val privateLanguageSelected: SupportedLanguageEnum,
    private val privateAutoPlayNewSlide: Boolean
) : SealedSlideListLoaded(
    slideList = privateSlideList,
    currentSlide = privateCurrentSlide,
    privateLanguageSelected,
    privateAutoPlayNewSlide
)

sealed class SealedSlideDataLoaded(
    val slideData: SlideData,
    private val privateSlideList: List<Slide>,
    private val privateCurrentSlide: Slide,
    private val privateLanguageSelected: SupportedLanguageEnum,
    private val privateAutoPlayNewSlide: Boolean
) : SealedSlideListLoaded(
    privateSlideList,
    privateCurrentSlide,
    privateLanguageSelected,
    privateAutoPlayNewSlide
)

data class SlideDataLoaded(
    private val privateSlideData: SlideData,
    private val privateSlideList: List<Slide>,
    private val privateCurrentSlide: Slide,
    private val privateLanguageSelected: SupportedLanguageEnum,
    private val privateAutoPlayNewSlide: Boolean
) : SealedSlideDataLoaded(
    privateSlideData,
    privateSlideList,
    privateCurrentSlide,
    privateLanguageSelected,
    privateAutoPlayNewSlide
)

data class PlayingSlide(
    private val privateSlideData: SlideData,
    private val privateSlideList: List<Slide>,
    private val privateCurrentSlide: Slide,
    private val privateLanguageSelected: SupportedLanguageEnum,
    private val privateAutoPlayNewSlide: Boolean
) : SealedSlideDataLoaded(
    privateSlideData,
    privateSlideList,
    privateCurrentSlide,
    privateLanguageSelected,
    privateAutoPlayNewSlide
)

data class SlidePlayed(
    private val privateSlideData: SlideData,
    private val privateSlideList: List<Slide>,
    private val privateCurrentSlide: Slide,
    private val privateLanguageSelected: SupportedLanguageEnum,
    private val privateAutoPlayNewSlide: Boolean
) : SealedSlideDataLoaded(
    privateSlideData,
    privateSlideList,
    privateCurrentSlide,
    privateLanguageSelected,
    privateAutoPlayNewSlide
)

data class Completed(
    private val privateLanguageSelected: SupportedLanguageEnum,
    private val privateAutoPlayNewSlide: Boolean
) :
    TakeLessonState(privateLanguageSelected, privateAutoPlayNewSlide)