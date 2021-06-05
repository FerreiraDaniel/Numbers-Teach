package com.dferreira.numbers_teach.android_ui_layer.lesson.player_menu

import androidx.compose.runtime.Immutable

@Immutable
data class PlayerMenuState(
    val leftLabel: String,
    val isPlaying: Boolean
)