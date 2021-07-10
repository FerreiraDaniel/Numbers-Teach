package com.dferreira.numbers_teach.domain_layer.use_case.take_lesson

import com.dferreira.numbers_teach.domain_layer.entity.Slide
import com.dferreira.numbers_teach.domain_layer.entity.SlideData
import com.dferreira.numbers_teach.domain_layer.entity.SupportedLanguageEnum

class TakeLessonStateFactory {

    fun createNotStarted(
        languageSelected: SupportedLanguageEnum,
        autoPlayNewSlide: Boolean
    ): NotStarted {
        return NotStarted(languageSelected, autoPlayNewSlide)
    }


    fun createLoadingSlideList(
        languageSelected: SupportedLanguageEnum,
        autoPlayNewSlide: Boolean
    ): LoadingSlideList {
        return LoadingSlideList(
            languageSelected,
            autoPlayNewSlide
        )
    }

    fun createSlideListLoaded(
        languageSelected: SupportedLanguageEnum,
        autoPlayNewSlide: Boolean,
        slideList: List<Slide>,
        currentSlide: Slide
    ): SlideListLoaded {
        return SlideListLoaded(
            languageSelected,
            autoPlayNewSlide,
            slideList,
            currentSlide
        )
    }

    fun createLoadingSlideData(
        languageSelected: SupportedLanguageEnum,
        autoPlayNewSlide: Boolean,
        slideList: List<Slide>,
        currentSlide: Slide
    ): LoadingSlideData {
        return LoadingSlideData(
            languageSelected,
            autoPlayNewSlide,
            slideList,
            currentSlide
        )
    }


    fun createSlideDataLoaded(
        languageSelected: SupportedLanguageEnum,
        autoPlayNewSlide: Boolean,
        slideList: List<Slide>,
        currentSlide: Slide,
        slideData: SlideData
    ): SlideDataLoaded {
        return SlideDataLoaded(
            languageSelected,
            autoPlayNewSlide,
            slideList,
            currentSlide,
            slideData
        )
    }

    fun createPlayingSlide(
        languageSelected: SupportedLanguageEnum,
        autoPlayNewSlide: Boolean,
        slideList: List<Slide>,
        currentSlide: Slide,
        slideData: SlideData
    ): PlayingSlide {
        return PlayingSlide(
            languageSelected,
            autoPlayNewSlide,
            slideList,
            currentSlide,
            slideData
        )
    }

    fun createSlidePlayed(
        languageSelected: SupportedLanguageEnum,
        autoPlayNewSlide: Boolean,
        slideList: List<Slide>,
        currentSlide: Slide,
        slideData: SlideData
    ): SlidePlayed {
        return SlidePlayed(
            languageSelected,
            autoPlayNewSlide,
            slideList,
            currentSlide,
            slideData
        )
    }

    fun createCompleted(
        languageSelected: SupportedLanguageEnum,
        autoPlayNewSlide: Boolean
    ): Completed {
        return Completed(
            languageSelected,
            autoPlayNewSlide
        )
    }


}