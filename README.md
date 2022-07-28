# Selenium-Java-TestNG

Selenium WebUI Test automation framework using Java and TestNG.

## Features
1. Page Object Model

2. Reports with screenshots

3. Logs

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

### Test Classes
Can add test classes which contains tests under src>test>java and can create extends from Drivers class

```java
public class ProductTests extends Drivers {

    @BeforeTest
    public void startBrowser(){
        driver.get(baseURL);
    }

    @Test
    public void testAddToCartProduct() throws IOException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        ProductsPage productsPage= new ProductsPage(driver);
        productsPage.clickBackpack();
        productsPage.clickBackpackAddToCart();
        Assert.assertTrue(productsPage.displayBackpackRemoveButton());
        Screenshot sc = new Screenshot(driver);
        sc.takeScreenshot("testAddToCartProduct");
    }
    @AfterTest
    public void quitBrowser(){
        driver.close();
    }
}
```
### Data Driven Tests
1. Create a test class as mentioned above.

2. Create a test method with dataProviderClass and dataProvider annotations.

3. Pass parameters with the method name.

eg:

```java
public class testDataDriven extends Drivers{

    @Test(dataProviderClass = XLSReader.class,dataProvider = "logindata")
    public void testLogin(String username, String password) throws IOException {

        driver.get(baseURL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        String actualUrl = loginPage.currentURL();
        Assert.assertEquals(actualUrl,"https://www.saucedemo.com/inventory.html","Invalid login credentials");
        Screenshot sc = new Screenshot(driver);
        sc.takeScreenshot("testLogin");
    }

}
```
4. Add a sheet to the excel file in the /TestData/testdata.xlsx file with the name of dataProvider.

5. Add data to the created excel sheet with the column headings.

eg:
```excel
|username | password |
----------------------
|standard_user |secret_sauce|
|locked_out_user| secret_sauce|

```
### Assertions
Can use TestNG assertions to verify the results.
For more information, visit [TestNG](https://testng.org/)

### Log
This test automation framework is log enabled with log4j2

Declare logger variable in the class and use

eg:
```java
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
Can use fatal, error, warn, info, debug and trace methods

Logging info will display in the console and the .log files under /logs folder

For more information, visit [log4j](https://logging.apache.org/log4j/2.x/) 

### Screenshots
There are two types of screenshots available in this framework takeFullPageScreenshot(String methodName) and takeScreenshot(String methodName).

1. takeScreenshot(String methodName) - takes screenshot of the current view. works for every driver
2. takeFullPageScreenshot(String methodName) - takes screenshot of the current view. works only with firefox driver.

Screenshots saves in /Screenshots folder

### Reports
Reports generates as .json file inside of the /allure-results folder

In order to view the reports, open terminal enter below command to start allure server.
```terminal
allure serve <source folder>\allure-results
```
eg:
```terminal
allure serve D:\InterestGroups\selenium-java-testng\allure-results
```
Report will open in the browser.

### Execute Tests

Run using terminal

```terminal
# Run all the unit test classes.
$ mvn test

# Run a single test class.
$ mvn -Dtest=TestApp1 test

# Run multiple test classes.
$ mvn -Dtest=TestApp1,TestApp2 test

# Run a single test method from a test class.
$ mvn -Dtest=TestApp1#methodname test

# Run all test methods that match pattern 'testHello*' from a test class.
$ mvn -Dtest=TestApp1#testHello* test

# Run all test methods match pattern 'testHello*' and 'testMagic*' from a test class.
$ mvn -Dtest=TestApp1#testHello*+testMagic* test
```

