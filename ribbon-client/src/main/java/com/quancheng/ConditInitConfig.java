package com.quancheng;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty("ful.datasource.enabled")
public class ConditInitConfig {
    @Value("ful.datasource")
    private String datasource;

    public DatasourceConfig datasourceConfig(){
        System.err.println("datasource===>" + datasource);
        return new DatasourceConfig();
    }
}
