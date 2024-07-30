package com.ams.driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

    private DriverManager(){}
    private static ThreadLocal<WebDriver>threadLocal=new ThreadLocal<>();

    public static WebDriver getDriver(){
        return threadLocal.get();
    }

    static void setDriver(WebDriver driver){
        threadLocal.set(driver);
    }

    static void removeDriver(){
        threadLocal.remove();
    }
}
