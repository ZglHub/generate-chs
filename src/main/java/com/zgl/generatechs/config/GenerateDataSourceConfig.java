package com.zgl.generatechs.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author zgl
 * @Date 2020/4/12 12:28
 * @Version 1.0
 **/
@Data
@Component
@ConfigurationProperties(prefix = "spring.datasource")
public class GenerateDataSourceConfig {

    private String driverClassName;

    private String url;

    private String name;

    private String password;

}
