package com.ams.utils;

import com.ams.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public final class ScreensShotUtils {

    private ScreensShotUtils(){

    }

    public static String getScreenshotAsBase64(){
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
    }
}
