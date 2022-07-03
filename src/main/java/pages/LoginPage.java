package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.xpath("//h3");
    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void enterUsername(String Username){
        EnterKeys(username,Username);
    }
    public void enterPassword(String Password){
        EnterKeys(password,Password);
    }
    public void clickLogin(){
        ClickButton(loginButton);
    }
    public String currentURL(){
        return GetUrl();
    }
    public String getErrorMessage(){
        return GetElementText(errorMessage);
    }
    public boolean isUsernameFieldDisplayed(){
        return ElementDisplayed(username);
    }
}
