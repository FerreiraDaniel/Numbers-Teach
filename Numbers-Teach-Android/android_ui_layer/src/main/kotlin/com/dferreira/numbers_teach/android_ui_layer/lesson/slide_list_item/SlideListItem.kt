package com.dferreira.numbers_teach.android_ui_layer.lesson.slide_list_item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.dferreira.numbers_teach.android_ui_layer.R
import com.dferreira.numbers_teach.android_ui_layer.theme.Color
import com.dferreira.numbers_teach.android_ui_layer.theme.Shape.smallRoundedCornerShape
import com.dferreira.numbers_teach.android_ui_layer.theme.Size.smallBorder

@Preview(name = "Slide list item")
@Composable
private fun PreviewSlideListItem() {
    SlideListItem(
        "New title",
        painterResource(R.drawable.white_drop_icon)
    )
}

@Composable
fun SlideListItem(
    title: String,
    painter: Painter
) {
    Box(modifier = Modifier
        .wrapContentSize(Alignment.Center)
        .fillMaxSize()
        .padding(smallBorder)
        .clip(smallRoundedCornerShape)
        .background(Color.greenCard)
    ) {
        Image(
            painter = painter,
            contentDescription =  title,
            modifier = Modifier.fillMaxSize()
                .background(Color.greenCard)
        )
        Text(
            text = title,
            color = Color.grey,
            modifier = Modifier
                .align(alignment = Alignment.Center)
        )
    }
}