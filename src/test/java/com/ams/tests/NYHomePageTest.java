package com.ams.tests;
import com.ams.dataProviders.NYHomePageTestDataProvider;
import com.ams.frameworkannotations.TestDetails;
import com.ams.listeners.AmsListeners;
import com.ams.pages.NYHomePage;
import com.ams.tests.amsbase.AmsBaseTest;
import com.ams.utils.CommonUtil;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(AmsListeners.class)
public class NYHomePageTest extends AmsBaseTest{

        NYHomePage nyHomePage;

        public NYHomePageTest(){
            nyHomePage=new NYHomePage();
        }

        @TestDetails(author={"Pallav"})
        @Test
        public void validateDate(){
           String applicationDate = nyHomePage.getTodayDate();
           String calculatedDate = CommonUtil.getSystemDate();
           softAssert.assertEquals(applicationDate,calculatedDate);
           softAssert.assertAll("Date not Matched");
        }

        @TestDetails(author={"Pallav"})
        @Test(dataProvider = "NYHomePageData", dataProviderClass = NYHomePageTestDataProvider.class,groups = {"smoke","sanity"})
        public void validatePageNavigationOnClick(String expectedTitle){
            nyHomePage.hoverOnUS();
            nyHomePage.clickOnNewYorkCity();
            softAssert.assertEquals(nyHomePage.getTitleOfNewYorkPage(),expectedTitle);
            softAssert.assertAll("Page Incorrectly navigated");
    }
}
