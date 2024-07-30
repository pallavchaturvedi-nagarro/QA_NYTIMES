package com.ams.utils;

import com.ams.driver.DriverManager;
import com.ams.enums.WaitStrategy;
import com.ams.locatorClient.LocatorProviderClient;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class ExplicitWait {

    private ExplicitWait(){}

    public static void performExplicitWait(String elementName, String pageName, WaitStrategy waitStrategy){
        By locatorValue= RepoUtils.getLocatorValue(elementName,pageName);
        WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(Long.parseLong("10")));
        if(waitStrategy==WaitStrategy.CLICKABLE){
            wait.until(ExpectedConditions.elementToBeClickable(locatorValue));
        } else if (waitStrategy==WaitStrategy.PRESENCE) {
            wait.until(ExpectedConditions.presenceOfElementLocated(locatorValue));
        } else if (waitStrategy==WaitStrategy.VISIBLE) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locatorValue));
        } else if (waitStrategy==WaitStrategy.NONE) {
            System.out.println("Not need to wait");
        }
    }
}
