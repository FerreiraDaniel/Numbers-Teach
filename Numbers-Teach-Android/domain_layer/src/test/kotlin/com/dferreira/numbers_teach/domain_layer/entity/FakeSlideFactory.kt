package com.dferreira.numbers_teach.domain_layer.entity


class FakeSlideFactory {
    private val fakeTitle = "Fake Title"
    private val fakePicturePath = "Fake picture path"
    private val fakeAudioPath = "Fake audio path"
    private val numberSlides = 10

    fun createSlide(): Slide = Slide(
        fakeTitle,
        fakePicturePath,
        fakeAudioPath
    )

    fun createSlideList(): List<Slide> =
        (1..numberSlides).map {
            createSlide()
        }
}