package com.dferreira.numbers_teach.lesson

import androidx.compose.material.BottomAppBar
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class ComposeLesson {
    @Preview(name= "playerMenu")
    @Composable
    private fun playerMenu() {
        BottomAppBar {
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