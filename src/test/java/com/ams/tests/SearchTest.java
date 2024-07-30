package com.ams.tests;

import com.ams.dataProviders.SearchTestDataProvider;
import com.ams.frameworkannotations.TestDetails;
import com.ams.listeners.AmsListeners;
import com.ams.pages.SearchPage;
import com.ams.tests.amsbase.AmsBaseTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(AmsListeners.class)
public class SearchTest extends AmsBaseTest {

    SearchPage searchPage;

  public SearchTest(){
      searchPage=new SearchPage();
 }

    @TestDetails(author={"Pallav"})
    @Test(dataProvider = "SearchData",dataProviderClass = SearchTestDataProvider.class,groups = {"smoke","sanity"})
    public void validateSearchFunctionality(String searchInputText, String expectedSearchResultText){
        searchPage.clickOnSearchBtn();
        searchPage.enterTextInSearchBox(searchInputText);
        searchPage.clickOnSubmitBtn();
        softAssert.assertTrue(searchPage.getSearchResult().contains(expectedSearchResultText));
        softAssert.assertAll("Result fetched but Count not matched");

    }
}
