
import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Drivers;
import utils.Screenshots;
import utils.XLSReader;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class testDataDriven extends Drivers{

    private static final Logger logger = LogManager.getLogger(testDataDriven.class);

    @Test(dataProviderClass = XLSReader.class,dataProvider = "logindata")
    public void testLogin(String username, String password) throws IOException {

        driver.get(baseURL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        String actualUrl = loginPage.currentURL();
        Screenshots sc = new Screenshots(driver);
        sc.addScreenshotToReport("LoginTest");
        Assert.assertEquals(actualUrl,"https://www.saucedemo.com/inventory.html","Invalid login credentials");
    }

}
