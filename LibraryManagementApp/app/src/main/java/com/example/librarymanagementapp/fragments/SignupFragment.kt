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
import com.example.librarymanagementapp.book.AdminDashboard
import com.example.librarymanagementapp.R


class SignupFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.layout_signup,container, false)

        val signupBtn = view.findViewById<Button>(R.id.button_signup)
        val username = view.findViewById<EditText>(R.id.edit_signup_username)
        val password = view.findViewById<EditText>(R.id.edit_signup_password)
        val mobile = view.findViewById<EditText>(R.id.edit_signup_mobile)
//        val email = view.findViewById<EditText>(R.id.editSignupEmail)
//
//        val emailRegex = """^([^@]{2})([^@]+)([^@]{0}@)([^@]{4})""".toRegex()
//        fun isEmailValid(email: EditText): Boolean {
//            print("Email ${emailRegex.matches(email.toString())}")
//            return emailRegex.matches(email.toString())
//        }

        signupBtn.setOnClickListener {

            if (username.length()==0){
                username.error = "Invalid Username"
            }else if (password.length()<8) {
                password?.error = "Password length is less than 8 "
            }else if (mobile.length()<10) {
                mobile?.error = "Mobile number length should be 10 "
            }
//            else if(!isEmailValid(email)){
//                email.error = "Invalid Email"
//            }
            else{
                makeToast("Signup successful..!!")
                val intent = Intent (requireContext(), AdminDashboard::class.java)
                startActivity(intent)
            }

        }
        return view
    }

    private fun Fragment.makeToast(text: String, duration: Int = Toast.LENGTH_LONG) {
        activity?.let {
            Toast.makeText(it, text, duration).show()
        }
    }
}
