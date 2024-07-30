package com.ams.utils;

import com.ams.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public final class CommonUtil {

    private CommonUtil(){

    }

    public static String getSystemDate(){
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
        return currentDate.format(formatter);

    }

public static void hoverOnElement(WebElement ele){
    Actions actions = new Actions(DriverManager.getDriver());
    actions.moveToElement(ele).perform();

    }

}
