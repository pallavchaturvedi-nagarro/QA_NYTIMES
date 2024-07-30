package com.ams.reports.reportsManager;

import com.aventstack.extentreports.ExtentTest;

public final class AmsExtentManager {

    private AmsExtentManager(){
    }

    private static final ThreadLocal<ExtentTest>exeTest=new ThreadLocal<>();


     static ExtentTest getExtentTest(){
        return exeTest.get();
    }

     static void setExtentTest(ExtentTest extentTest){
        exeTest.set(extentTest);
    }

     static void unloadExtentTest(){
        exeTest.remove();
    }
}
