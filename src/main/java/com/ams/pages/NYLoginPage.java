package com.ams.pages;

import com.ams.locatorClient.LocatorProviderClient;
import com.ams.reports.reportsManager.AmsExtentLogger;

import static com.ams.utils.WaiterFactory.waitFor;

public class NYLoginPage {

    private static final String pageName= "NYLoginPage";

    public void clickOnLoginButton(){
        waitFor(()-> LocatorProviderClient.element("LoginBtn",pageName).isDisplayed());
        LocatorProviderClient.element("LoginBtn",pageName).click();
        AmsExtentLogger.info("Click on Login Button on Homepage");
    }

    public void enterEmailAddress(String EmailAddress){
        waitFor(()-> LocatorProviderClient.element("EmailText",pageName).isDisplayed());
        LocatorProviderClient.element("EmailText",pageName).sendKeys(EmailAddress);
        AmsExtentLogger.info("Enter Email Address");
    }

    public void clickOnContinueButton(){
        waitFor(()-> LocatorProviderClient.element("ContinueBtn",pageName).isDisplayed());
        LocatorProviderClient.element("ContinueBtn",pageName).click();
        AmsExtentLogger.info("Click on Continue Button on Login");
    }



    public void enterPassword(String Password){
        waitFor(()-> LocatorProviderClient.element("PasswordTxt",pageName).isDisplayed());
        LocatorProviderClient.element("PasswordTxt",pageName).sendKeys(Password);
        AmsExtentLogger.info("Entered Password");
    }

    public void clickOnNYLoginButton(){
        waitFor(()-> LocatorProviderClient.element("LoginBtn1",pageName).isDisplayed());
        LocatorProviderClient.element("LoginBtn1",pageName).click();
        AmsExtentLogger.info("Click on Login Button on LoginPage");
    }

    public void clickOnContinueWithoutSubscribingButton(){
        waitFor(()-> LocatorProviderClient.element("ContinueWithoutSubscribing",pageName).isDisplayed());
        LocatorProviderClient.element("ContinueWithoutSubscribing",pageName).click();
        AmsExtentLogger.info("Click on Continue Button without subscribing");
    }

    public String getAlertMessageText(){
        waitFor(()-> LocatorProviderClient.element("invalidLoginAlert",pageName).isDisplayed());
        String alertMessage = LocatorProviderClient.element("invalidLoginAlert",pageName).getText();
        AmsExtentLogger.info("Getting Alert message for invalid credentials as:" +alertMessage);
        return alertMessage;
    }

}
