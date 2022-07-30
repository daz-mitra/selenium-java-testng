package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage{
    private static final Logger logger = LogManager.getLogger(ProductsPage.class);

    private By prodBackpack= By.xpath("//a[@id='item_4_title_link']/div");
    private By testAllThingsTShirt= By.xpath("//a[@id='item_3_title_link']/div");
    private By testAllThingsTShirtButton = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");
    private By backpackPageTitle = By.xpath("//div[@class='inventory_details_name large_size']");
    private By btnBackpackAddToCart = By.id("add-to-cart-sauce-labs-backpack");
    private By btnRemoveBackpack = By.id("remove-sauce-labs-backpack");
    private By btnHamburgerMenu = By.id("react-burger-menu-btn");
    private By btnLogout = By.id("logout_sidebar_link");
    private By btnResetAppState = By.id("reset_sidebar_link");

    private By testShoppingCartCount = By.className("shopping_cart_badge");
    private By closeHamburgerMenu = By.id("react-burger-cross-btn");

    public ProductsPage(WebDriver driver){
        super(driver);
    }
    public void clickBackpack(){
        ClickButton(prodBackpack);
        logger.info("click Backpack");
    }
    public String getBackpackTitle(){
        logger.info("Backpack Title: "+GetElementText(backpackPageTitle));
        return GetElementText(backpackPageTitle);
    }
    public void clickBackpackAddToCart(){
        ClickButton(btnBackpackAddToCart);
        logger.info("Click Backpack Add to cart");
    }
    public boolean displayBackpackRemoveButton(){
        logger.info("element displayed");
        return ElementDisplayed(btnRemoveBackpack);
    }
    public void scrollIntoTShirt(){
        logger.info("Scrolling into T-Shirt");
        scrollIntoView(testAllThingsTShirt);
    }
    public void clickTShirt(){
        ClickButton(testAllThingsTShirt);
        logger.info("click TShirt");
    }
    public boolean displayTShirtButton(){
        logger.info("element displayed");
        return ElementDisplayed(testAllThingsTShirtButton);
    }

    public void clickHamburgerMenu(){
        logger.info("click hamburger menu");
        ClickButton(btnHamburgerMenu);
    }

    public void clickLogoutButton(){
        logger.info("click logout");
        ClickButton(btnLogout);
    }
    public void clickRestAppStateButton(){
        logger.info("click reset app state");
        ClickButton(btnResetAppState);
    }

    public boolean isShoppingCartBadgeEmpty(){
        logger.info("is shopping cart badge empty");
        return isElementEmpty(testShoppingCartCount);
    }

    public void closeHamburgerMenu(){
        logger.info("close hamburger menu");
        ClickButton(closeHamburgerMenu);
    }

}
