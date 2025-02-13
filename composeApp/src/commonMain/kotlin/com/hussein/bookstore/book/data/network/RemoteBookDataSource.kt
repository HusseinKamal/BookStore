package com.hussein.bookstore.book.data.network

import com.hussein.bookstore.book.data.dto.BookWorkDto
import com.hussein.bookstore.book.data.dto.SearchResponseDto
import com.hussein.bookstore.core.domain.DataError
import com.hussein.bookstore.core.domain.Result

interface RemoteBookDataSource {
    suspend fun searchBooks(
        query: String,
        resultLimit: Int? = null
    ): Result<SearchResponseDto, DataError.Remote>

    suspend fun getBookDetails(bookWorkId: String): Result<BookWorkDto, DataError.Remote>
}