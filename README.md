# Selenium-Java-TestNG

Selenium WebUI Test automation framework using Java and TestNG.

## Features
Page Object Model

Report

Log

## Pre-requisite
Install and setup path for [JDK](https://docs.oracle.com/en/java/javase/18/install/overview-jdk-installation.html#GUID-8677A77F-231A-40F7-98B9-1FD0B48C346A)

Install and setup path for [Maven](https://maven.apache.org/install.html)

Install [Intellij IDEA](https://www.jetbrains.com/idea/download) or preferable IDE

Install and setup path for [Allure](https://docs.qameta.io/allure/)

Install [Git](https://git-scm.com/downloads)

Install relevant browsers (Chrome, Firefox, Edge, Safari-not tested, Headless)

## Installation

Make a git clone

```bash
git clone https://github.com/daz-mitra/selenium-java-testng.git
```
Checkout to need branch

## Usage

### Configuration
Add browser name, baseURL, test data path, screenshot path to config.properties file under src>main>resources

```property
BROWSER=Chrome
URL=https://www.saucedemo.com/
TEST_DATA_PATH=./TestData/testdata.xlsx
SCREENSHOT_PATH=./Screenshots/
```
Supported BROWSERs Chrome, Firefox, Edge, Safari & Headless (Browser has to be installed before execution)

### Pages
Create Page classes inherit from BasePage under src>main>java>pages
There declare page elements as variables and page actions as methods

eg:
```java
public class LoginPage extends BasePage{
    private static final Logger logger = LogManager.getLogger(ProductsPage.class);

    private By username = By.id("user-name");
    
    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void enterUsername(String Username){
        EnterKeys(username,Username);
        logger.info("Enter username: "+Username);
    }
}
```
### BasePage

Base page is the supper class for page classes. Can Add general methods which common for page classes.

eg:
```java
public abstract class BasePage {
    public final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void EnterKeys(By locator, String text) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(locator));
        this.driver.findElement(locator).sendKeys(text);
    }
}
```