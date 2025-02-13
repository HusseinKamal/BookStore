package com.hussein.bookstore

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.hussein.bookstore.app.App
import com.hussein.bookstore.di.initKoin

fun main() {
    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "BookStore",
        ) {
            App()
        }
    }
}