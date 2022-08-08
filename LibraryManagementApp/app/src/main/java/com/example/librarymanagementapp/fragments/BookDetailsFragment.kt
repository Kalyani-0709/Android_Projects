package com.example.librarymanagementapp.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.librarymanagementapp.*
import com.example.librarymanagementapp.book.BookList


class BookDetailsFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.activity_info,container, false)

        val imgBtn = view.findViewById<Button>(R.id.book_details_btn)

        imgBtn.setOnClickListener {
            val intent = Intent (requireContext(), BookList::class.java)
            startActivity(intent)
        }

        return view
    }
}
