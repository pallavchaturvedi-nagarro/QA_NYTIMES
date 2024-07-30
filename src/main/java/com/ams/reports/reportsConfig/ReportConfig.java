package com.ams.reports.reportsConfig;

import org.aeonbits.owner.Config;

@Config.Sources(value = "file:${user.dir}/src/main/java/com/ams/reports/reportData/reportConfig.properties")
public interface ReportConfig extends Config {

    @Key("reportURL")
    @DefaultValue("/AmsReports/")
    String getReportsPath();


    @Key("reportName")
    @DefaultValue("SmokeTest")
    String getReportName();
}
