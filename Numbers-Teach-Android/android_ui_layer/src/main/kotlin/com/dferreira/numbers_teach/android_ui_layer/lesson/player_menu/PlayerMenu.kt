package com.dferreira.numbers_teach.android_ui_layer.lesson.player_menu

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.dferreira.numbers_teach.android_ui_layer.R

@Preview(name = "Player menu")
@Composable
private fun PreviewPlayerMenu() {
    val state = PlayerMenuState("XX20", false)
    PlayerMenu(
        state,
        onClickReplay = {},
        onClickBack = { },
        onClickMiddle = { },
        onClickForward = {}
    )
}

@Composable
fun PlayerMenu(
    state: PlayerMenuState,
    onClickReplay: () -> Unit,
    onClickBack: () -> Unit,
    onClickMiddle: () -> Unit,
    onClickForward: () -> Unit
) {
    BottomAppBar {
        PlayerMenuButtons(
            state,
            onClickReplay,
            onClickBack,
            onClickMiddle,
            onClickForward
        )
    }
}


@Preview(name = "Player menu buttons")
@Composable
private fun PreviewPlayerMenuButtons() {
    val state = PlayerMenuState("12/20", true)
    PlayerMenuButtons(
        state,
        onClickReplay = {},
        onClickBack = { },
        onClickMiddle = { },
        onClickForward = {}
    )
}

@Composable
fun PlayerMenuButtons(
    state: PlayerMenuState,
    onClickReplay: () -> Unit,
    onClickBack: () -> Unit,
    onClickMiddle: () -> Unit,
    onClickForward: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = state.leftLabel)
        Button(onClick = onClickReplay) {
            ImageWrapper(R.drawable.ic_replay_white_48dp,
                        R.string.replay_button_label)
        }
        Button(onClick = onClickBack) {
            ImageWrapper(
                R.drawable.ic_skip_previous_white_48dp,
                R.string.back_button_label
            )
        }
        PlayPauseButton(state.isPlaying, onClickMiddle)
        Button(onClick = onClickForward) {
            ImageWrapper(
                R.drawable.ic_skip_next_white_48dp,
                R.string.forward_button_label
            )
        }
    }
}

@Composable
private fun PlayPauseButton(
    isPlaying: Boolean,
    onClickMiddle: () -> Unit
) {
    Button(onClick = onClickMiddle) {
        if (isPlaying) {
            ImageWrapper(
                R.drawable.ic_pause_white_48dp,
                R.string.pause_button_label
            )
        } else {
            ImageWrapper(
                R.drawable.ic_play_arrow_white_48dp,
                R.string.play_button_label
            )
        }
    }
}

@Composable
private fun ImageWrapper(
        @DrawableRes imageResource: Int,
        @StringRes descriptionResource: Int
) {
    Image(
        painter = painterResource(id = imageResource),
        contentDescription =  stringResource(descriptionResource))
}

