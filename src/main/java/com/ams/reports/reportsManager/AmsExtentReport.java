package com.ams.reports.reportsManager;

import com.ams.reports.reportsConfig.ReportConfigHolder;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.util.Objects;

public final class AmsExtentReport {

    private static final String USER_DIRECTORY=System.getProperty("user.dir");

    private static final String File_Path= ReportConfigHolder.getInstance().getReportsPath();

    private static final String Report_Name=ReportConfigHolder.getInstance().getReportName()+".html";

    private static final String Report_Path=USER_DIRECTORY+File_Path+Report_Name;

    private static ExtentReports extentReports;


    private AmsExtentReport(){}

    public static void initReports(){
        if(Objects.isNull(extentReports)){
           extentReports=new ExtentReports();
           ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter(Report_Path);
           extentReports.attachReporter(extentSparkReporter);
           extentSparkReporter.config().setTheme(Theme.STANDARD);
           extentSparkReporter.config().setReportName("Ams Smoke Test");
           extentSparkReporter.config().setDocumentTitle("Ams Automation Report");
        }
    }

    public static void flushReports(){
        if(Objects.nonNull(extentReports)){
            extentReports.flush();
        }
    }

    public static  void createTest(String testCaseName,String []tagName,String []authorName){
        if(Objects.nonNull(extentReports)) {
            ExtentTest extentTest= extentReports.createTest(testCaseName).assignCategory(tagName).assignAuthor(authorName);
            AmsExtentManager.setExtentTest(extentTest);
        }
    }


}
