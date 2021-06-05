package com.dferreira.numbers_teach.android_ui_layer.lesson.slide_list_item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.dferreira.numbers_teach.android_ui_layer.R
import com.dferreira.numbers_teach.android_ui_layer.theme.Color

@Preview(name = "Slide list item")
@Composable
private fun PreviewSlideListItem() {
    SlideListItem()
}

@Composable
fun SlideListItem() {
    Box(modifier = Modifier
        .background(Color.greenCard)
    ) {
        Image(
            painter = painterResource(R.drawable.ic_skip_next_white_48dp),
            contentDescription =  stringResource(R.string.back_button_label),
            modifier = Modifier.fillMaxSize()
                .background(Color.greenCard)
        )
        Text("Title")
    }
}