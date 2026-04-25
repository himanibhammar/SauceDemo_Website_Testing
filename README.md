# SauceDemo Test Automation Project

## Project Overview

This project is a complete Selenium Automation Testing Framework built for the SauceDemo website:

https://www.saucedemo.com/

The project automates multiple real-world test scenarios using:

* Java
* Selenium WebDriver
* TestNG
* Maven
* Eclipse IDE
* WebDriverManager

The goal of this project is to validate core functionalities of an e-commerce application such as:

* Login validation
* Product validation
* Cart functionality
* Checkout flow
* Sorting functionality
* Logout validation
* Hamburger menu validations

This project contains 15+ professional automation test cases and follows industry-level testing practices.

---

# Technology Stack

| Tool               | Purpose                     |
| ------------------ | --------------------------- |
| Java               | Programming Language        |
| Selenium WebDriver | Browser Automation          |
| TestNG             | Test Execution Framework    |
| Maven              | Dependency Management       |
| Eclipse IDE        | Development Environment     |
| WebDriverManager   | Automatic Driver Management |

---

# Website Under Test

SauceDemo is a demo e-commerce testing platform provided by Sauce Labs.

## Website URL

https://www.saucedemo.com/

## Valid Login Credentials

### Username

standard_user

### Password

secret_sauce

## Locked User Credentials

### Username

locked_out_user

### Password

secret_sauce

---

# Project Structure

```text
automation/
│
├── src/
│   ├── main/
│   │   └── java/
│   │
│   └── test/
│       └── java/
│           └── com/
│               └── saucedemo/
│                   └── automation/
│                       ├── BaseTest.java
│                       ├── LoginTest.java
│                       ├── InvalidLoginTest.java
│                       ├── EmptyUsernameTest.java
│                       ├── EmptyPasswordTest.java
│                       ├── LockedUserTest.java
│                       ├── ProductPageTitleTest.java
│                       ├── AddSingleProductTest.java
│                       ├── AddMultipleProductsTest.java
│                       ├── RemoveProductTest.java
│                       ├── CartBadgeCountTest.java
│                       ├── SortProductsAToZTest.java
│                       ├── SortLowToHighTest.java
│                       ├── CheckoutFlowTest.java
│                       ├── EmptyCartValidationTest.java
│                       ├── LogoutTest.java
│                       ├── HamburgerMenuValidationTest.java
│                       ├── AboutPageNavigationTest.java
│                       ├── CloseHamburgerMenuTest.java
│                       └── ResetAppStateTest.java
│
├── testng.xml
├── pom.xml
└── README.md
```

---

# Maven Dependencies

The project uses the following dependencies:

* selenium-java
* testng
* webdrivermanager
* maven-surefire-plugin

These are configured inside `pom.xml`.

---

# Test Cases Covered

---

## Login Module

### TC01 – Valid Login Test

Verify successful login using valid credentials.

### TC02 – Invalid Login Test

Verify proper error message for invalid username/password.

### TC03 – Empty Username Validation

Verify error message when username field is empty.

### TC04 – Empty Password Validation

Verify error message when password field is empty.

### TC05 – Locked User Validation

Verify login restriction for locked users.

---

## Product Module

### TC06 – Product Page Title Validation

Verify Products page opens after login.

### TC07 – Add Single Product to Cart

Verify single product addition to cart.

### TC08 – Add Multiple Products to Cart

Verify multiple product addition to cart.

### TC09 – Remove Product from Cart

Verify product removal from cart.

### TC10 – Verify Products in Cart

Verify actual cart item count after adding products.

---

## Sorting Module

### TC11 – Sort Products A to Z

Verify alphabetical product sorting.

### TC12 – Sort Products Low to High Price

Verify price sorting from low to high.

---

## Checkout Module

### TC13 – Complete Checkout Flow

Verify end-to-end checkout process.

### TC14 – Empty Cart Validation

Verify cart remains empty without product addition.

---

## User Module

### TC15 – Logout Validation

Verify successful logout functionality.

---

## Hamburger Menu Module

### TC16 – Hamburger Menu Validation

Verify visibility of:

* All Items
* About
* Logout
* Reset App State

### TC17 – About Page Navigation

Verify About option redirects to Sauce Labs website.

### TC18 – Close Hamburger Menu Validation

Verify hamburger menu closes successfully.



---

# How to Run the Project

## Step 1 — Clone Project

```bash
git clone <repository-url>
```

---

## Step 2 — Open in Eclipse

Import project as:

Maven Existing Project

---

## Step 3 — Update Maven Project

Right Click Project

→ Maven
→ Update Project

OR press:

Alt + F5

---

## Step 4 — Run Test Suite

Right Click Project

→ Run As
→ Maven test

This will execute tests using:

`testng.xml`

---

# Test Execution

Test execution is managed using:

## testng.xml

This allows centralized execution of all test cases instead of running individual classes.

This is the professional way used in real automation frameworks.

---

# Key Features

* Stable locators using ID selectors
* JavaScriptExecutor handling for difficult elements
* Dynamic UI validation
* Negative testing scenarios
* Business flow validation
* Checkout validation
* State reset validation
* External navigation validation
* Professional framework structure

---







# Conclusion

This project demonstrates a complete real-world Selenium Automation Framework for an e-commerce platform.

It covers both:

* Positive test scenarios
* Negative test scenarios

with strong business validation and professional execution structure.


It represents strong practical knowledge of Selenium Automation Testing.
