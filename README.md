# QA-Automation-Portfolio
Automated test scripts for Web and Android using Robot Framework and Selenium


## 📱 Android App Automation with Robot Framework & Appium

### Project Overview
This repository contains automated test cases for an Android application using **Robot Framework** and **Appium Library**. The goal of this project is to practice and demonstrate mobile automation techniques, including handling complex UI elements and gestures.

### 🚀 Key Features Tested
* **Login Validation:** Testing input fields, clearing text, and verifying error messages using FOR loops.
* **Date & Time Pickers:** Automating date/time selection using direct input and dialog interaction.
* **Complex UI Elements:** Handling Select Boxes and Radio Buttons.
* **Table Operations:** Updating and deleting rows in a dynamic table.
* **Advanced Gestures:**
    * **Slider Handling:** Using mathematical coordinates (`Evaluate`) to precisely slide seekbars.
    * **Swiping:** Horizontal and Vertical swiping for list navigation and message deletion.
    * **Signature Pad:** Simulating free-hand drawing using Swipe coordinates.

### 🛠 Tech Stack
* **Framework:** Robot Framework
* **Driver:** Appium (UiAutomator2)
* **Language:** Python
* **Reporting:** Built-in Robot Framework HTML reports (Log & Report)

### 📁 Project Structure
* `Robot-Framework-Android/practice_test.robot` - Main automation script.
* `README.md` - Project documentation.

### ⚙️ How to Setup & Run
1. Install Python, Appium Server, and Android Studio (Emulator).
2. Install required libraries:
   ```bash
   pip install robotframework-appiumlibrary
