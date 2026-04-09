# Thami Java Selenium Project - Complete Documentation

## 📋 Table of Contents
1. [Project Overview](#project-overview)
2. [Project Architecture](#project-architecture)
3. [Technologies & Dependencies](#technologies--dependencies)
4. [Project Setup](#project-setup)
5. [Project Structure](#project-structure)
6. [Key Components](#key-components)
7. [Test Workflow](#test-workflow)
8. [How to Run Tests](#how-to-run-tests)
9. [Test Data Configuration](#test-data-configuration)
10. [Challenges & Solutions](#challenges--solutions)
11. [Troubleshooting](#troubleshooting)

---

## Project Overview

**Project Name:** Thami Java Selenium  
**Purpose:** Automated End-to-End (E2E) testing of a device purchase application  
**Author:** Thami Maseko  
**Application Under Test (AUT):** https://ndosisimplifiedautomation.vercel.app/  
**Test Framework:** TestNG  
**Test Automation Tool:** Selenium WebDriver  
**Language:** Java  
**Build Tool:** Maven  
**Java Version:** 21  

### What This Project Does

This project automates a complete e-commerce workflow for purchasing devices:
1. **Login** to the application with credentials
2. **Navigate** to Learning Materials
3. **Select Device** specifications (type, brand, storage, color, quantity)
4. **Enter Delivery** address information
5. **Choose Shipping** options (express)
6. **Select Warranty** options
7. **Apply Discount** code
8. **Complete Purchase** transaction
9. **View Purchase History** and invoices

---

## Project Architecture

### Design Pattern: Page Object Model (POM)

The project follows the **Page Object Model** design pattern for maintainability and scalability:

```
├── Base Layer
│   └── BaseTest.java (Browser setup, URL configuration)
│
├── Page Layer
│   └── LoginPage.java (All page interactions and locators)
│
├── Test Layer
│   └── LoginTest.java (Test cases using data-driven approach)
│
├── Utilities Layer
│   ├── BrowserFactory.java (Browser initialization)
│   ├── JsonDataReader.java (Test data management)
│   └── ExtentReportManager.java (Test reporting)
│
└── Test Data Layer
    └── Login_Data.json (Test credentials and data)
```

### Benefits of This Architecture
- **Maintainability:** Changes to UI locators only need to be made in one place (LoginPage)
- **Reusability:** Page objects can be reused across multiple test cases
- **Readability:** Tests are written in business language, not technical code
- **Scalability:** Easy to add new pages and tests

---

## Technologies & Dependencies

### Core Dependencies

| Technology | Version | Purpose |
|-----------|---------|---------|
| **Java** | 21 | Programming language |
| **Selenium WebDriver** | 4.18.1 | Browser automation |
| **TestNG** | 7.9.0 | Test framework & annotations |
| **Maven** | Latest | Build tool & dependency management |
| **Jackson** | 2.16.1 | JSON parsing for test data |
| **WebDriverManager** | 5.6.3 | Automatic driver management |

### Maven Configuration (pom.xml)

```xml
<properties>
    <maven.compiler.source>21</maven.compiler.source>
    <maven.compiler.target>21</maven.compiler.target>
    <selenium.version>4.18.1</selenium.version>
    <testng.version>7.9.0</testng.version>
    <jackson.version>2.16.1</jackson.version>
</properties>
```

---

## Project Setup

### Prerequisites

- **Java JDK 21** installed and configured
- **Maven** installed (version 3.8+)
- **Chrome Browser** installed (v145 or compatible)
- **Git** for version control

### Installation Steps

1. **Clone/Navigate to the Project**
   ```bash
   cd C:\Users\xoxos\Documents\Project\Thami_Java_Selenium
   ```

2. **Download Dependencies**
   ```bash
   mvn clean install
   ```
   This command:
   - Cleans previous builds
   - Downloads all Maven dependencies
   - Compiles the source code
   - Packages the project

3. **Verify Installation**
   ```bash
   mvn --version
   java -version
   ```

---

## Project Structure

```
Thami_Java_Selenium/
├── pom.xml                                 # Maven configuration
├── README.md                               # Project documentation
├── src/
│   ├── main/
│   │   ├── java/                           # Main source code (if any)
│   │   └── resources/                      # Main resources
│   │
│   └── test/
│       ├── java/
│       │   ├── Base/
│       │   │   └── BaseTest.java           # Base test class with setup/teardown
│       │   │
│       │   ├── Basic/
│       │   │   ├── LoginToAutomationPage.java
│       │   │   └── TestngAnnotations.java
│       │   │
│       │   ├── ExtentReport/
│       │   │   ├── ExtentReportManager.java # Test report generation
│       │   │   └── Listener.java            # TestNG listener for reporting
│       │   │
│       │   ├── Pages/
│       │   │   └── LoginPage.java           # Page Object for all UI interactions
│       │   │
│       │   ├── Test/
│       │   │   └── LoginTest.java           # Main test case
│       │   │
│       │   └── Utilities/
│       │       ├── BrowserFactory.java      # Browser initialization
│       │       └── JsonDataReader.java      # Test data reader
│       │
│       └── resources/
│           └── testdata/
│               └── Login_Data.json          # Test data (credentials, etc)
│
└── target/
    ├── test-classes/                       # Compiled test classes
    ├── Reports/                            # Extent test reports
    └── surefire-reports/                   # TestNG reports
```

---

## Key Components

### 1. **BaseTest.java** - Foundation Layer

```java
public class BaseTest {
    public final String url = "https://ndosisimplifiedautomation.vercel.app/";
    public final String browser = "chrome";
    public final WebDriver driver = BrowserFactory.startBrowser(browser, url);
}
```

**Responsibilities:**
- Initializes WebDriver
- Sets application URL
- Configures browser type
- Provides driver instance to all tests

### 2. **LoginPage.java** - Page Object Model

Contains all:
- **WebElement Locators** (using @FindBy annotations)
- **Page Actions** (methods that interact with UI)
- **Wait Conditions** (explicit waits for elements)

**Key Methods:**
- `clickLoginButton()` - Navigate to login
- `enterEmail(String email)` - Fill email field
- `enterPassword(String password)` - Fill password field
- `clickSubmitButton()` - Submit login form
- `clickLearningMaterials()` - Navigate to learning materials section
- `selectDeviceType(String type)` - Select phone/tablet
- `selectBrand(String brand)` - Select device brand
- `selectColor(String color)` - Select device color
- `enterQuantity(String quantity)` - Enter purchase quantity
- `enterAddress(String address)` - Enter delivery address
- `chooseShippingExpress()` - Select express shipping
- `chooseWarranty()` - Select warranty option
- `applyDiscount(String code)` - Apply discount code
- `purchaseDevice()` - Complete purchase
- `viewHistory()` - View purchase history
- `clickFirstInvoice()` - View invoice details

### 3. **LoginTest.java** - Test Case

```java
@Test(dataProvider = "loginData")
public void LoginWithValidInformation(JsonNode data) {
    // Multi-step test workflow using Page Object
    LoginPage loginPage = new LoginPage(driver);
    loginPage.clickLoginButton();
    loginPage.enterEmail(data.get("email").asText());
    // ... more steps
}
```

**Features:**
- Uses **@DataProvider** for data-driven testing
- Reads test data from JSON file
- Executes complete purchase workflow
- Uses Page Objects for all interactions

### 4. **BrowserFactory.java** - Browser Management

```java
public class BrowserFactory {
    public static WebDriver startBrowser(String browser, String url) {
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        return driver;
    }
}
```

**Responsibilities:**
- Creates WebDriver instances
- Handles browser initialization
- Manages browser options/configurations
- Supports multiple browser types (Chrome, Firefox, Edge, etc)

### 5. **JsonDataReader.java** - Test Data Management

```java
public static Object[][] getJsonData(String resourcePath) {
    // Reads JSON file
    // Converts to 2D array for TestNG DataProvider
    // Returns test data
}
```

**Advantages:**
- Separates test data from test logic
- Easy to add new test scenarios
- Supports multiple data sets
- Uses Jackson library for JSON parsing

### 6. **Listener.java** - Test Reporting

```java
public class Listener implements ITestListener {
    public void onTestStart(ITestResult result) { }
    public void onTestSuccess(ITestResult result) { }
    public void onTestFailure(ITestResult result) { }
}
```

**Generates:**
- Test execution reports
- Pass/fail statistics
- Screenshots on failure
- Execution logs

---

## Test Workflow

### Step-by-Step Execution Flow

```
1. START TEST
   ↓
2. SETUP (BaseTest)
   - Initialize Chrome WebDriver
   - Navigate to application URL
   ↓
3. READ TEST DATA
   - Load credentials from Login_Data.json
   ↓
4. LOGIN FLOW
   - Click Login button
   - Enter email
   - Enter password
   - Click Submit
   ↓
5. DEVICE SELECTION FLOW
   - Open Dropdown menu
   - Click Learning Materials
   - Click Next
   ↓
6. DEVICE CONFIGURATION FLOW
   - Select Device Type: Phone
   - Select Brand: Apple
   - Choose Storage
   - Select Color: Blue
   - Enter Quantity: 2
   ↓
7. DELIVERY FLOW
   - Enter Address: "Oak Avenue Ferndale"
   - Click Next
   ↓
8. SHIPPING & WARRANTY FLOW
   - Choose Express Shipping
   - Choose Warranty
   ↓
9. PURCHASE FLOW
   - Apply Discount: "SAVE10"
   - Complete Purchase
   ↓
10. VERIFICATION FLOW
    - View Purchase History
    - Click First Invoice
    ↓
11. TEARDOWN
    - Close browser
    - Generate report
    ↓
12. END TEST
```

---

## How to Run Tests

### Option 1: Run via Maven Command Line

```bash
# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=LoginTest

# Run specific test method
mvn test -Dtest=LoginTest#LoginWithValidInformation

# Skip tests
mvn clean install -DskipTests
```

### Option 2: Run via TestNG XML (testng.xml)

```bash
# From project root
mvn test -Dtestng.xml=TestRunner/testng.xml
```

### Option 3: Run from IDE (IntelliJ IDEA)

1. Right-click on `LoginTest.java` file
2. Select **Run 'LoginTest'** or **Run with Coverage**
3. View results in TestNG Console

### Option 4: Run from Command Line (Direct Execution)

```bash
java -cp target/test-classes:target/classes:... org.testng.TestNG testng.xml
```

---

## Test Data Configuration

### Login_Data.json Structure

```json
[
  {
    "email": "user@example.com",
    "password": "password123"
  },
  {
    "email": "test@test.com",
    "password": "test1234"
  }
]
```

**Location:** `src/test/resources/testdata/Login_Data.json`

**How It Works:**
1. TestNG DataProvider reads this file
2. Creates multiple test instances (one per JSON object)
3. Passes data as JsonNode object to test method
4. Test extracts values: `data.get("email").asText()`

### Adding New Test Data

Simply add a new object to the JSON array:
```json
{
  "email": "newemail@domain.com",
  "password": "newpassword123"
}
```

The test will automatically run with this new data set.

---

## Challenges & Solutions

### Challenge 1: Element Not Interactable (Learning Materials Click)

**Problem:**
- Test was trying to click "Learning Materials" element
- Element was found but not clickable
- Error: `ElementNotInteractableException`

**Root Cause:**
- "Learning Materials" link appeared both before and after login
- Test was clicking the pre-login version (not in viewport or overlapped)
- Navigation bar was blocking the element

**Solution Implemented:**
- Added **explicit wait** to ensure element visibility
- Used **JavaScript executor** to scroll element into view
- Modified selector to target post-login version specifically
- Increased wait timeout to 20 seconds

```java
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
wait.until(ExpectedConditions.elementToBeClickable(learningMaterialsOption));
```

### Challenge 2: TestNG Dependency Injection Error

**Problem:**
- Error: `Cannot inject @Test annotated Method with [class java.lang.String, class java.lang.String]`

**Root Cause:**
- Test method parameters didn't match DataProvider output
- TestNG couldn't map parameters correctly

**Solution:**
- Changed parameter type from `String` to `JsonNode`
- Ensured DataProvider returns correct data type
- Verified method signature matches provider

```java
// Before (Wrong)
@Test(dataProvider = "loginData")
public void LoginWithValidInformation(String email, String password)

// After (Correct)
@Test(dataProvider = "loginData")
public void LoginWithValidInformation(JsonNode data)
```

### Challenge 3: Dynamic Select Dropdown (DeviceType)

**Problem:**
- DeviceType field wasn't a traditional HTML `<select>` element
- It was a custom `<span>` element styled as a dropdown
- Selenium `Select` class doesn't work with non-select elements

**Solution:**
- Found the actual clickable button element
- Used click action instead of Select class
- Located option within dropdown menu
- Clicked to select

### Challenge 4: Java Source Version Mismatch

**Problem:**
- Error: `Module Thami_Java_Selenium SDK 21 does not support source version 1.5`

**Root Cause:**
- pom.xml compiler settings didn't match IDE SDK version

**Solution:**
- Updated pom.xml to use Java 21:
```xml
<properties>
    <maven.compiler.source>21</maven.compiler.source>
    <maven.compiler.target>21</maven.compiler.target>
</properties>
```

---

## Troubleshooting

### Issue: "Cannot find Chrome driver"

**Solution:**
- WebDriverManager automatically handles this
- If still failing, ensure Chrome browser is installed
- Check Chrome version compatibility (v145 recommended)

### Issue: Test times out waiting for element

**Solution:**
```java
// Increase wait time
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
wait.until(ExpectedConditions.presenceOfElementLocated(By.id("element-id")));
```

### Issue: "Element not found" errors

**Solution:**
- Verify XPath/locator is correct using browser DevTools
- Check element is not in iframe or shadow DOM
- Add explicit waits before interacting
- Use multiple fallback locators

### Issue: StaleElementReferenceException

**Solution:**
- Re-find element before each action
- Use fresh WebElement references
- Avoid storing elements in variables across page loads

### Issue: Tests pass individually but fail in suite

**Solution:**
- Check for shared test data or state
- Ensure proper setup/teardown
- Add `@BeforeMethod` and `@AfterMethod` annotations
- Check for browser instance reuse issues

### Issue: Report not generated

**Solution:**
- Check `target/Reports/` directory
- Verify Listener is registered in testng.xml
- Ensure ExtentReportManager is initialized
- Check file permissions

---

## Test Execution Results

### Sample Test Report Location
```
target/Reports/ExtentReport.html
target/surefire-reports/
```

### Viewing Reports

1. **Extent Report:**
   - Open: `target/Reports/ExtentReport.html` in web browser
   - Shows: Test names, status, execution time, logs

2. **TestNG Report:**
   - Open: `target/surefire-reports/index.html`
   - Shows: Pass/fail count, detailed results, graphs

3. **Maven Console Output:**
   - Shows: Build status, test count, execution time
   ```
   Tests run: 1, Passes: 1, Failures: 0, Skips: 0
   ```

---

## Best Practices Implemented

✅ **Page Object Model** - Separation of concerns  
✅ **Data-Driven Testing** - External test data (JSON)  
✅ **Explicit Waits** - Reliable element detection  
✅ **Maven Build Tool** - Dependency management  
✅ **TestNG Framework** - Advanced test features  
✅ **Test Listeners** - Automatic reporting  
✅ **WebDriverManager** - Automatic driver management  
✅ **Descriptive Test Names** - Clear test intent  
✅ **Proper Error Handling** - Informative messages  
✅ **Modular Code** - Reusable components  

---

## Future Improvements

- [ ] Add Parallel Test Execution
- [ ] Implement CI/CD Pipeline (Jenkins/GitHub Actions)
- [ ] Add API Testing Layer
- [ ] Implement Visual Regression Testing
- [ ] Add Database Validation
- [ ] Create Utility Methods Library
- [ ] Add Screenshot on Failure
- [ ] Implement Custom Assertions
- [ ] Add Performance Testing
- [ ] Create Smoke/Sanity Test Suites

---

## Contact & Support

**Project Owner:** Thami Maseko  
**Application URL:** https://ndosisimplifiedautomation.vercel.app/  
**Framework Version:** Selenium 4.18.1 + TestNG 7.9.0  
**Java Version:** 21

---

**Last Updated:** March 8, 2026  
**Documentation Version:** 1.0

