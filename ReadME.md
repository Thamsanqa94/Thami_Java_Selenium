# Thami Java Selenium - Automated E-Commerce Testing Project
## Quick Start Guide
A complete **End-to-End Selenium automation framework** for testing device purchase workflow on a web application.
## What's Included
- Page Object Model architecture for maintainable tests
- Data-Driven Testing using JSON test data
- Selenium WebDriver 4.18.1 with Java 21
- TestNG framework with advanced features
- Maven for dependency management
- Test Reporting with Extent Reports and TestNG
- Automatic Browser Management with WebDriverManager
- Explicit Waits for reliable element detection
## Prerequisites
- Java JDK 21+
- Maven 3.8+
- Chrome Browser (v145+)
## Installation
`ash
cd C:\Users\xoxos\Documents\Project\Thami_Java_Selenium
mvn clean install
mvn test
`
## Project Structure
`
src/test/java/
- Base/BaseTest.java (Browser setup)
- Pages/LoginPage.java (Page Object)
- Test/LoginTest.java (Test cases)
- Utilities/ (BrowserFactory, JsonDataReader)
`
## Running Tests
`ash
mvn test
mvn test -Dtest=LoginTest
`
## Test Workflow
1. Login with credentials
2. Select Learning Materials
3. Configure Device (type, brand, storage, color)
4. Enter Delivery Address
5. Choose Shipping & Warranty
6. Apply Discount Code
7. Complete Purchase
8. View Purchase History
## Test Data
Located in: src/test/resources/testdata/Login_Data.json
`json
[
  {
    "email": "user@example.com",
    "password": "password123"
  }
]
`
## Key Features
- Page Object Model for maintainability
- Data-Driven Testing with multiple datasets
- Explicit Waits for dynamic elements
- Automatic Browser Management
- Test Reporting (Extent + TestNG)
## Common Issues & Solutions
- Element Not Interactable: Added explicit waits and scrolling
- Test Timeouts: Increased wait to 20+ seconds
- JSON Data Not Found: Verify path is correct
## Tech Stack
| Technology | Version |
|-----------|---------|
| Java | 21 |
| Selenium WebDriver | 4.18.1 |
| TestNG | 7.9.0 |
| Maven | 3.8+ |
| Jackson | 2.16.1 |
| WebDriverManager | 5.6.3 |
## View Test Reports
After running tests:
- Extent Report: target/Reports/ExtentReport.html
- TestNG Report: target/surefire-reports/index.html
## For Detailed Documentation
See **README_DETAILED.md** for:
- Complete architecture overview
- Detailed challenges and solutions
- Troubleshooting guide
- Best practices
- Future improvements
## Support
Application URL: https://ndosisimplifiedautomation.vercel.app/
Framework: Selenium 4 + TestNG
Language: Java 21
Happy Testing!