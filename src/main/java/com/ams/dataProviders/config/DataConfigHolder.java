package com.ams.dataProviders.config;

import org.aeonbits.owner.ConfigFactory;




public final class DataConfigHolder {

    private static final DataConfig INSTANCE= ConfigFactory.create(DataConfig.class);

    private DataConfigHolder(){}

    public static DataConfig getInstance(){
        return INSTANCE;
    }

}
