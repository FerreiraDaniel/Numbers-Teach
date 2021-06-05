package com.dferreira.numbers_teach_ui_layer

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import presenter.ITakeLessonUIPresenter
import use_case.take_lesson.ITakeLessonUIEventHandler

class WindowTest : IWindowTest, ITakeLessonUIPresenter {
    private var showLessonScreen by mutableStateOf(false)

    override fun showLessonScreen() {
        println("Show redraw")
        showLessonScreen = true
    }

    override fun setEventsHandler(eventHandler: ITakeLessonUIEventHandler) {
        print("Setting events handler")
    }

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    override fun mainUiLayer() {
        var text by remember { mutableStateOf("Hello, World!") }


        MaterialTheme {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(text = "Bottom app bar example")
                        },

                        navigationIcon = {
                            IconButton(
                                onClick = {
                                    println("test")
                                }
                            ) {
                                Icon(Icons.Filled.Menu, contentDescription = "content description")
                            }
                        },

                        backgroundColor = Color(0xFF00CC99),
                        elevation = AppBarDefaults.TopAppBarElevation
                    )
                },
                content = {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color(0xff0000))
                    ) {
                        if (showLessonScreen) {


                            val state = rememberLazyListState()
                            val itemCount = 100

                            Column {
                                LazyRow(Modifier
                                    .fillMaxHeight()
                                    .padding(end = 12.dp), state) {
                                    items(itemCount) { x ->
                                        Canvas(modifier = Modifier.fillMaxSize()){
                                            val canvasWidth = size.width
                                            val canvasHeight = size.height
                                            drawCircle(
                                                color = Color.Blue,
                                                center = Offset(x = canvasWidth / 2, y = canvasHeight / 2),
                                                radius = size.minDimension / 4
                                            )
                                        }
                                        Text(
                                            modifier = Modifier.fillMaxHeight(),
                                            text = "Item in ScrollableColumn #$x")
                                        Spacer(modifier = Modifier.height(5.dp))

                                    }
                                }
                            }


                        } else Text("Nothing to show")
                    }
                },
                bottomBar = {
                    playerMenu()
                })
        }

    }

    @Composable
    private fun playerMenu() {
        BottomAppBar(
        ) {
            Button(onClick = {
                print("Back")
            }) {
                Text("Back")
            }
            Button(onClick = {
                print("Pause")
            }) {
                Text("Pause")
            }
            Button(onClick = {
                print("Next")
            }) {
                Text("Next")
            }
        }
    }
}