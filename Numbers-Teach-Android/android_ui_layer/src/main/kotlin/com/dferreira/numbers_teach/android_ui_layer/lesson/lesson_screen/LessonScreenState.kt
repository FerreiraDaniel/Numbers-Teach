package com.dferreira.numbers_teach.android_ui_layer.lesson.lesson_screen

import androidx.compose.runtime.Immutable
import com.dferreira.numbers_teach.android_ui_layer.lesson.player_menu.PlayerMenuState

@Immutable
data class LessonScreenState(
    val playerMenuState: PlayerMenuState
)
