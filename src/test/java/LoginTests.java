import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Drivers;

public class LoginTests extends Drivers {


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
    public void testSuccessfulLogin()  {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        String actualUrl = loginPage.currentURL();
        Assert.assertEquals(actualUrl,"https://www.saucedemo.com/inventory.html");
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
