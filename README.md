# 🧪 Event Management System - UI Automation Framework

This project is a complete end-to-end **UI automation test framework** built using **Selenium WebDriver**, **TestNG**, **Cucumber BDD**, **Log4j2** for custom logging, and **ExtentReports** for advanced HTML reporting.

---

## 📌 Project Objective

Automate regression testing of an **Event Management Web Application** to validate booking and contact functionalities with both positive and negative test cases, ensuring robustness and UI reliability.

---

## 🧱 Framework Design

### ✅ Tools & Technologies Used

| Technology | Purpose |
|------------|---------|
| **Java** | Core programming language |
| **Selenium WebDriver** | UI automation engine |
| **TestNG** | Test execution framework |
| **Cucumber BDD** | Gherkin-based behavior testing |
| **Page Object Model (POM)** | Reusable element abstraction |
| **Log4j2** | Custom log file generation |
| **ExtentReports** | Rich HTML reporting |
| **Apache POI** | Excel file handling (if applicable) |
| **Maven** | Build management & dependencies |

---

## 🔧 Framework Modules

### 1. **Page Object Model (POM)**
All UI elements and reusable page-level methods are defined in separate classes for maintainability.

### 2. **BDD with Cucumber**
Test cases are written in `.feature` files using Gherkin syntax and mapped to Step Definitions.

### 3. **Logging**
Custom logs are generated using `log4j2.xml`, stored under `/logs/automation_log.log`.

### 4. **Reporting**
Test execution reports are generated in HTML format using **ExtentReports**, saved under `/extentReport.html`.

### 5. **Screenshot Capture**
Screenshots are captured on test failure using a custom `ScreenshotUtil.java` and stored in `/screenshots/`.

---

## 📁 Project Structure

EventManagementAutomation/               # Project Root
│
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── base/                      # Base classes for initiating application
│   │            ├── BaseClass.java        # Contains methods to initialize application
│   │       
│   ├── test/
│   │   └── java/
│   │       ├── pages/                      # POM Classes for UI sections
│   │       │    ├── BookingPage.java       # Contains locators and methods for Booking form
│   │       │    └── ContactUsPage.java     # Contains locators and methods for Contact Us form
│   │       │
│   │       ├── stepdefinitions/             # Step Definitions mapping to feature steps
│   │       │    ├── BookingSteps.java       # Step Definitions for Booking.feature steps
│   │       │    └── ContactUsSteps.java     # Step Definitions for ContactUs.feature steps
│   │       │
│   │       ├── runner/                        # Cucumber Test Runner
│   │       │    └── CucumberTestRunner.java   # Executes Cucumber features with TestNG/JUnit
│   │       ├── listeners/                     # Cucumber Test Listener
│   │       │    └── ExtentReportListener.java # to generate extent report
│   │       │
│   │       ├── setup/                       # WebDriver Setup & Configuration
│   │       │    ├── DriverSetup.java        # WebDriver initialization logic
│   │       │    ├── ConfigReader.java       # Reads Configuration.properties
│   │       │
│   │       ├── utils/                      # Utility Classes
│   │       │    ├── ExcelReader.java        # Reads test data from Excel sheets
│   │       │    ├── WaitUtils.java          # Methods for explicit/implicit waits
│   │       │    └── ScreenshotUtil.java     # Captures screenshots on test failure
│   │       │
│   │       └── main/                        # Main Launcher Class
│   │       │    └── Invoke.java             # Initiates the test run programmatically (optional)
│   │       └── hooks/                       # Hooks Class
│   │            └── Hooks.java              # Includes cucumber hooks 
│   │
│   └── test/
│       └── resources/
│           ├── features/                   # Gherkin Feature Files
│           │    ├── Booking.feature         # Scenarios related to Booking form validation
│           │    └── ContactUs.feature       # Scenarios related to Contact Us form validation
│           │
│           ├── testdata/                   # Test Data Files (Excel/CSV)
│           │    └── BookingData.xlsx        # Booking page test data for data-driven scenarios
│           │    └── ContactData.xlsx        # Contact page test data for data-driven scenarios
│           │
│           └── config/                     # Additional Config Files (Optional)
│                └── config.properties       # Alternative or extended configuration
│
├── test-output/                            # Test Reports (Generated by Cucumber/TestNG)
│       └── extentReport.html
│
├── pom.xml                                 # Maven Project File for Dependencies & Plugins
├── testng.xml                              # TestNG Configuration File
│
├── Screenshots/                            # Capture screenshots on failure
│       └── Invalid_Email.png      
├── automation_log.log                      # Log file for execution tracking



---

## 🚀 How to Run

1. **Pre-requisites:**
   - Java 17+
   - Maven 3.x
   - Chrome/Firefox browser installed or use github bonigarcia

2. **Run via Command Line:**
   ```bash
   mvn clean test

🧪 Sample Test Scenarios Covered
>Booking form with all fields blank (negative)

>Invalid email and phone number validations

>Successful form submission with valid inputs

>Contact Us page error validation

>Confirmation message verification


🙋‍♀️ Author
Asiya
Intern - Selenium Automation, Cognizant
