package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenCapture {

    public String timeStampGenerator(){
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH_mm_ss");
        LocalDateTime now = LocalDateTime.now();
        return df.format(now);

    }

    public void CaptureScreenShot(WebDriver driver){
        try{
            TakesScreenshot sc = (TakesScreenshot)driver;
            File captured_sc=sc.getScreenshotAs(OutputType.FILE);
            String filePath = System.getProperty("user.dir")+"/ScreenShots/";
            FileUtils.copyFile(captured_sc,new File(filePath+timeStampGenerator()+".png"));


        }catch (Exception e){
            System.out.println("error in capture screenshot : "+e.getMessage());
        }

        }



    }

