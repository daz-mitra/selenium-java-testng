package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class Screenshot {
    public static WebDriver driver;
    public static PropertyFileReader propertyFileReader = new PropertyFileReader();
    public static String SS_PATH = propertyFileReader.getProperty("config","SCREENSHOT_PATH");

    public Screenshot(WebDriver driver){
        this.driver = driver;
    }

    //Works with firefox only
    public void takeFullPageScreenshot() throws IOException {
        TimeStamp ts = new TimeStamp();
        File source = ((FirefoxDriver)driver).getFullPageScreenshotAs(OutputType.FILE);
        FileHandler.copy(source, new File(SS_PATH+"TestScreenshot"+ts.getTimestamp()+".png"));
    }

    public void takeScreenshot(String testName) throws IOException {
        TimeStamp ts = new TimeStamp();
        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(source, new File(SS_PATH+testName+ts.getTimestamp()+".png"));
    }
}
