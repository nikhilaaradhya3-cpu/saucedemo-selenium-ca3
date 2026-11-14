# SauceDemo Test Automation (CA3, ISE2501)

**Course:** Software Testing & Quality Assurance (ISE2501), CA3

**Section:** 5ISE01

**Team Number:** 1

| Student | Name | Roll No. | Role |
|---|---|---|---|
| A | Nikhil D P | 20241ISE0014 | Automation Architect & Framework Engineer |
| B | Anivith H G | 20241ISE0031 | Test Designer & White-Box Specialist |

**Target application:** SauceDemo, https://www.saucedemo.com

Selenium WebDriver + JUnit 5 + Page Object Model, with formal test design (ECP, BVA) and white-box analysis (CFG, cyclomatic complexity, basis paths).

## Tech stack
Java 17+, Selenium 4.25.0, JUnit Jupiter 5.11.0, AssertJ 3.26.3, WebDriverManager 5.9.2, Maven, Eclipse

## Project structure
```
src/main/java/pages   Page Objects: BasePage, LoginPage, InventoryPage, CartPage, CheckoutPage
src/main/java/logic   CheckoutDiscountCalculator (white-box module)
src/test/java/base    BaseTest (WebDriver lifecycle, browser switch)
src/test/java/tests   SmokeTest, LoginTest, CheckoutTest, DiscountTest, DefectTest
demo/                 Screen recordings of the test runs
```

## Setup (step by step)
1. Install **JDK 17 or newer**, **Google Chrome**, **Git** and **Eclipse IDE for Java Developers** (it includes Maven).
2. Clone the repository:
   `git clone https://github.com/nikhilaaradhya3-cpu/saucedemo-selenium-ca3.git`
3. In Eclipse: **File > Import > Maven > Existing Maven Projects**, choose the cloned folder, and click Finish.
4. Right-click the project, then **Maven > Update Project**, and wait for the dependencies to download.
5. Check **Project > Properties > Java Compiler**: compliance level 17.

## Running the tests
- **All tests:** right-click the project, then **Run As > JUnit Test**.
- **One class:** right-click the class (for example `LoginTest`), then **Run As > JUnit Test**.
- **Cross-browser:** open **Run > Run Configurations > JUnit**, select a class, and add a VM argument on the **Arguments** tab:
  - Edge: `-Dbrowser=edge -Dwebdriver.edge.driver=C:\drivers\msedgedriver.exe` (download the msedgedriver that matches your Edge version from the Microsoft Edge WebDriver page)
  - Firefox: `-Dbrowser=firefox`
  - Chrome is the default when no argument is given.
- **Command line (optional):** `mvn test` (add `-Dbrowser=edge` or `-Dbrowser=firefox`)

## Test design summary
- **ECP:** login (username, password) and checkout form fields (first name, last name, postal code), plus quantity and order value for the discount module.
- **BVA:** quantity range 1 to 10 tested at Min-1, Min, Min+1, Nominal, Max-1, Max, Max+1.
- **White-box:** `CheckoutDiscountCalculator.calculateDiscount` has 15 nodes, 20 edges and 6 decision nodes, so cyclomatic complexity VG = 7, with 7 independent basis paths covered by `DiscountTest`.

## Results
| Class | Tests | Result |
|---|---|---|
| LoginTest | 5 | passed |
| CheckoutTest | 4 | passed |
| DiscountTest | 12 | passed |
| SmokeTest | 1 | passed |
| DefectTest | 1 | passed (documents defect DEF-01) |
| **Total** | **23** | **23 passed, 0 failed, 0 skipped** |

## Known defect DEF-01
With `problem_user`, the checkout information form does not let the user continue: the app stays on `checkout-step-one.html` instead of moving to `checkout-step-two.html`. `DefectTest` documents this behaviour. The same flow works for `standard_user`.

## Demo
Screen recordings of the test runs are in the `demo/` folder.
