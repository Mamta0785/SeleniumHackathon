# 🌿 **DIA – Dietitian Intuitive Assistant**  
### *Selenium BDD Automation Framework (Cross‑Browser | Parallel‑Ready | Thread‑Safe)*

DIA (Dietitian Intuitive Assistant) is an AI‑powered nutrition platform designed to transform global dietetics through intelligent patient management.  
This repository contains a **scalable, enterprise‑grade Selenium BDD automation framework** built to automate DIA’s core modules:

- **Login as Dietitian**  
- **Add Patient**  
- **Edit Patient**  
- **View Patient**

The framework supports **cross‑browser execution**, **optional parallel execution**, **ThreadLocal WebDriver**, **Cucumber BDD**, and **TestNG orchestration**.

---

# 🚀 **Key Features**

- **Cucumber BDD** with PicoContainer dependency injection  
- **TestNG Runner** with cross‑browser execution  
- **Parallel execution toggle** (`@DataProvider(parallel = false)` by default)  
- **ThreadLocal WebDriver** for safe parallel runs  
- **Custom TestContext** for scenario‑level state sharing  
- **Page Object Model (POM)** with lazy initialization  
- **Hooks for setup, teardown, screenshots**  
- **Centralized DriverFactory**  
- **Supports Chrome, Edge, Firefox**  
- **Excel‑driven test data (Apache POI)**  
- **Rich reporting: Extent, ChainTest, Allure**  
- **Java 21 + Selenium 4.34**  
- **CI/CD ready (Jenkins, GitHub Actions)**  

---

# 🧱 **High‑Level Architecture**

```
┌──────────────────────────────────────────────┐
│                TestNG Runner                 │
│  • parallel=false (default)                  │
│  • cross-browser via <test> blocks           │
│  • passes browserName to @BeforeClass        │
└───────────────────────┬──────────────────────┘
                        │
                        ▼
┌──────────────────────────────────────────────┐
│              Cucumber + PicoContainer         │
│  • Creates ONE TestContext per scenario       │
│  • Injects TestContext into Hooks + Steps     │
└───────────────────────┬──────────────────────┘
                        │
                        ▼
┌──────────────────────────────────────────────┐
│                  TestContext                 │
│  • Holds:                                     │
│       - DriverFactory instance                │
│       - WebDriver (after setup)               │
│       - PageObjectManager                     │
│       - LoginPage                             │
│       - testData map                          │
│  • initializeContext():                       │
│       - driver = DriverFactory.getDriver()    │
│       - pomManager = new PageObjectManager()   │
│       - loginPage = new LoginPage()           │
└───────────────────────┬──────────────────────┘
                        │
                        ▼
┌──────────────────────────────────────────────┐
│                     Hooks                    │
│  @Before:                                      │
│    • Reads browser from TestRunner.browserName │
│    • DriverFactory.launchBrowser(browser)      │
│    • context.initializeContext()               │
│    • Navigate to baseURL                       │
│                                                │
│  @AfterStep: take screenshot                   │
│  @After: driverFactory.closeDriver()           │
└───────────────────────┬──────────────────────┘
                        │
                        ▼
┌──────────────────────────────────────────────┐
│                 DriverFactory                │
│  • ThreadLocal<WebDriver> mydriver            │
│  • launchBrowser(browser):                    │
│       - new ChromeDriver / Edge / Firefox     │
│       - maximize, delete cookies, waits       │
│  • getDriver(): returns ThreadLocal driver    │
│  • closeDriver(): quit + remove               │
└───────────────────────┬──────────────────────┘
                        │
                        ▼
┌──────────────────────────────────────────────┐
│              PageObjectManager               │
│  • Created inside TestContext                 │
│  • Lazily creates:                            │
│       - LoginPage                              │
│       - DashboardPage                          │
│       - AddPatientPage                         │
│       - EditPatientPage                        │
│       - MyPatientPage                          │
│       - ViewTestReportPage                     │
└───────────────────────┬──────────────────────┘
                        │
                        ▼
┌──────────────────────────────────────────────┐
│               Step Definitions               │
│  • Injected with TestContext                  │
│  • Use:                                       │
│       - context.pomManager                     │
│       - context.loginPage                     │
│       - context.driverFactory                 │
│       - context.driver                        │
└──────────────────────────────────────────────┘
```

