package com.ams.reports.reportsConfig;

import org.aeonbits.owner.ConfigFactory;

public final class ReportConfigHolder {

    private ReportConfigHolder(){}

    private static final ReportConfig INSTANCE= ConfigFactory.create(ReportConfig.class);

    public static ReportConfig getInstance(){
        return INSTANCE;
    }
}
