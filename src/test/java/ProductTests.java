import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import utils.Drivers;
import utils.Screenshots;

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

    //works only with Firefox
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
        Screenshots sc = new Screenshots(driver);
        sc.takeFullPageScreenshot("TestAddTShirt");
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
        Assert.assertTrue(productsPage.displayTShirtButton());
        Screenshots sc = new Screenshots(driver);
        sc.takeScreenshot("testAddToCartProduct");
    }
    @AfterTest
    public void quitBrowser(){
        driver.close();
    }
}
