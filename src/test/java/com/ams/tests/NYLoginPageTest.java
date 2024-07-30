package com.ams.tests;

import com.ams.dataProviders.NYHomePageTestDataProvider;
import com.ams.dataProviders.NYLoginPageTestDataProvider;
import com.ams.frameworkannotations.TestDetails;
import com.ams.listeners.AmsListeners;
import com.ams.pages.NYHomePage;
import com.ams.pages.NYLoginPage;
import com.ams.tests.amsbase.AmsBaseTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(AmsListeners.class)
public class NYLoginPageTest extends AmsBaseTest {

    NYLoginPage nyLoginPage;
    NYHomePage nyHomePage;


    public NYLoginPageTest(){
        nyHomePage=new NYHomePage();
        nyLoginPage=new NYLoginPage();
    }


    @TestDetails(author = {"Pallav"})
    @Test(dataProvider = "NYLoginPageData",dataProviderClass = NYLoginPageTestDataProvider.class,groups = {"smoke","sanity"})
    public void verifyNYLoginFunctionality(String userName,String password, String expectedHomePageTitle)
    {
        nyLoginPage.clickOnLoginButton();
        nyLoginPage.enterEmailAddress(userName);
        nyLoginPage.clickOnContinueButton();
        nyLoginPage.enterPassword(password);
        nyLoginPage.clickOnNYLoginButton();
        nyLoginPage.clickOnContinueWithoutSubscribingButton();
        String homePageTitle= nyHomePage.getTitleOfHomePage();
        softAssert.assertEquals(homePageTitle,expectedHomePageTitle);
        softAssert.assertAll("Login Succedded but navigation failed");

    }

    @TestDetails(author = {"Pallav"})
    @Test(dataProvider = "NYLoginPageData",dataProviderClass = NYLoginPageTestDataProvider.class,groups = {"smoke","sanity"})
    public void verifyLoginFunctionalityUsingInvalidCredentials(String userName,String password, String expectedAlertMessage)
    {
        nyLoginPage.clickOnLoginButton();
        nyLoginPage.enterEmailAddress(userName);
        nyLoginPage.clickOnContinueButton();
        nyLoginPage.enterPassword(password);
        nyLoginPage.clickOnNYLoginButton();
        softAssert.assertEquals(nyLoginPage.getAlertMessageText(),expectedAlertMessage);
        softAssert.assertAll("Not Found");

    }
}
