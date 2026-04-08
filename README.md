# Veeva Assignment

## Description

A test automation project for verifying login functionality on a sample web application. This project uses Selenium WebDriver with Cucumber and JUnit to run automated tests for both positive and negative login scenarios. The tests include validating correct login, handling invalid usernames or passwords, and checking for success or error messages.

## Technologies Used

**Language:** Java 17.0.12<br>
**Frameworks:** Selenium 4.18.1, Cucumber 7.15.0, JUnit 4.13.2 <br>
**Build Tool:** Maven 3.9.14<br>
**Browser Automation:** ChromeDriver (managed automatically with WebDriverManager 5.7.0)

## Features

- Automated login tests for positive and negative scenarios
- Step definitions using Cucumber for readable behavior-driven tests
- Generates HTML and JSON test reports
- WebDriver setup and teardown handled automatically

## Prerequisites

- Java 17 installed and configured
- Maven 3.x installed
- Chrome browser installed (version compatible with WebDriverManager)

## How To Run

1. Clone the project using: <br>
    `git clone https://github.com/prathab-b/veeva-assignment`
2. Ensure Java and Maven are installed.
3. Run the tests using: `mvn clean test` <br>
   This will execute all scenarios in `login.feature` using ChromeDriver.

## Project Structure

```
veeva-assignment/
├── pom.xml
├── README.md
├── src/
│   └── test/
│       ├── java/
│       │   ├── pages/
│       │   ├── runners/
│       │   └── stepDefinitions/
│       └── resources/
│           └── features/
├── target/
│   └── cucumber-reports/
```

## Test Scenarios

**Positive Login:**
- Username: student
- Password: Password123
- Verify: 
    - Redirection to the logged in page
    - Success message `Congratulations`
    - Logout button visible

**Negative Login - Invalid Username:**
- Username: incorrectUser
- Password: Password123
- Verify: error message `Your username is invalid!`

**Negative Login - Invalid Password:**
- Username: student
- Password: incorrectPassword
- Verify: error message `Your password is invalid!`

## Reports

After test execution, reports are generated in `target/cucumber-reports/`:

`report.html` – HTML report (human-readable) <br>
`report.json` – JSON report

## License

This project is licensed under the MIT License.