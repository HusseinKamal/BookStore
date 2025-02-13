package com.hussein.bookstore.book.presentation.book_detail

import com.hussein.bookstore.book.domain.Book

data class BookDetailState(
    val isLoading: Boolean = true,
    val isFavorite: Boolean = false,
    val book: Book? = null
)