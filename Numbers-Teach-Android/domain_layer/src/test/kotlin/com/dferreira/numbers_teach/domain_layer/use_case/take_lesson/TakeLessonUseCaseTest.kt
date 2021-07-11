package com.dferreira.numbers_teach.domain_layer.use_case.take_lesson

import com.dferreira.numbers_teach.domain_layer.entity.SupportedLanguageEnum
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runBlockingTest
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource
import org.junit.jupiter.params.provider.ValueSource
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class TakeLessonUseCaseTest {

    private val fakeLanguage = SupportedLanguageEnum.German
    private val fakeAutoPlay = true

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun `Change autoplay emit a new state`(newAutoPlay: Boolean) = runBlockingTest {
        val useCase = createTakeLessonUseCase()
        useCase.startLesson()
        useCase.setAutoPlayNewSlide(newAutoPlay)
        val state = getLastState(useCase)

        assertEquals(newAutoPlay, state.autoPlayNewSlide)
    }


    @ParameterizedTest
    @EnumSource(SupportedLanguageEnum::class)
    fun `Start lesson triggers loading slide list`(language: SupportedLanguageEnum) = runBlockingTest {
        val useCase = createTakeLessonUseCase(language)
        useCase.startLesson()
        val state = getLastState(useCase)

        assertTrue(state is LoadingSlideList)
    }

    private fun createTakeLessonUseCase(
        languageSelected: SupportedLanguageEnum = fakeLanguage,
        autoPlayNewSlide: Boolean = fakeAutoPlay
    ): TakeLessonUseCase {
        val factory = TakeLessonUseCaseFactory()
        return factory.createTakeLessonUseCase(
            languageSelected,
            autoPlayNewSlide
        )
    }

    private suspend fun CoroutineScope.getLastState(useCase: TakeLessonUseCase): TakeLessonState {
        val stateList: MutableList<TakeLessonState> = arrayListOf()
        val job = launch {
            useCase.state.toList(stateList)
        }
        job.cancelAndJoin()
        return stateList.last()
    }
}