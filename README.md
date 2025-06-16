# 🧪 Guru99 Selenium Automation Project

This is an automated UI test project built with **Selenium WebDriver** and **Java**, applying the **Page Object Model (POM)** design pattern.  
It is designed to test core user flows on the [Guru99 Demo Site](https://demo.guru99.com/test/newtours/), including login, registration, and flight search functionality.

---

## 📁 Project Structure

- `LoginPage.java` – Page Object for login screen  
- `LoginTest.java` – JUnit test case for login  
- `RegisterPage.java` – Page Object for user registration  
- `RegisterTest.java` – JUnit test case for registration  
- `ReservationPage.java` – Page Object for flight booking  
- `ReservationTest.java` – JUnit test case for flight booking  
- `pom.xml` – Maven dependencies and configuration

---

## ✅ Implemented Test Cases

| TC ID     | Description                                                               |
|-----------|---------------------------------------------------------------------------|
| ✅ TC-001 | Verify login successfully on Mercury Tours                                |
| ✅ TC-002 | Verify registration with valid user information                           |
| ✅ TC-003 | Verify flight search returns "No Seats Available" when no result is found |

---

## 🛠️ Tech Stack

- Java 11  
- Selenium WebDriver  
- JUnit 4  
- Maven  
- Page Object Model (POM) design pattern  
- ChromeDriver (local execution)

---

## 🚀 How to Run

1. Clone this repository  
2. Open the project in Eclipse  
3. Run test classes using JUnit (right-click → Run As → JUnit Test)  
4. Chrome browser will launch and execute test scenarios.

---

## ✍️ Author

Truc  – QC Engineer (2025)  
