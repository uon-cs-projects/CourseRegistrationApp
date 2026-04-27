package com.example.courseregistrationapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var spinnerCourse: Spinner
    private lateinit var etStudentId: EditText
    private lateinit var btnRegister: Button
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize UI Elements
        spinnerCourse = findViewById(R.id.spinnerCourse)
        etStudentId = findViewById(R.id.etStudentId)
        btnRegister = findViewById(R.id.btnRegister)

        // Initialize SharedPreferences for Data Persistence
        sharedPreferences = getSharedPreferences("RegistrationPrefs", Context.MODE_PRIVATE)

        // Set up Course Options using an ArrayAdapter
        ArrayAdapter.createFromResource(
            this,
            R.array.course_units,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerCourse.adapter = adapter
        }

        // Load previously saved Student ID if it exists
        val savedStudentId = sharedPreferences.getString("LAST_STUDENT_ID", "")
        etStudentId.setText(savedStudentId)

        // Handle Button Click Event
        btnRegister.setOnClickListener {
            val studentId = etStudentId.text.toString().trim()
            val selectedCourse = spinnerCourse.selectedItem.toString()

            // Error Handling: Validate Student ID
            if (studentId.isEmpty()) {
                Toast.makeText(this, "Please enter a valid Student ID", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Data Persistence: Save the registered student ID and course
            with(sharedPreferences.edit()) {
                putString("LAST_STUDENT_ID", studentId)
                putString("LAST_COURSE", selectedCourse)
                apply()
            }

            // Use Intent to transition to ConfirmationActivity
            val intent = Intent(this, ConfirmationActivity::class.java).apply {
                putExtra("STUDENT_ID", studentId)
                putExtra("SELECTED_COURSE", selectedCourse)
            }
            startActivity(intent)
        }
    }
}