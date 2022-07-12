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

    @Test(dataProvider = "testdata")
    public void testTestData(String username, String password)  {
        driver.get(baseURL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        String actualUrl = loginPage.currentURL();
        Assert.assertEquals(actualUrl,"https://www.saucedemo.com/inventory.html","Invalid login credentials");
    }

    @DataProvider(name = "testdata")
    public Object[][] tdata(){
        return new Object[][]{
                {"standard_user","secret_sauce"},
                {"locked_out_user","secret_sauce"},
                {"problem_user","secret_sauce"},
                {"performance_glitch_user","secret_sauce"}
        };
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
