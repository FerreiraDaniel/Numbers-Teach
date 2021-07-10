package com.dferreira.numbers_teach.domain_layer.entity

class FakeSlideDataFactory {
    private val byteArraySize = 1024

    private val fakeTitle = "Fake slide title"
    private val fakePictureData = ByteArray(byteArraySize)
    private val fakeAudioData = ByteArray(byteArraySize)

    fun createSlideData(): SlideData {
        return SlideData(
            fakeTitle,
            fakePictureData,
            fakeAudioData
        )
    }
}