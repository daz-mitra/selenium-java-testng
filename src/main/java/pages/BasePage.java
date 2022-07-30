package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    public final WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver= driver;
    }

    public void EnterKeys(By locator, String text){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(locator));
        this.driver.findElement(locator).sendKeys(text);
    }
    public void ClickButton(By locator){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(locator));
        this.driver.findElement(locator).click();
    }
    public String GetUrl(){
        return this.driver.getCurrentUrl();
    }
    public String GetElementText(By locator){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(locator));
        return this.driver.findElement(locator).getText();
    }
    public boolean ElementDisplayed(By locator){
        return this.driver.findElement(locator).isDisplayed();
    }
    public void scrollIntoView(By locator){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(locator));
        String script = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor)driver).executeScript(script,driver.findElement(locator));
    }
    public Boolean isElementEmpty(By locator){
        new WebDriverWait(driver,Duration.ofSeconds(5));
        return this.driver.findElements(locator).isEmpty();
    }
}
