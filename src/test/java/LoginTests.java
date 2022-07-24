import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Drivers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.Screenshot;

import java.io.IOException;

public class LoginTests extends Drivers {

    private static final Logger logger = LogManager.getLogger(LoginTests.class);


    //@BeforeTest
    public void startBrowser(){
        driver.get(baseURL);
    }

    @AfterTest
    public void quitBrowser(){
        driver.quit();
    }

    @Test
    public void testNavigateSauceLabDemo(){
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isUsernameFieldDisplayed());
    }

    @Test
    public void testSuccessfulLogin() throws IOException {
        LoginPage loginPage = new LoginPage(driver);
        Screenshot screenshot = new Screenshot(driver);
        logger.info("Load base URL");
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        String actualUrl = loginPage.currentURL();
        Assert.assertEquals(actualUrl,"https://www.saucedemo.com/inventory.html");
        screenshot.takeFullPageScreenshot();
    }

    @Test
    public void testInvalidLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("dccdcd");
        loginPage.enterPassword("xsxsxsx");
        loginPage.clickLogin();
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(errorMessage,"Epic sadface: Username and password do not match any user in this service");
    }


}
