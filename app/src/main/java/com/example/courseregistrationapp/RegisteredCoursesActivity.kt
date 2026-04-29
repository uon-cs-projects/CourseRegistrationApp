package com.example.courseregistrationapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import androidx.core.content.edit

class RegisteredCoursesActivity : AppCompatActivity() {

    private lateinit var listViewCourses: ListView
    private var registeredCourses = mutableListOf<Course>()
    private val gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registered_courses)

        listViewCourses = findViewById(R.id.listViewCourses)
        loadCourses()
    }

    private fun loadCourses() {
        val sharedPreferences = getSharedPreferences("RegistrationPrefs", Context.MODE_PRIVATE)
        val jsonStr = sharedPreferences.getString("REGISTERED_COURSES", "[]")
        val type = object : TypeToken<MutableList<Course>>() {}.type
        registeredCourses = gson.fromJson(jsonStr, type)

        val adapter = CourseAdapter(this, registeredCourses) { courseToRemove ->
            removeCourse(courseToRemove)
        }
        listViewCourses.adapter = adapter
    }

    private fun removeCourse(course: Course) {
        registeredCourses.remove(course)

        // Save the updated list back to SharedPreferences
        val sharedPreferences = getSharedPreferences("RegistrationPrefs", Context.MODE_PRIVATE)
        val newJsonStr = gson.toJson(registeredCourses)
        sharedPreferences.edit { putString("REGISTERED_COURSES", newJsonStr) }

        Toast.makeText(this, "${course.code} removed", Toast.LENGTH_SHORT).show()

        // Refresh the UI
        loadCourses()
    }

    // Custom Adapter to handle the List UI and Button Clicks
    inner class CourseAdapter(
        private val context: Context,
        private val dataSource: List<Course>,
        private val onDeleteClick: (Course) -> Unit
    ) : BaseAdapter() {

        override fun getCount(): Int = dataSource.size
        override fun getItem(position: Int): Any = dataSource[position]
        override fun getItemId(position: Int): Long = position.toLong()

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_course, parent, false)

            val tvCourseDetails = view.findViewById<TextView>(R.id.tvCourseDetails)
            val btnRemove = view.findViewById<Button>(R.id.btnRemove)

            val currentCourse = dataSource[position]
            tvCourseDetails.text = currentCourse.toString()

            btnRemove.setOnClickListener {
                onDeleteClick(currentCourse)
            }

            return view
        }
    }
}