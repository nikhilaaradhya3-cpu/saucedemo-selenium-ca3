# SauceDemo Test Automation (CA3, ISE2501)

Course: Software Testing & Quality Assurance (ISE2501), CA3
Section: 5ISE01
Team Number: 1

Team:
1. Nikhil D P (20241ISE0014)
2. Anivith H G (20241ISE0031)

Selenium WebDriver + JUnit 5 + Page Object Model, run against https://www.saucedemo.com

## Structure
- src/main/java/pages: Page Objects (BasePage, LoginPage, InventoryPage, CartPage, CheckoutPage)
- src/main/java/logic: CheckoutDiscountCalculator (white-box module)
- src/test/java/tests: LoginTest, CheckoutTest, DiscountTest, DefectTest

## Prerequisites
JDK 17+, Maven, Google Chrome

## Run
mvn test

Or in Eclipse: right-click a test class, then Run As, then JUnit Test.

## Results
- LoginTest: 5/5 passed
- CheckoutTest: 4/4 passed
- DiscountTest: 12/12 passed
- DefectTest: 1 failure, which is the confirmed defect DEF-01 (problem_user cannot proceed past checkout step one)
