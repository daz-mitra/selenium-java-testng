
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Drivers;
import utils.ScreenCapture;
import utils.XLSReader;

public class testDataDriven extends Drivers{

    private static final Logger logger = LogManager.getLogger(testDataDriven.class);

    @Test(dataProviderClass = XLSReader.class,dataProvider = "logindata")
    public void testLogin(String username, String password)  {

        driver.get(baseURL);
        LoginPage loginPage = new LoginPage(driver);
        ScreenCapture screenCapture=new ScreenCapture();
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        screenCapture.CaptureScreenShot(driver);
        loginPage.clickLogin();
        String actualUrl = loginPage.currentURL();
        Assert.assertEquals(actualUrl,"https://www.saucedemo.com/inventory.html","Invalid login credentials");
    }

}
