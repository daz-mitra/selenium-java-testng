package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage{
    private static final Logger logger = LogManager.getLogger(ProductsPage.class);

    private By prodBackpack= By.xpath("//a[@id='item_4_title_link']/div");
    private By backpackPageTitle = By.xpath("//div[@class='inventory_details_name large_size']");
    private By btnBackpackAddToCart = By.id("add-to-cart-sauce-labs-backpack");
    private By btnRemoveBackpack = By.id("remove-sauce-labs-backpack");

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
}
