package com.ams.pages;

import com.ams.locatorClient.LocatorProviderClient;
import com.ams.reports.reportsManager.AmsExtentLogger;

import static com.ams.utils.WaiterFactory.waitFor;

public class SearchPage {

    private static final String pageName="SearchPage";

    public void clickOnSearchBtn(){
        LocatorProviderClient.element("SearchBtn",pageName).click();
        AmsExtentLogger.info("Clicked On Search Button");
    }

    public void enterTextInSearchBox(String textDescription){
        waitFor(()->LocatorProviderClient.element("SearchBox",pageName).isDisplayed());
        LocatorProviderClient.element("SearchBox",pageName).sendKeys(textDescription);
        AmsExtentLogger.info("Enter the Topic Description as:- "+textDescription+" -:on Topic Field");
    }
    public void clickOnSubmitBtn(){
        LocatorProviderClient.element("SearchSubmitBtn",pageName).click();
        AmsExtentLogger.info("Clicked On Submit Button");
    }

    public String getSearchResult(){
        waitFor(()->LocatorProviderClient.element("SearchResult",pageName).isDisplayed());
       String result =  LocatorProviderClient.element("SearchResult",pageName).getText();
        AmsExtentLogger.info("Get the Search Text as :- " +result);
        return result;
    }


}
