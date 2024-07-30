package com.ams.utils;

import com.ams.objectsRepos.obejctReader.ObjectRepoReader;
import org.openqa.selenium.By;

public final class RepoUtils {

    private static final String USER_DIRECTORY=System.getProperty("user.dir");

    private static final String FILE_PATH="/src/main/java/com/ams/objectsRepos/";

    private static final String FILE_EXTENSION =".xml";

    public static By getLocatorValue(String elementName,String pageName){
        String DATA_FILE=USER_DIRECTORY+FILE_PATH+pageName+FILE_EXTENSION;
        return ObjectRepoReader.getElementLocator(elementName,DATA_FILE);
    }
}
