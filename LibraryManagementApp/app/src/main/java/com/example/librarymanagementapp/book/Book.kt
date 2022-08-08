package com.example.librarymanagementapp.book

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book_table")
data class Book(
    @PrimaryKey @ColumnInfo(name="bookName")val bookName: String,
    @ColumnInfo(name="bookNumber")val bookNumber:Int,
    @ColumnInfo(name="author") val authorName: String,
    @ColumnInfo(name="quantity")val quantity:Int
)

