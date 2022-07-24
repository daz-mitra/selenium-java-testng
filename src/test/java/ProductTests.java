import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import utils.Drivers;
import utils.Screenshot;

import java.io.IOException;

public class ProductTests extends Drivers {

    @BeforeTest
    public void startBrowser(){
        driver.get(baseURL);
    }

    @Test
    public void testNavigateToProduct()  {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        ProductsPage productsPage= new ProductsPage(driver);
        productsPage.clickBackpack();
        Assert.assertEquals(productsPage.getBackpackTitle(),"Sauce Labs Backpack");
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
        sc.takeScreenshot();
    }

    @Test
    public void testAddTShirt() throws IOException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        ProductsPage productsPage= new ProductsPage(driver);
        productsPage.scrollIntoTShirt();
        productsPage.clickTShirt();
        Screenshot sc = new Screenshot(driver);
        sc.takeScreenshot();

    }
    @AfterTest
    public void quitBrowser(){
        driver.close();
    }
}
