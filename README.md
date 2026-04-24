# QA-Automation-Portfolio
Automated test scripts for Web and Android using Robot Framework and Selenium


##  Android App Automation with Robot Framework & Appium

### Project Overview
This repository contains automated test cases for an Android application using **Robot Framework** and **Appium Library**. The goal of this project is to practice and demonstrate mobile automation techniques, including handling complex UI elements and gestures.

###  Key Features Tested
* **Login Validation:** Testing input fields, clearing text, and verifying error messages using FOR loops.
* **Date & Time Pickers:** Automating date/time selection using direct input and dialog interaction.
* **Complex UI Elements:** Handling Select Boxes and Radio Buttons.
* **Table Operations:** Updating and deleting rows in a dynamic table.
* **Advanced Gestures:**
    * **Slider Handling:** Using mathematical coordinates (`Evaluate`) to precisely slide seekbars.
    * **Swiping:** Horizontal and Vertical swiping for list navigation and message deletion.
    * **Signature Pad:** Simulating free-hand drawing using Swipe coordinates.

###  Tech Stack
* **Framework:** Robot Framework
* **Driver:** Appium (UiAutomator2)
* **Language:** Python
* **Reporting:** Built-in Robot Framework HTML reports (Log & Report)

###  Project Structure
* `Robot-Framework-Android/practice_test.robot` - Main automation script.
* `README.md` - Project documentation.

###  How to Setup & Run
1. Install Python, Appium Server, and Android Studio (Emulator).
2. Install required libraries:
   ```bash
   pip install robotframework-appiumlibrary
   
---

##  Web Automation with Robot Framework & Selenium

This section contains automated test suites designed to verify Web UI functionalities, ranging from standard E-commerce flows to complex UI component interactions.

###  Projects Covered

#### 1. SauceDemo E-commerce Test
* **Target:** [SauceDemo](https://www.saucedemo.com/)
* **Logic:** Demonstrates a complete **End-to-End (E2E) shopping flow**.
* **Key Features:**
    * Modular **Login Flow** using custom Keywords with arguments.
    * **Automated Cart Addition** using `FOR` loops to handle multiple items efficiently.
    * Full Checkout process and verification of success messages.

#### 2. UI Elements & Component Testing
* **Target:** [Test Automation Practice](https://testautomationpractice.blogspot.com/)
* **Logic:** A comprehensive test suite to demonstrate the handling of diverse **HTML elements**.
* **Key Features:**
    * **Form Controls:** Handling Text fields, Radio buttons, and Checkboxes.
    * **Dropdowns:** Selection by label from dynamic lists.
    * **JS Interactions:** Handling Alerts/Pop-ups and Drag-and-Drop actions.
    * **Web Tables:** Extracting and logging data from dynamic tables using WebElements.

### 🛠 Tech Stack (Web)
* **Framework:** Robot Framework
* **Library:** SeleniumLibrary
* **Browser:** Chrome (ChromeDriver)
* **Language:** Python

###  Project Structure
* `Robot-Framework-Web/saucedemo_test.robot` - Shopping flow script.
* `Robot-Framework-Web/ui_elements_test.robot` - UI component interaction script.

### ⚙️ How to Setup & Run (Web)
1.  **Install Requirements:**
    ```bash
    pip install robotframework-seleniumlibrary
    ```
2.  **Run specific test:**
    ```bash
    robot Robot-Framework-Web/saucedemo_test.robot
    ```
3.  **Run all web tests:**
    ```bash
    robot Robot-Framework-Web/
    ```