---

# 🌐 **Cross‑Browser Execution Flow**

1. **TestNG XML** defines 3 `<test>` blocks → Chrome, Edge, Firefox  
2. TestNG creates **3 TestRunner instances**  
3. Each instance passes its browser to `@BeforeClass`  
4. TestRunner stores browser in **ThreadLocal**  
5. Hooks read browser from TestRunner  
6. Hooks call `DriverFactory.launchBrowser(browser)`  
7. DriverFactory creates a **ThreadLocal WebDriver**  
8. Hooks call `context.initializeContext()`  
9. PageObjectManager + LoginPage are initialized  
10. Cucumber runs scenarios (parallel optional)  
11. After scenario → driver quits + ThreadLocal cleanup  

---

# 🧪 **How to Run Tests**

## ✔ **Default: Run in Chrome (parallel OFF)**  


```java
@DataProvider(parallel = false)
```

Run:

```
mvn clean test -P chrome
```

---

## ✔ **Run Cross‑Browser (Chrome + Edge + Firefox)**  


```
crossBrowser
```

Run:

```
mvn clean test -P crossBrowser
```

This uses **testngCrossBrowser.xml**.

---

## ✔ **Enable Parallel Execution (Optional)**  
If you want parallel execution:

Change:

```java
@DataProvider(parallel = false)
```

to:

```java
@DataProvider(parallel = true)
```

Then run:

```
mvn clean test -P chrome
```

Parallel execution will run **all scenarios in Chrome**.

---

## ✔ **Run specific feature or tag**

```
mvn clean test -Dcucumber.filter.tags="@addPatient"
```

---

# 📁 **Project Structure**

```
src
 ├── main
 │    └── java
 │         └── utils/
 │              ├── TestContext.java
 │              ├── LoggerLoad.java
 │              └── Config utilities...
 │
 └── test
      ├── java
      │    ├── runner/
      │    │     └── TestRunner.java
      │    ├── hooks/
      │    │     └── Hooks.java
      │    ├── stepdefinition/
      │    ├── pageobjects/
      │    └── DriverManager/
      │          └── DriverFactory.java
      │
      └── resources
           ├── features/
           ├── testng.xml
           ├── testngCrossBrowser.xml
           └── config.properties
```

---

# 📦 **Tech Stack**

- **Java 21**  
- **Selenium WebDriver 4.34**  
- **Cucumber BDD 7.14**  
- **TestNG 7.11**  
- **PicoContainer**  
- **Extent Reports 5.1.2**  
- **ChainTest Cucumber Plugin**  
- **Allure TestNG 2.29.1**  
- **Apache POI 5.4.1**  
- **FreeMarker 2.3.33** (required by ChainTest)  
- **JNA 5.14.0** (required by Selenium 4.11+)  
- **Maven**  

---

# 🧑‍⚕️ **DIA Modules Automated**

### ✔ Login as Dietitian  
### ✔ Add Patient  
### ✔ Edit Patient  
### ✔ View Patient  

Each module includes:

- Positive flows  
- Negative validations  
- Field validations  
- Table/pagination checks  
- Success/error message validations  

---

# 📸 **Reporting**

### **Reports Generated**
- **Extent HTML Report** → `target/ExtentReports/`  
- **Cucumber HTML** → `target/SeleniumHackathon.html`  
- **Cucumber JSON** → `target/cucumber.json`  
- **ChainTest Report**  
- **Allure Results** → `allure-results/`  

Screenshots captured on failure via `@AfterStep`.

---

# 🛠 **Why Certain Dependencies Exist**

### **FreeMarker 2.3.33**
Required because ChainTest depends on this version.

### **JNA 5.14.0**
Required by Selenium 4.11+ for native OS interactions.

### **Apache POI**
Used for Excel‑driven test data.



---

# 🏁 **Conclusion**

This framework is designed to be:

- **Scalable**  
- **Maintainable**  
- **Parallel‑ready (optional)**  
- **Cross‑browser capable**  
- **CI/CD friendly**  

