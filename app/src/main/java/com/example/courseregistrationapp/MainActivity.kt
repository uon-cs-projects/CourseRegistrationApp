package com.example.courseregistrationapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import androidx.core.content.edit

class MainActivity : AppCompatActivity() {

    private lateinit var etStudentId: EditText
    private lateinit var autoCompleteCourse: AutoCompleteTextView
    private lateinit var btnRegister: Button
    private lateinit var btnViewCourses: Button
    private lateinit var sharedPreferences: SharedPreferences
    private val gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etStudentId = findViewById(R.id.etStudentId)
        autoCompleteCourse = findViewById(R.id.autoCompleteCourse)
        btnRegister = findViewById(R.id.btnRegister)
        btnViewCourses = findViewById(R.id.btnViewCourses)

        sharedPreferences = getSharedPreferences("RegistrationPrefs", Context.MODE_PRIVATE)

        // Setup Searchable Adapter
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line,
            CourseCatalog.availableCourses
        )
        autoCompleteCourse.setAdapter(adapter)

        btnRegister.setOnClickListener {
            val studentId = etStudentId.text.toString().trim()
            val selectedCourseStr = autoCompleteCourse.text.toString()

            if (studentId.isEmpty() || selectedCourseStr.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Find the actual course object from the string
            val courseToRegister = CourseCatalog.availableCourses.find { it.toString() == selectedCourseStr }

            if (courseToRegister == null) {
                Toast.makeText(this, "Please select a valid course from the list", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            saveCourse(courseToRegister)

            Toast.makeText(this, "Successfully registered for ${courseToRegister.code}", Toast.LENGTH_SHORT).show()
            autoCompleteCourse.text.clear() // Clear input for next entry
        }

        btnViewCourses.setOnClickListener {
            startActivity(Intent(this, RegisteredCoursesActivity::class.java))
        }
    }

    private fun saveCourse(newCourse: Course) {
        val jsonStr = sharedPreferences.getString("REGISTERED_COURSES", "[]")
        val type = object : TypeToken<MutableList<Course>>() {}.type
        val currentCourses: MutableList<Course> = gson.fromJson(jsonStr, type)

        // Prevent duplicates
        if (currentCourses.none { it.code == newCourse.code }) {
            currentCourses.add(newCourse)
            val newJsonStr = gson.toJson(currentCourses)
            sharedPreferences.edit { putString("REGISTERED_COURSES", newJsonStr) }
        }
    }
}