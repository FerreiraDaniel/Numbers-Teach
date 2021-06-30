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
        slideList: List<Slide>,
        currentSlide: Slide,
        languageSelected: SupportedLanguageEnum,
        autoPlayNewSlide: Boolean
    ): SlideListLoaded {
        return SlideListLoaded(
            slideList,
            currentSlide,
            languageSelected,
            autoPlayNewSlide
        )
    }

    fun createLoadingSlideData(
        slideList: List<Slide>,
        currentSlide: Slide,
        languageSelected: SupportedLanguageEnum,
        autoPlayNewSlide: Boolean
    ): LoadingSlideData {
        return LoadingSlideData(
            slideList,
            currentSlide,
            languageSelected,
            autoPlayNewSlide
        )
    }


    fun createSlideDataLoaded(
        slideData: SlideData,
        slideList: List<Slide>,
        currentSlide: Slide,
        languageSelected: SupportedLanguageEnum,
        autoPlayNewSlide: Boolean
    ): SlideDataLoaded {
        return SlideDataLoaded(
            slideData,
            slideList,
            currentSlide,
            languageSelected,
            autoPlayNewSlide
        )
    }

    fun createPlayingSlide(
        slideData: SlideData,
        slideList: List<Slide>,
        currentSlide: Slide,
        languageSelected: SupportedLanguageEnum,
        autoPlayNewSlide: Boolean
    ): PlayingSlide {
        return PlayingSlide(
            slideData,
            slideList,
            currentSlide,
            languageSelected,
            autoPlayNewSlide
        )
    }

    fun createSlidePlayed(
        slideData: SlideData,
        slideList: List<Slide>,
        currentSlide: Slide,
        languageSelected: SupportedLanguageEnum,
        autoPlayNewSlide: Boolean
    ): SlidePlayed {
        return SlidePlayed(
            slideData,
            slideList,
            currentSlide,
            languageSelected,
            autoPlayNewSlide
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