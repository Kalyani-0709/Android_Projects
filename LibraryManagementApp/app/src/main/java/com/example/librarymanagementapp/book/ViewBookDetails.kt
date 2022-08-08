package com.example.librarymanagementapp.book

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.example.librarymanagementapp.R

class ViewBookDetails : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_book_details)

        val intent : Intent = intent

        val name = intent.getStringExtra("bookName")
        val quantity = intent.getStringExtra("quantity")
        val number = intent.getStringExtra("bookNumber")
        val author = intent.getStringExtra("author")

        val bookName = findViewById<EditText>(R.id.book_name_details)
        val bookNumber = findViewById<EditText>(R.id.book_number_details)
        val authorName = findViewById<EditText>(R.id.author_details)
        val quantityOfBooks = findViewById<EditText>(R.id.quantity_details)

        bookName.setText(name)
        bookNumber.setText(number)
        authorName.setText(author)
        quantityOfBooks.setText(quantity)


        println("BookName : $name, quantity: $quantity, number: $number, author: $author")

    }
}