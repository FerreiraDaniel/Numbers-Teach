package com.dferreira.numbers_teach.domain_layer.entity


data class SlideData(
    val title: String,
    val pictureData: ByteArray,
    val audioData: ByteArray
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as SlideData

        return title == other.title

    }

    override fun hashCode(): Int {
        return title.hashCode()
    }
}
