package utils;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.EdgeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import io.github.bonigarcia.wdm.managers.SafariDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class Drivers {
    public static WebDriver driver;
    public static PropertyFileReader propertyFileReader = new PropertyFileReader();
    public static String browser = propertyFileReader.getProperty("config","BROWSER");
    public static String baseURL = propertyFileReader.getProperty("config","URL");

    @BeforeSuite
    public void setupDriver(){
        if (browser==null){
            ChromeDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else {
            switch (browser){
                case "Chrome":
                    ChromeDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    break;
                case "Firefox":
                    FirefoxDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    driver.manage().window().maximize();
                    break;
                case "Edge":
                    EdgeDriverManager.edgedriver().setup();
                    driver= new EdgeDriver();
                    driver.manage().window().maximize();
                    break;
                case "Safari":
                    SafariDriverManager.safaridriver().setup();
                    driver= new SafariDriver();
                    driver.manage().window().maximize();
                case "Headless":
                    ChromeDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--headless");
                    driver = new ChromeDriver(chromeOptions);
                    driver.manage().window().maximize();
                default:
                    ChromeDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
            }
        }
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }
}
