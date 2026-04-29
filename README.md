# Course Registration App

An Android mobile application built using Kotlin to streamline course registration for students in the Department of Computing and Informatics at the University of Nairobi

This project was developed as a Practical Activity for **SCS 3308: Embedded Systems and Mobile Programming**.

## Features

* **Course Registration:** Students can register for specific units by entering their Student ID and selecting a course.
* **Smart Search:** Uses a searchable `AutoCompleteTextView`, allowing users to quickly find courses by typing the course code or name.
* **Data Persistence:** Utilizes `SharedPreferences` and Google's `Gson` library to save and retrieve registered courses locally on the device, ensuring data survives app restarts.
* **View Registered Courses:** A dedicated screen displaying a list of all currently registered units.
* **Edit/Remove Capabilities:** Users can dynamically remove courses from their registration list, with immediate UI updates and background data syncing.
* **Input Validation:** Form validation ensures that a valid Student ID is entered and a recognized course is selected before processing the registration.

## Tech Stack & Prerequisites

* **Language:** Kotlin
* **IDE:** Android Studio
* **UI Toolkit:** XML (Android Views)
* **Data Storage:** SharedPreferences & Gson
* **Minimum SDK:** API 24 (Android 7.0) - *Note: Upgraded from API 21 to support modern `androidx` libraries.*

## Project Setup

1.  **Clone or Download the Repository:**
    Extract the `.zip` file containing the Android project directory.
2.  **Open in Android Studio:**
    * Launch Android Studio.
    * Select **File > Open** and navigate to the extracted `CourseRegistrationApp` folder.
    * Click **OK**.
3.  **Gradle Sync:**
    * Android Studio will automatically begin syncing the project files.
    * Ensure your machine is connected to the internet so Gradle can download the necessary dependencies.
    * Wait for the build process at the bottom of the screen to complete successfully.

## Getting It Running

1.  **Set up a Virtual Device (Emulator):**
    * Open the **Device Manager** in Android Studio.
    * Click **Create Device** and select a phone hardware profile (e.g., Pixel 6).
    * Download a system image (API 24 or higher is recommended).
    * Click Finish.
2.  **Run the Application:**
    * Select your newly created emulator (or a physical Android device connected via USB with Developer Options enabled) from the device dropdown menu in the top toolbar.
    * Click the green **Run (▶)** button or press `Shift + F10`.