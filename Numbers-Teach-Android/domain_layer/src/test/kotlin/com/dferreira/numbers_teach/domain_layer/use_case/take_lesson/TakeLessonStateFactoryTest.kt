package com.dferreira.numbers_teach.domain_layer.use_case.take_lesson

import com.dferreira.numbers_teach.domain_layer.entity.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import kotlin.test.assertNotNull
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TakeLessonStateFactoryTest {

    private val factory = createFactory()
    private val slideFactory = FakeSlideFactory()

    @Test
    fun `Can create not started state`() {
        val notStarted = factory.createNotStarted(
            createLanguageSelected(),
            createAutoPlayNewSlide()
        )
        notStarted.assertBasicInformation()
        assertTrue(notStarted is NotStarted)
    }

    @Test
    fun `Can create loading slide list`() {
        val loadingSlideList = factory.createLoadingSlideList(
            createLanguageSelected(),
            createAutoPlayNewSlide()
        )
        loadingSlideList.assertBasicInformation()
        assertTrue(loadingSlideList is LoadingSlideList)
    }

    @Test
    fun `Can create slide list loaded`() {
        val slideList = createSlideList()
        val slide = createSlide()
        val slideListLoaded = factory.createSlideListLoaded(
            createLanguageSelected(),
            createAutoPlayNewSlide(),
            slideList,
            slide
        )
        slideListLoaded.assertBasicInformation()
        assertTrue(slideListLoaded is SlideListLoaded)
        assertEquals(slideList, slideListLoaded.slideList)
        assertEquals(slide, slideListLoaded.currentSlide)
    }

    @Test
    fun `Can create loading slide data`() {
        val slideList = createSlideList()
        val slide = createSlide()
        val loadingSlideData = factory.createLoadingSlideData(
            createLanguageSelected(),
            createAutoPlayNewSlide(),
            slideList,
            slide
        )
        loadingSlideData.assertBasicInformation()
        assertTrue(loadingSlideData is LoadingSlideData)
        loadingSlideData.assertSlideList(slideList)
        loadingSlideData.assertCurrentSlide(slide)
    }

    @Test
    fun `Can create slide data loaded`() {
        val slideList = createSlideList()
        val slide = createSlide()
        val slideData = createSlideData()
        val slideDataLoaded = factory.createSlideDataLoaded(
            createLanguageSelected(),
            createAutoPlayNewSlide(),
            slideList,
            slide,
            slideData
        )
        slideDataLoaded.assertBasicInformation()
        assertTrue(slideDataLoaded is SlideDataLoaded)
        slideDataLoaded.assertSlideList(slideList)
        slideDataLoaded.assertCurrentSlide(slide)
        assertEquals(slideData, slideDataLoaded.slideData)
    }

    @Test
    fun `Can create playing slide`() {
        val slideList = createSlideList()
        val slide = createSlide()
        val slideData = createSlideData()
        val slideDataLoaded = factory.createPlayingSlide(
            createLanguageSelected(),
            createAutoPlayNewSlide(),
            slideList,
            slide,
            slideData
        )
        slideDataLoaded.assertBasicInformation()
        assertTrue(slideDataLoaded is PlayingSlide)
        slideDataLoaded.assertSlideList(slideList)
        slideDataLoaded.assertCurrentSlide(slide)
        assertEquals(slideData, slideDataLoaded.slideData)
    }

    @Test
    fun `Can create slide played`() {
        val slideList = createSlideList()
        val slide = createSlide()
        val slideData = createSlideData()
        val slidePlayed = factory.createSlidePlayed(
            createLanguageSelected(),
            createAutoPlayNewSlide(),
            slideList,
            slide,
            slideData
        )
        slidePlayed.assertBasicInformation()
        assertTrue(slidePlayed is SlidePlayed)
        slidePlayed.assertSlideList(slideList)
        slidePlayed.assertCurrentSlide(slide)
        assertEquals(slideData, slidePlayed.slideData)
    }

    @Test
    fun `Can create completed`() {

        val completed = factory.createCompleted(
            createLanguageSelected(),
            createAutoPlayNewSlide()
        )
        completed.assertBasicInformation()
        assertTrue(completed is Completed)
    }

    private fun createSlideData(): SlideData {
        val slideDataFactory = FakeSlideDataFactory()
        return slideDataFactory.createSlideData()
    }

    private fun createFactory() = TakeLessonStateFactory()

    private fun createLanguageSelected() = SupportedLanguageEnum.English

    private fun createAutoPlayNewSlide() = true

    private fun createSlideList(): List<Slide> {
        return slideFactory.createSlideList()
    }

    private fun createSlide(): Slide {
        return slideFactory.createSlide()
    }

    private fun TakeLessonState?.assertBasicInformation() {
        assertNotNull(this)
        assertEquals(createLanguageSelected(), this.languageSelected)
        assertEquals(createAutoPlayNewSlide(), this.autoPlayNewSlide)
    }

    private fun SealedSlideListLoaded.assertSlideList(slideList: List<Slide>) {
        assertEquals(slideList, this.slideList)
    }

    private fun SealedSlideListLoaded.assertCurrentSlide(slide: Slide) {
        assertEquals(slide, this.currentSlide)
    }
}


