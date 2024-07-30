package com.ams.utils;

import com.ams.utils.FrameworksExceptions.AutomationFrameworkException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public final class CsvUtil {

    private CsvUtil(){

    }

    public static List<String[]> reader(String testName,String seprator, String fileName){
      List<String[]> dataArr=new ArrayList<>();
      String [] values;
      String line;
      List<String[]> strArray= null;

      File file=new File(fileName);

      try(BufferedReader bufferedReader=new BufferedReader(new FileReader(file))){
          while (null != (line=bufferedReader.readLine())){
              if((testName.equals(line.substring(0,line.indexOf(seprator)))) || testName.isEmpty()){
                  if(!testName.isEmpty()) {
                      line = line.substring(line.indexOf(seprator) + 1);
                  }
                  values=line.replace("\"","").split(seprator);
                  dataArr.add(values);
                  strArray=dataArr;
              }
          }
      }catch(FileNotFoundException ex){
        throw new AutomationFrameworkException("Cannot find the CSV file at " + fileName);
      }
      catch (IOException ex){
          throw new AutomationFrameworkException("Exception occurred while reading the csv for data : "+ex.getMessage());
      }
      if(null==strArray){
          throw new AutomationFrameworkException("Something wrong in either CSV file or parameters are sent wrong.");
      }
    return strArray;
    }
}
