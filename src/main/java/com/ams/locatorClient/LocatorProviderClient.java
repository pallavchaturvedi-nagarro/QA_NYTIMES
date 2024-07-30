package com.ams.locatorClient;

import com.ams.driver.DriverManager;
import com.ams.enums.WaitStrategy;
import com.ams.utils.ExplicitWait;
import com.ams.utils.RepoUtils;
import com.ams.utils.Sleeper;
import org.openqa.selenium.WebElement;

import java.util.List;

public final class LocatorProviderClient {

    private LocatorProviderClient(){
    }


    public static WebElement element(String elementName,String pageName){
        Sleeper.silentSleep(2000);
        return DriverManager.getDriver().findElement(RepoUtils.getLocatorValue(elementName,pageName));
    }

    public static WebElement element(String elementName, String pageName, WaitStrategy waitStrategy){
        ExplicitWait.performExplicitWait(elementName,pageName,waitStrategy);
        return DriverManager.getDriver().findElement(RepoUtils.getLocatorValue(elementName,pageName));
    }

    public static List<WebElement> elements(String elementName,String pageName){
        Sleeper.silentSleep(2000);
        return DriverManager.getDriver().findElements(RepoUtils.getLocatorValue(elementName,pageName));
    }

    public static String getTitle(){
        Sleeper.silentSleep(2000);
        return DriverManager.getDriver().getTitle();
    }


}
