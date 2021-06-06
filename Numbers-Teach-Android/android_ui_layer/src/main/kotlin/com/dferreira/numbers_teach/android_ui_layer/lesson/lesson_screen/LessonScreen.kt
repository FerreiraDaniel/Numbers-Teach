package com.dferreira.numbers_teach.android_ui_layer.lesson.lesson_screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.dferreira.numbers_teach.android_ui_layer.R
import com.dferreira.numbers_teach.android_ui_layer.lesson.player_menu.PlayerMenu
import com.dferreira.numbers_teach.android_ui_layer.lesson.player_menu.PlayerMenuState
import com.dferreira.numbers_teach.android_ui_layer.lesson.slide_list_item.SlideListItem
import com.dferreira.numbers_teach.android_ui_layer.theme.Color
import com.dferreira.numbers_teach.android_ui_layer.theme.Size

@Preview(name = "Lesson screen")
@Composable
fun PreviewLessonScreen() {
    val menuState = PlayerMenuState("XX20", false)
    val lessonScreenState = LessonScreenState(menuState)
    LessonScreen(
        lessonScreenState,
        onClickReplay = {},
        onClickBack = { },
        onClickMiddle = { },
        onClickForward = {}
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LessonScreen(
    state: LessonScreenState,
    onClickReplay: () -> Unit,
    onClickBack: () -> Unit,
    onClickMiddle: () -> Unit,
    onClickForward: () -> Unit
) {
    Scaffold(
        content = {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .background(Color.white)
                    .padding(end = Size.smallBorder,
                    bottom = Size.smallBorder
                    )
            ) {
                val state = rememberLazyListState()
                val itemCount = 100

                Column {
                    LazyRow(
                        state = state
                    ) {
                        items(itemCount) { x ->
                            SlideListItem("title$x",
                                painterResource(R.drawable.white_drop_icon)
                                )
                        }
                    }
                }
            }
        },
        bottomBar = {
            val menuState = state.playerMenuState
            PlayerMenu(
                state = menuState,
                onClickReplay = onClickReplay,
                onClickBack = onClickBack,
                onClickMiddle = onClickMiddle,
                onClickForward = onClickForward
            )
        })

}
