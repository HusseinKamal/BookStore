package com.hussein.bookstore.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.hussein.bookstore.book.data.database.DatabaseFactory
import com.hussein.bookstore.book.data.database.FavoriteBookDatabase
import com.hussein.bookstore.book.data.network.KtorRemoteBookDataSource
import com.hussein.bookstore.book.data.network.RemoteBookDataSource
import com.hussein.bookstore.book.data.repository.DefaultBookRepository
import com.hussein.bookstore.book.domain.BookRepository
import com.hussein.bookstore.book.presentation.SelectedBookViewModel
import com.hussein.bookstore.book.presentation.book_detail.BookDetailViewModel
import com.hussein.bookstore.core.data.HttpClientFactory
import org.koin.core.module.Module
import org.koin.dsl.module
import com.hussein.bookstore.book.presentation.book_list.BookListViewModel
import org.koin.core.module.dsl.viewModel

expect val platformModule: Module

val sharedModule = module {
    single { HttpClientFactory.create(get()) }

    // Use single() for the datasource and repository
    single<RemoteBookDataSource> { KtorRemoteBookDataSource(get()) } // <-- Crucial dependency injection!
    single<BookRepository> { DefaultBookRepository(get(), get()) } // <-- Get the DataSource and Database!

    single {
        get<DatabaseFactory>().create()
            .setDriver(BundledSQLiteDriver())
            .build()
    }
    single { get<FavoriteBookDatabase>().favoriteBookDao }

    viewModel{ BookListViewModel(get()) }
    viewModel{ BookDetailViewModel(get(),get()) }
    viewModel{ SelectedBookViewModel() }
}