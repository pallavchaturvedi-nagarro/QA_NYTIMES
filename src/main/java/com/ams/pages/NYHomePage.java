package com.ams.pages;
import com.ams.locatorClient.LocatorProviderClient;
import com.ams.reports.reportsManager.AmsExtentLogger;
import com.ams.utils.CommonUtil;
import org.openqa.selenium.WebElement;

import static com.ams.utils.WaiterFactory.waitFor;

public class NYHomePage {

    private static final String pageName = "NYHomePage";

    public String getTodayDate() {
        waitFor(() -> LocatorProviderClient.element("dateField", pageName).isDisplayed());
        String appearingDate = LocatorProviderClient.element("dateField", pageName).getText();
        return appearingDate;
    }

    public void hoverOnUS() {
        waitFor(() -> LocatorProviderClient.element("USDropdown", pageName).isDisplayed());
        WebElement ele = LocatorProviderClient.element("USDropdown", pageName);
        CommonUtil.hoverOnElement(ele);
        AmsExtentLogger.info("Click on US Dropdown");
    }

    public void clickOnNewYorkCity() {
        waitFor(() -> LocatorProviderClient.element("NewYorkSection", pageName).isDisplayed());
        LocatorProviderClient.element("NewYorkSection", pageName).click();
        AmsExtentLogger.info("Click on New York Section");
    }


    public String getTitleOfNewYorkPage() {
        waitFor(() -> LocatorProviderClient.element("NewYorkTitle", pageName).isDisplayed());
        String pageTitle = LocatorProviderClient.element("NewYorkTitle", pageName).getText();
        AmsExtentLogger.info("Navigated to New York page , Getting the Title of Page");
        return pageTitle;
    }

    public String getTitleOfHomePage() {
        waitFor(() -> LocatorProviderClient.element("Title", pageName).isDisplayed());
        String pageTitle = LocatorProviderClient.element("Title", pageName).getText();
        AmsExtentLogger.info("Navigated to Home page , Getting the Title of Page");
        return pageTitle;
    }


}


