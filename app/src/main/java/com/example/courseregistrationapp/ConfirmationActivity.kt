package com.example.courseregistrationapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ConfirmationActivity : AppCompatActivity() {

    private lateinit var tvConfirmationMessage: TextView
    private lateinit var btnBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)

        tvConfirmationMessage = findViewById(R.id.tvConfirmationMessage)
        btnBack = findViewById(R.id.btnBack)

        // Retrieve passed intent details
        val studentId = intent.getStringExtra("STUDENT_ID") ?: "Unknown ID"
        val selectedCourse = intent.getStringExtra("SELECTED_COURSE") ?: "Unknown Course"

        // Display confirmation message
        val confirmationText = "Registration Successful!\n\nStudent ID: $studentId\nCourse: $selectedCourse"
        tvConfirmationMessage.text = confirmationText

        // Allow users to go back to MainActivity
        btnBack.setOnClickListener {
            finish() // Closes this activity and returns to the previous one in the stack
        }
    }
}