package com.ams.dataProviders;

import com.ams.dataProviders.config.DataConfigHolder;
import com.ams.utils.CsvUtil;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.List;

public class NYHomePageTestDataProvider {
    private static final String FILE_PATH= DataConfigHolder.getInstance().csvFilePath();
    private static final String USER_DIRECTORY= System.getProperty("user.dir");

    private static final String FILE_NAME="NYHomePageData.csv";

    private static final String DATA_FILE=USER_DIRECTORY+FILE_PATH+FILE_NAME;

    private NYHomePageTestDataProvider(){}

    @DataProvider(name="NYHomePageData")
    public static Object [][] credentials(Method method)
    {
        Object[][] data = null;
        try{
            List<String[]> csvData= CsvUtil.reader(method.getName(),DataConfigHolder.getInstance().csvDelimiter(), DATA_FILE);
            data = csvData.toArray(new String[csvData.size() - 1][]);
        }catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }
}
