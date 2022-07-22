package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    private static final Logger logger = LogManager.getLogger(ProductsPage.class);

    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.xpath("//h3");
    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void enterUsername(String Username){
        EnterKeys(username,Username);
        logger.info("Enter username: "+Username);
    }
    public void enterPassword(String Password){
        EnterKeys(password,Password);
        logger.info("Enter password: "+Password);
    }
    public void clickLogin(){
        ClickButton(loginButton);
        logger.info("Click login button");
    }
    public String currentURL(){
        logger.info("Get current URL");
        return GetUrl();
    }
    public String getErrorMessage(){
        logger.info("Get Error message");
        return GetElementText(errorMessage);
    }
    public boolean isUsernameFieldDisplayed(){
        logger.info("Verifying user name is displaying");
        return ElementDisplayed(username);
    }
}
