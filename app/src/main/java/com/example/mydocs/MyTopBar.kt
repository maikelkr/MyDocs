package com.example.mydocs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun MyTopBar(){
    //val topMenuItemsList = prepareTopMenu()
    val context = LocalContext.current
    val selectedItem by remember() { mutableStateOf("Home") }
}