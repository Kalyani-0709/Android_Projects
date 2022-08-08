package com.example.librarymanagementapp.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.librarymanagementapp.R
import com.example.librarymanagementapp.book.AdminDashboard


open class LoginFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.layout_login,container, false)

        val userName = view.findViewById<EditText>(R.id.username)
        val password = view.findViewById<EditText>(R.id.password)
        val loginBtn = view.findViewById<Button>(R.id.button_login)
        val resetBtn = view.findViewById<Button>(R.id.button_reset)

        resetBtn.setOnClickListener {
            userName.setText("")
            password.setText("")
        }

        loginBtn.setOnClickListener {
            login(userName, password)
        }

        return view
    }
    private fun login(userName: EditText, password: EditText) {

        if(userName.text.toString() == ("admin") && password.text.toString() == ("admin123")) {
            makeToast("${userName.text} Login successful..!!")
            userName.setText("")
            password.setText("")
            val intent = Intent (requireContext(), AdminDashboard::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }else{
            makeToast("Login unsuccessful..!!")
        }
    }

    private fun Fragment.makeToast(text: String, duration: Int = Toast.LENGTH_LONG) {
        activity?.let {
            Toast.makeText(it, text, duration).show()
        }
    }
}
