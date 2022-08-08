package com.example.librarymanagementapp.book

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import com.example.librarymanagementapp.R
import kotlin.system.exitProcess


class AdminDashboard : AppCompatActivity() {

    private val context: Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val bookDetailsBtn = findViewById<Button>(R.id.book_details_btn)
        val backBtn = findViewById<ImageButton>(R.id.back_button)


        bookDetailsBtn.setOnClickListener {
            val intent = Intent(this, BookList::class.java)
            startActivity(intent)
        }

        backBtn.setOnClickListener {
           exit()
        }
    }

    private fun exit() {
        val dialogBuilder = AlertDialog.Builder(this)

        // set message of alert dialog
        dialogBuilder.setMessage("Do you want to close this application ?")
            // if the dialog is cancelable
            .setCancelable(false)
            // positive button text and action
            .setPositiveButton("Proceed", DialogInterface.OnClickListener {
                    dialog, id -> moveTaskToBack(true)
                android.os.Process.killProcess(android.os.Process.myPid())
                exitProcess(1)
            })
            // negative button text and action
            .setNegativeButton("Cancel", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })

        // create dialog box
        val alert = dialogBuilder.create()
        // set title for alert dialog box
        alert.setTitle("LibraryManagementSystem")
        // show alert dialog
        alert.show()
    }
}