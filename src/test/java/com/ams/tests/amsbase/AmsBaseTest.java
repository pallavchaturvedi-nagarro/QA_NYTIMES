package com.ams.tests.amsbase;

import com.ams.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class AmsBaseTest {

    protected AmsBaseTest(){

    }
    protected SoftAssert softAssert;
    @BeforeMethod
    public void setup(){
        Driver.initDriver();
        softAssert=new SoftAssert();
    }

    @AfterMethod
    public void teardown(){
        Driver.quitDriver();
    }
}
