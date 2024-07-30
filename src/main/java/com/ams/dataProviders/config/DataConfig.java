package com.ams.dataProviders.config;

import org.aeonbits.owner.Config;

@Config.Sources(value = "file:${user.dir}/src/test/resources/config/DataConfig.properties")
public interface DataConfig extends Config {

    @Key("CsvDelimiter")
    @DefaultValue(",")
    String csvDelimiter();

    @Key("csvFilePath")
    String csvFilePath();



}
