package com.ams.reports.reportsManager;

import com.ams.utils.ScreensShotUtils;
import com.aventstack.extentreports.MediaEntityBuilder;

public final class AmsExtentLogger {

    private AmsExtentLogger(){}

    public static void pass(String message){
        AmsExtentManager.getExtentTest().pass(message);
    }

    public static void fail(String message){
        AmsExtentManager.getExtentTest().fail(message);
    }

    public static void skip(String message){
        AmsExtentManager.getExtentTest().skip(message);
    }

    public static void info(String message){
        AmsExtentManager.getExtentTest().info(message);
    }

    public static void pass(String message,boolean isScreenshotNeeded){
        if(isScreenshotNeeded){
            AmsExtentManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreensShotUtils.getScreenshotAsBase64()).build());
        }else{
            pass(message);
        }
    }

    public static void fail(String message,boolean isScreenshotNeeded){
        if(isScreenshotNeeded){
            AmsExtentManager.getExtentTest().fail(message,MediaEntityBuilder.createScreenCaptureFromBase64String(ScreensShotUtils.getScreenshotAsBase64()).build());
        }else {
            fail(message);
        }
    }

    public static void skip(String message,boolean isScreenshotNeeded){
        if(isScreenshotNeeded){
            AmsExtentManager.getExtentTest().skip(message,MediaEntityBuilder.createScreenCaptureFromBase64String(ScreensShotUtils.getScreenshotAsBase64()).build());
        }else {
            skip(message);
        }
    }
}
