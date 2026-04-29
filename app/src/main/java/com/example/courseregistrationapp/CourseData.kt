package com.example.courseregistrationapp

data class Course(val code: String, val name: String) {
    override fun toString(): String {
        return "$code - $name"
    }
}

object CourseCatalog {
    val availableCourses = listOf(
        Course("SCS3101", "Introduction to Computer Systems"),
        Course("SCS3103", "Introduction to Programming"),
        Course("SCS3105", "Discrete Maths"),
        Course("SCS3107", "Programming Lab"),
        Course("SPH3105", "Physics for Computing Systems"),

        Course("SCS3102", "Database Systems"),
        Course("SCS3104", "Data Communication"),
        Course("SMA3211", "Linear Algebra"),
        Course("SCS3106", "Object-Oriented Programming"),
        Course("SCS3108", "Data Structures and Algorithms"),
        Course("SCS3109", "Digital Electronics"),

        Course("SMA3114", "Differential and Integral Calculus"),
        Course("SCS3201", "Systems Analysis and Design"),
        Course("SCS3203,", "Computer Architecture"),
        Course("SCS3205", "Knowledge-based Systems & Programming"),
        Course("SCS3209", "Software Engineering"),
        Course("SCS3207", "Operating Systems"),
        Course("SCS3211", "Computer Networks"),

        Course("SMA3124", "Probability and Statistics"),
        Course("SCS3202", "Assembly Language Programming"),
        Course("SCS3204", "Automata Theory"),
        Course("SCS3206", "Programming Project"),
        Course("SCS3208", "Web and Services Programming"),
        Course("SCS3212", "Machine Learning Algorithms & Programming"),
        Course("SCS3214", "Foundations of Human-Computer Interaction"),

        Course("SCS3213", "Analysis and Design of Algorithms"),
        Course("SCS3301", "Computer Graphics"),
        Course("SCS3303", "Distributed Systems"),
        Course("SCS3305", "Introduction to Organizations and Management"),
        Course("SCS3307", "Artificial Intelligence Applications"),
        Course("SCS3309", "Network Design Implementation and Management"),
        Course("SCS3311", "Innovation & Entrepreneurship"),

        Course("SCS3302", "ICT Project Management"),
        Course("SCS3304", "Network and Distributed Programming"),
        Course("SCS3305", "Compiler Construction"),
        Course("SCS3308", "Embedded Systems & Mobile Programming"),
        Course("SCS3312", "Business Intelligence & Analytics"),
        Course("SCS3314", "Computer Network Security"),

        Course("SCS3322", "Industrial Attachment"),

        Course("SCS3401", "ICTs and Society"),
        Course("SCS3403", "Computer Systems Project"),
        Course("SCS3405", "Information Systems and Organizations"),
        Course("SCS3407", "Emerging Technologies Bootcamps"),
        Course("SCS3409", "Distributed Databases"),
        Course("SCS3411", "Computer Games Programming"),

        Course("SCS3402", "Cloud Computing and Services"),
        Course("SCS3404", "Information Systems Control and Audit"),
        Course("SCS3406", "Informatics for Emerging Online"),
        Course("SCS3403", "Project"),
    )
}