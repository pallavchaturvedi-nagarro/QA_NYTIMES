package com.ams.listeners;

import com.ams.frameworkannotations.TestDetails;
import com.ams.reports.reportsManager.AmsExtentLogger;
import com.ams.reports.reportsManager.AmsExtentReport;
import org.testng.*;

import java.util.Arrays;

public class AmsListeners implements ITestListener, ISuiteListener {
    @Override
    public void onStart(ISuite suite){
        AmsExtentReport.initReports();
    }

    @Override
    public void onFinish(ISuite suite){
        AmsExtentReport.flushReports();
    }

    @Override
    public void onTestStart(ITestResult result){
        AmsExtentReport.createTest(result.getMethod().getMethodName(),result.getMethod().getGroups(),
                result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(TestDetails.class).author());
    }

    @Override
    public void onTestSuccess(ITestResult result){
        AmsExtentLogger.pass(result.getMethod().getMethodName() +" is passed");
    }

    @Override
    public void onTestFailure(ITestResult result){
        AmsExtentLogger.fail(result.getMethod().getMethodName() +" is failed");
        //attach screenshot
        AmsExtentLogger.fail(result.getMethod().getMethodName(),true);
        AmsExtentLogger.fail(result.getThrowable().toString());
        AmsExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
    }

    @Override
    public void onTestSkipped(ITestResult result){
        AmsExtentLogger.skip(result.getMethod().getMethodName() +" is skipped");
        AmsExtentLogger.skip(result.getMethod().getMethodName() ,true);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result){
          /*
           * for now, we are not using it.
           */
    }

    @Override
    public void onStart(ITestContext context) {
        /*
         * for now , we are not using it.
         */
    }

    @Override
    public void onFinish(ITestContext context) {
        /*
         * for now , we are not using it.
         */
    }
}
