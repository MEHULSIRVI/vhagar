package com.example.vhagar.authentication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button

import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.vhagar.MainActivity
import com.example.vhagar.R

import com.google.firebase.auth.FirebaseAuth

class

LoginActivity : AppCompatActivity() {
    private

    lateinit

    var auth: FirebaseAuth

    private

    lateinit

    var emailEditText: EditText
    private

    lateinit

    var passwordEditText: EditText

    override fun

            onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        // Find views
        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)

        // Login button click listener
        val loginButton = findViewById<Button>(R.id.loginButton)
        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()



            if (email.isNotEmpty() && password.isNotEmpty()) {
                signInWithEmailAndPassword(email, password)
            } else {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
            }
        }

        // Signup button click listener
        val signupButton = findViewById<Button>(R.id.signupButton)
        signupButton.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }

    private

    fun

            signInWithEmailAndPassword(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d("LoginActivity", "signInWithEmailAndPassword:success")
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                } else {
                    Log.w("LoginActivity", "signInWithEmailAndPassword:failure", task.exception)
                    Toast.makeText(this, "Authentication failed.", Toast.LENGTH_SHORT).show()
                }
            }
    }
}