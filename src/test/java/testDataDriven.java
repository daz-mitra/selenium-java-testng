
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Drivers;
import utils.XLSReader;

public class testDataDriven extends Drivers{

    @Test(dataProviderClass = XLSReader.class,dataProvider = "logindata")
    public void testLogin(String username, String password)  {

        driver.get(baseURL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        String actualUrl = loginPage.currentURL();
        Assert.assertEquals(actualUrl,"https://www.saucedemo.com/inventory.html","Invalid login credentials");
    }

}
