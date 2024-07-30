package com.ams.config;

import org.aeonbits.owner.ConfigFactory;

public final class AmsConfigFactory {

    private AmsConfigFactory(){}
    public static AmsFrameworkConfig getConfig(){
        return ConfigFactory.create(AmsFrameworkConfig.class);
    }
}
