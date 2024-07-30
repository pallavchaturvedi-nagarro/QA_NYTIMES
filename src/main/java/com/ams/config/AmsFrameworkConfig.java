package com.ams.config;

import org.aeonbits.owner.Config;

@Config.Sources(value = "file:${user.dir}/src/main/resources/config/AmsConfig.properties")
public  interface AmsFrameworkConfig extends Config {

    @Key("URL")
    String url();

    @Key("Browser")
    String browser();

    @Key("TimeOuts")
    Long timeouts();
}
