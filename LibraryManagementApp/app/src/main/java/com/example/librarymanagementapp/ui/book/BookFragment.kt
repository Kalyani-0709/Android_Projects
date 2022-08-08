package com.example.librarymanagementapp.ui.book

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.librarymanagementapp.book.BookListAdapter
import com.example.librarymanagementapp.R

class BookFragment : Fragment() {


    private val viewModel by viewModels<BookViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        val view : View = inflater.inflate(R.layout.fragment_book, container, false)

        initRecyclerView(view)

        return view
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
////        viewModel = ViewModelProvider(this).get(BookViewModel::class.java)
//
//    }

    private fun initRecyclerView(view: View){

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_book)
        val adapter = BookListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(activity)


        viewModel.allBooks.observe(viewLifecycleOwner) { books ->
            books.let { adapter.submitList(it) }
        }
//        activity?.let {
//            viewModel.allBooks.observe(it) { books ->
//                // Update the cached copy of the words in the adapter.
//                books.let { adapter.submitList( it ) }
//            }
//        }

//        viewModel.allBooks.observe() { books ->
//            // Update the cached copy of the words in the adapter.
//            books.let { adapter.submitList( it ) }
//        }

    }

}