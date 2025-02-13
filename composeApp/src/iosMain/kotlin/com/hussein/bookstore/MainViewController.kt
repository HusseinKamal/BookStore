package com.hussein.bookstore

import androidx.compose.ui.window.ComposeUIViewController
import com.hussein.bookstore.app.App
import com.hussein.bookstore.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }