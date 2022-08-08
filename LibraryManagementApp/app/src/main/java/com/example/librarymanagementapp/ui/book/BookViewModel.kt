package com.example.librarymanagementapp.ui.book

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.librarymanagementapp.book.Book
import com.example.librarymanagementapp.book.BookRepository
import kotlinx.coroutines.launch

open class BookViewModel constructor (private val repository: BookRepository) : ViewModel() {

    val allBooks: LiveData<List<Book>> = repository.allBooks.asLiveData()

    fun insert(book: Book) = viewModelScope.launch {
        repository.insert(book)
    }
}