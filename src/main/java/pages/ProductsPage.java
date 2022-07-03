package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage{

    private By prodBackpack= By.xpath("//a[@id='item_4_title_link']/div");
    private By backpackPageTitle = By.xpath("//div[@class='inventory_details_name large_size']");
    private By btnBackpackAddToCart = By.id("add-to-cart-sauce-labs-backpack");
    private By btnRemoveBackpack = By.id("remove-sauce-labs-backpack");
    public ProductsPage(WebDriver driver){
        super(driver);
    }
    public void clickBackpack(){
        ClickButton(prodBackpack);
    }
    public String getBackpackTitle(){
        return GetElementText(backpackPageTitle);
    }
    public void clickBackpackAddToCart(){
        ClickButton(btnBackpackAddToCart);
    }
    public boolean displayBackpackRemoveButton(){
        return ElementDisplayed(btnRemoveBackpack);
    }
}
