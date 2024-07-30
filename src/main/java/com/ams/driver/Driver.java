package com.ams.driver;

import com.ams.config.AmsConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Objects;

public final class Driver {

   private Driver(){}

    public static void initDriver(){
        String browserName=AmsConfigFactory.getConfig().browser();
        if(Objects.isNull(DriverManager.getDriver())) {
            WebDriver driver = DriverFactory.setupBrowser(browserName);
            DriverManager.setDriver(driver);
            DriverManager.getDriver().manage().window().maximize();
            DriverManager.getDriver().manage().deleteAllCookies();
            DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(AmsConfigFactory.getConfig().timeouts()));
            DriverManager.getDriver().get(AmsConfigFactory.getConfig().url());
        }
    }

    public static void quitDriver(){
       if(Objects.nonNull(DriverManager.getDriver())) {
           DriverManager.getDriver().quit();
           DriverManager.removeDriver();
       }
    }
}
