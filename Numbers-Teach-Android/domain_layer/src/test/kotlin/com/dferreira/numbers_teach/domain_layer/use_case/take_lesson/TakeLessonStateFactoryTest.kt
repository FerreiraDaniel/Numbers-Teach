package com.dferreira.numbers_teach.domain_layer.use_case.take_lesson

import com.dferreira.numbers_teach.domain_layer.entity.SupportedLanguageEnum
import org.junit.jupiter.api.Test
import kotlin.test.assertNotNull
import kotlin.test.assertEquals

class TakeLessonStateFactoryTest {


    @Test
    fun `Can create not started state`() {
        val factory = createFactory()
        val notStarted = factory.createNotStarted(
            createLanguageSelected(),
            createAutoPlayNewSlide()
        )
        assertNotNull(notStarted)
        assertEquals(createLanguageSelected(), notStarted.languageSelected)
        assertEquals(createAutoPlayNewSlide(), notStarted.autoPlayNewSlide)
    }

    private fun createFactory() = TakeLessonStateFactory()

    private fun createLanguageSelected() = SupportedLanguageEnum.English

    private fun createAutoPlayNewSlide() = true
}