# Tutoriel 3

Repository Link1: https://github.com/ZouheirRachidi/SEG2505-Tutorial3-.git

Repository Link2: https://github.com/ZouheirRachidi/SEG2505-Tutorial3-

Zouheir Rachidi
Student ID: 300329396



## Overview

FirebaseDemo is a simple Android application that demonstrates the integration of Firebase Realtime Database into an Android app. It provides basic functionality for writing and reading data from the Firebase database, showcasing how to set up a Realtime Database, sync data, and use listeners to reflect data changes.

---

## Features

- **Write to Firebase Realtime Database:**
  - Adds a key-value pair (`"test": "Hello Firebase!"`) to the Realtime Database.
  - Logs a success or failure message in Logcat.

- **Read from Firebase Realtime Database:**
  - Listens for changes to the `"test"` node in the database.
  - Logs the current value of the node in Logcat.
  - Updates dynamically when the value changes in the Firebase Console.

- **Offline Support:**
  - Firebase Realtime Database automatically handles data syncing when offline and updates when the device reconnects.

---

## Project Structure

### Main Components

1. **MainActivity.java**:
   - The main logic for writing and reading from the Firebase Realtime Database.
   - Sets up a `DatabaseReference` for Firebase interactions.

2. **activity_main.xml**:
   - Simple layout with a `TextView` displaying "Hello, World!".

3. **Firebase Integration**:
   - Configured with `google-services.json` to link the app to the Firebase project.

4. **Gradle Files**:
   - Includes Firebase dependencies and plugins for Realtime Database support.

---

## Prerequisites

- **Android Studio**: Version 2022.3.1 or higher.
- **Firebase Project**: A project created in the Firebase Console.
- **google-services.json**:
  - Download the `google-services.json` file from the Firebase Console.
  - Place it in the `app/` directory.

---

## Setup and Configuration

### 1. Clone the Repository

```bash
git clone https://github.com/YourUsername/FirebaseDemo.git
cd FirebaseDemo
```

### 2. Add `google-services.json`

1. Go to the Firebase Console.
2. Navigate to **Project Settings > General > Your Apps**.
3. Download the `google-services.json` file.
4. Place it inside the `app/` directory.

### 3. Build and Sync

1. Open the project in Android Studio.
2. Sync the Gradle files by clicking **Sync Now** when prompted.
3. Run the project on an emulator or physical device.

---

## Usage

1. **Run the App**:
   - Launch the app on an emulator or real device.

2. **Write to Firebase**:
   - The app writes the value `"Hello Firebase!"` to the `test` node in your Firebase Realtime Database.
   - Check Logcat for the message:
     ```
     Value written successfully.
     ```

3. **Read from Firebase**:
   - Modify the value of the `test` node directly in the Firebase Console.
   - Observe the updated value logged in Logcat:
     ```
     Value is: <updated_value>
     ```

---

## Firebase Setup Guide

### Step 1: Create Firebase Project
1. Go to [Firebase Console](https://console.firebase.google.com/).
2. Create a new project or select an existing one.

### Step 2: Add Firebase to Android App
1. Register your app by entering the package name (`com.example.firebasedemo`).
2. Download the `google-services.json` file and add it to the `app/` folder.

### Step 3: Configure Realtime Database
1. Navigate to the **Realtime Database** section in Firebase Console.
2. Create a new database in **Test Mode** for quick setup.

### Step 4: Add Dependencies
Ensure the following Firebase dependencies are included in your `build.gradle` files.

#### App-level `build.gradle`
```kotlin
plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
}

dependencies {
    implementation(platform("com.google.firebase:firebase-bom:33.4.0"))
    implementation("com.google.firebase:firebase-database")
}
```

#### Project-level `build.gradle`
```kotlin
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.1.0")
        classpath("com.google.gms:google-services:4.4.2")
    }
}
```
